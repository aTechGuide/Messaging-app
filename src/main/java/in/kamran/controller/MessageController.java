package in.kamran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.kamran.service.ICommentService;
import in.kamran.util.Comment;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
public class MessageController {

	@Autowired
	private ICommentService service;

	@RequestMapping(method = RequestMethod.POST, path = "/comment")
	@ApiOperation(value = "This API is used to post comments")
	public String addComments(
			@ApiParam(value = "Comment that need to be posted", required = true) @RequestBody Comment comment) {
		return service.addComments(comment.getComment());
	}

	@RequestMapping(method = RequestMethod.GET, path = "/lastestfive")
	@ApiOperation(value = "This API is used to fetch last five comments")
	public String getFirstFiveComments() {
		return service.getFirstFiveComments();
	}
}
