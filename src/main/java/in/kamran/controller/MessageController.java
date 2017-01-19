package in.kamran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	@Autowired
	private StringRedisTemplate template;
	
	@RequestMapping(method=RequestMethod.POST, path="/send")
	public String receiveMessage(String message){
		
		template.convertAndSend("chat", "Hello from " + message);
		return "messageReceived";
	}
}

