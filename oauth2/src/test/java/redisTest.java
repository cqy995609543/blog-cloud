import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import team.chenshu.OauthApplication;
import team.chenshu.Utils.RedisUtils;

import javax.annotation.Resource;

/**
 * @author yu
 * @date 2021/12/26 - 15:15
 * @Content:
 */
@Component
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OauthApplication.class)
public class redisTest {


	@Autowired
	private RedisTemplate redisTemplate;
	@Resource
	private RedisUtils redisUtils;

    @Test
	public void getKey(){
//		Object test = redisUtils.get("test");
//		Object test1 = redisTemplate.opsForValue().get("test");
//		Boolean aBoolean = redisTemplate.hasKey("test");
//		RedisConnectionFactory connectionFactory = redisTemplate.getConnectionFactory();
		redisTemplate.opsForValue().set("ok","ok123");
		Object test2 = redisTemplate.opsForValue().get("ok");
		Object test1 = redisTemplate.opsForValue().get("test");
		redisUtils.add("ojbk","wahahah");
		Object ojbk = redisUtils.get("ojbk");
//		System.out.println(connectionFactory.toString());
	}


	/**
	 * 普通缓存获取
	 *
	 * @param key
	 *            键
	 * @return 值
	 */
	public Object get(String key) {
		return key == null ? null : redisTemplate.opsForValue().get(key);
	}





}
