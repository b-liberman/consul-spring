package boris.test.consul.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.endpoint.event.RefreshEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
public class FirstTest {

	private String json;
	
	@Value("${key1}")
	private String value1;
	
	@Value("${key2}")
	private String value2;
	
	@Value("${key3}")
	private String value3;
	
	@Value("${nkey3.n2}")
	private Object nkey;


	
	@Value("${props.json}")
	public void setJson(String json) {
		this.json = json;
		System.out.println("new json: " + this.json);
	}

	@EventListener({ RefreshEvent.class })
	void onEndpointRefreshed(RefreshEvent re) {
	}
	

	@Scheduled(fixedDelay = 1000)
	private void run() throws Exception {
//		System.out.println(json);
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);		
		System.out.println(nkey);
	}
}
