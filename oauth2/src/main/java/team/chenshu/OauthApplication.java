package team.chenshu;

/**
 * @author yu
 * @date 2021/12/18 - 17:47
 * @Content:
 */
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EntityScan("team.chenshu.pojo")
@MapperScan("team.chenshu.dao")
public class OauthApplication {
	public static void main(String[] args) {
		SpringApplication.run(OauthApplication.class, args);
	}
}
