package boris.test.consul.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.vault.annotation.VaultPropertySource;
import org.springframework.vault.annotation.VaultPropertySource.Renewal;

@SpringBootApplication
@EnableScheduling
@VaultPropertySource(value = "secret/csct", renewal = Renewal.ROTATE)
@EnableBinding(KafkaComDef.class)
public class ConfigApplication {

	public static void main(String[] args) {		
		SpringApplication.run(ConfigApplication.class, args);
	}
}
