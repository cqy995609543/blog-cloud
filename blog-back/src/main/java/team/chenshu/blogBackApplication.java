package team.chenshu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author yu
 * @date 2021/12/1 - 0:00
 * @Content:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class blogBackApplication {
	public static void main(String[] args) {
		SpringApplication.run(blogBackApplication.class, args);
	}
}
