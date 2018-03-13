package boris.test.consul.config;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KafkaComDef {
	

//	@Input
//	SubscribableChannel inputT();
	
	@Output
	MessageChannel outputT();
	
	@Input
	KStream<?, String> inputTStream();

	@Output
	KStream<?, String> outputTStream();
}
