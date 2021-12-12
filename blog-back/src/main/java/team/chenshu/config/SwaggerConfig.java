//package team.chenshu.config;
//
//import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
//import com.google.common.base.Predicate;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.RequestHandler;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
///**
// * @author yu
// * @date 2021/12/11 - 12:51 各个服务的swagger配置文件
// * @Content:
// */
//
//
////启用swagger2
//
//
//
////启用swagger增强UI
//@Configuration
//@EnableSwagger2
//@EnableSwaggerBootstrapUI
//public class SwaggerConfig {
//
//	@Bean
//
//	public Docket createRestApi() {
//
//		return new Docket(DocumentationType.SWAGGER_2)
//
//				.select()
//
//				//这里写的是API接口所在的包位置
//
//				.apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("team.chenshu.controller"))
//
//				.paths((Predicate<String>) PathSelectors.any())
//
//				.build();
//
//	}
//
//}