package team.chenshu.config;

import com.google.common.collect.Lists;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfiguration {

	@Bean(value = "defaultApi2")
	public Docket defaultApi2() {
		Docket docket=new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfoBuilder()
						.title("博客接口文档 RESTful APIs")
						.description("博客接口文档")
						.termsOfServiceUrl("http://www.chenshu.team/")
						.version("1.0")
						.build())
				//分组名称
				.groupName("2.X版本")
				.select()
				//这里指定Controller扫描包路径
				.apis(RequestHandlerSelectors.basePackage("team.chenshu.controller"))
				.paths(PathSelectors.any())
				.build()
				//整合oauth2
				.securityContexts(securityContexts())
				.securitySchemes(securitySchemes());
		return docket;
	}



	/**
	 * Swagger2 认证的安全上下文
	 *
	 * @return
	 */
	private List<SecurityContext> securityContexts() {
		List<AuthorizationScope> scopes = new ArrayList<>();
		SecurityReference securityReference = new SecurityReference("oauth2", scopes.toArray(new AuthorizationScope[]{}));
		SecurityContext securityContext = new SecurityContext(Lists.newArrayList(securityReference), PathSelectors.ant("/**"));
		return Lists.newArrayList(securityContext);
	}

	/**
	 * OAuth2.0 的认证方式
	 *
	 * @return
	 */
	private List<SecurityScheme> securitySchemes() {
		// 使用密码模式（password）
		List<GrantType> grantTypes = new ArrayList<>();
		String passwordTokenUrl = "http://localhost:8004/oauth/token";
		ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(passwordTokenUrl);
		grantTypes.add(resourceOwnerPasswordCredentialsGrant);
		OAuth oAuth = new OAuthBuilder().name("oauth2").grantTypes(grantTypes).build();
		return Lists.newArrayList(oAuth);
	}

}