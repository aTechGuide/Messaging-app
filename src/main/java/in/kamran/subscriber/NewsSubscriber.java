package in.kamran.subscriber;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NewsSubscriber implements ISubscriber{

	@Override
	public void receiveMessage(String message) {
		log.debug("Received <" + message + ">");
	}

}
