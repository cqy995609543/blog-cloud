package team.chenshu;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
/**
 * @author yu
 * @date 2021/11/30 - 23:03
 * @Content:
 */
@SpringBootApplication
@EnableDiscoveryClient
public class blogFrontApplication {

	public static void main(String[] args) {
		SpringApplication.run(blogFrontApplication.class, args);
	}

}
