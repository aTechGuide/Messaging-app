package in.kamran.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import in.kamran.util.Constants;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements ICommentService {

	@Autowired
	private StringRedisTemplate repository;
	private final Integer SIZE = 5;

	@Override
	public String addComments(String comment) {
		if (repository.opsForList().size(Constants.COMMENTS.getValue()) < SIZE) {
			repository.opsForList().leftPush(Constants.COMMENTS.getValue(), comment);
			log.debug("If CommentAdded: " + comment);
		} else {
			repository.opsForList().leftPush(Constants.COMMENTS.getValue(), comment);
			String removed = repository.opsForList().rightPop(Constants.COMMENTS.getValue());
			log.debug("CommentAdded: " + comment);
			log.debug("CommentRemoved: " + removed);
		}
		repository.convertAndSend(Constants.COMMENTS.getValue(), "Received Comment: " + comment);
		return comment + ": Added to DB";
	}

	@Override
	public String getFirstFiveComments() {
		return repository.opsForList().range(Constants.COMMENTS.getValue(), 0, 10).toString();
	}
}
