//package team.chenshu.controller;
//
///**
// * @author yu
// * @date 2021/12/11 - 12:45 SwaggerResourceController类，提供swagger资源请求
// * @Content:
// */
//import io.swagger.annotations.Api;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import reactor.core.publisher.Mono;
//import springfox.documentation.swagger.web.*;
//import team.chenshu.config.SwaggerProvider;
//
//import java.util.List;
//import java.util.Optional;
//
//@Api(value = "/swagger-resources")
//@RestController
//@RequestMapping("/swagger-resources")
//public class SwaggerResourceController {
//
//	@Autowired(required = false)
//	private SecurityConfiguration securityConfiguration;
//
//	@Autowired(required = false)
//	private UiConfiguration uiConfiguration;
//
//	private final SwaggerProvider swaggerProvider;
//
//	@Autowired
//	public SwaggerResourceController(SwaggerProvider swaggerProvider) {
//		this.swaggerProvider = swaggerProvider;
//	}
//
//	@RequestMapping("/configuration/security")
//	public Mono<ResponseEntity<SecurityConfiguration>> securityConfiguration() {
//		return Mono.just(new ResponseEntity<>(
//				Optional.ofNullable(securityConfiguration).orElse(SecurityConfigurationBuilder.builder().build()), HttpStatus.OK));
//	}
//
//	@RequestMapping("/configuration/ui")
//	public Mono<ResponseEntity<UiConfiguration>> uiConfiguration() {
//		return Mono.just(new ResponseEntity<>(
//				Optional.ofNullable(uiConfiguration).orElse(UiConfigurationBuilder.builder().build()), HttpStatus.OK));
//	}
//
//	@RequestMapping
//	public Mono<ResponseEntity<List<SwaggerResource>>> swaggerResources() {
//		return Mono.just((new ResponseEntity<>(swaggerProvider.get(), HttpStatus.OK)));
//	}
//}
