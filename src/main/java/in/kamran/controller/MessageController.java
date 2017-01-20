package in.kamran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.kamran.service.ICommentService;

@RestController
public class MessageController {

	@Autowired
	private ICommentService service;
	
	@RequestMapping(method = RequestMethod.POST, path = "/comment")
	public String addComments(String comment) {
		return service.addComments(comment);
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/lastestfive")
	public String getFirstFiveComments() {
		return service.getFirstFiveComments();
	}
}
