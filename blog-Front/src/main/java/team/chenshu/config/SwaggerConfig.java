//package team.chenshu.config;
//
///**
// * @author yu
// * @date 2021/12/11 - 12:51 各个服务的swagger配置文件
// * @Content:
// */
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.builders.RequestParameterBuilder;
//import springfox.documentation.oas.annotations.EnableOpenApi;
//import springfox.documentation.schema.ScalarType;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.ParameterType;
//import springfox.documentation.service.RequestParameter;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.Collections;
//import java.util.List;
//
//@Configuration
//@EnableOpenApi
//public class SwaggerConfig {
//
//	@Bean
//	public Docket createRestApi() {
//		return new Docket(DocumentationType.OAS_30)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("team.chenshu.controller"))
//				.paths(PathSelectors.any())
//				.build()
//				.globalRequestParameters(globalRequestParameters())
//				.apiInfo(apiInfo());
//	}
//
//	private List<RequestParameter> globalRequestParameters() {
//		RequestParameterBuilder parameterBuilder = new RequestParameterBuilder().in(ParameterType.HEADER).name("Token").required(false).query(param -> param.model(model -> model.scalarModel(ScalarType.STRING)));
//		return Collections.singletonList(parameterBuilder.build());
//	}
//
//	private ApiInfo apiInfo() {
//		return new ApiInfoBuilder()
//				.title("博客API")
//				.description("博客管理文档API")
//				.termsOfServiceUrl("http://127.0.0.1:8200/")
//				.version("1.0")
//				.build();
//	}
//}