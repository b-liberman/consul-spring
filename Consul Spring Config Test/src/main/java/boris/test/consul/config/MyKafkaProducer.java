package boris.test.consul.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyKafkaProducer {

	@Autowired
	private KafkaComDef comDef;
	
	private int i = 0;
	
	@Scheduled(fixedDelay = 1000)
	private void run() {
		boolean res = comDef.outputT().send(MessageBuilder.withPayload("test " + i).build());
		System.out.println("written message " + i++ + " with the result " + res);
	}
}
