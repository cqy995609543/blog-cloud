package team.chenshu.config;

/**
 * @author yu
 * @date 2021/12/27 - 21:31
 * @Content:
 */
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import team.chenshu.handler.AuthExceptionEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	@Value("${security.oauth2.client.client-id}")
	private String clientId;

	@Value("${security.oauth2.client.client-secret}")
	private String secret;

	@Value("${security.oauth2.authorization.check-token-access}")
	private String checkTokenEndpointUrl;

	@Autowired
	private RedisConnectionFactory redisConnectionFactory;

	@Autowired
	private AuthExceptionEntryPoint authExceptionEntryPoint;

	@Bean
	public TokenStore redisTokenStore() {
		return new RedisTokenStore(redisConnectionFactory);
	}

	@Bean
	public RemoteTokenServices tokenService() {
		RemoteTokenServices tokenService = new RemoteTokenServices();
		tokenService.setClientId(clientId);
		tokenService.setClientSecret(secret);
		tokenService.setCheckTokenEndpointUrl(checkTokenEndpointUrl);
		return tokenService;
	}

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.authenticationEntryPoint(authExceptionEntryPoint);
	}


	/**
	 * 配置资源接口安全，http.authorizeRequests()针对的所有url，但是由于登录页面url包含在其中，这里配置会进行token校验，校验不通过返回错误json，
	 * 而授权码模式获取code时需要重定向登录页面，重定向过程并不能携带token，所有不能用http.authorizeRequests()，
	 * 而是用requestMatchers().antMatchers("")，这里配置的是需要资源接口拦截的url数组
	 *
	 * @param http
	 * @return void
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception{
		//所有请求必须认证通过
//		http.authorizeRequests()
//				//下边的路径放行
//				.antMatchers("/**").permitAll().anyRequest().authenticated();

		http    //配置需要保护的资源接口
				.requestMatchers().
				antMatchers("/api/doc.html#/home")
				.and().authorizeRequests().anyRequest().authenticated();
	}

}
