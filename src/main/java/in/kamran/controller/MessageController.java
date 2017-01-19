package in.kamran.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.kamran.util.Constants;

@RestController
public class MessageController {

	@Autowired
	private StringRedisTemplate template;
	
	@RequestMapping(method=RequestMethod.POST, path="/publish")
	public String receiveMessage(String message){
		
		template.convertAndSend(Constants.CHAT.getValue(), "Hello from " + message);
		return "messageReceived";
	}
	
	@RequestMapping(method=RequestMethod.POST, path="/add")
	public String addToDB(String key, String value, Integer timeToExpire){
		
		template.opsForValue().set(key, value);
		template.expire( key, timeToExpire, TimeUnit.SECONDS );
		return key + " added to DB";
	}
	
	@RequestMapping(method=RequestMethod.GET, path="/get/{key}")
	public String getFromDB(@PathVariable String key){
		
		return template.opsForValue().get(key);
	}
}

