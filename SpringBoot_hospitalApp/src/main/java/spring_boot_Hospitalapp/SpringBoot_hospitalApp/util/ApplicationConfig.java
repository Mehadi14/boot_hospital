package spring_boot_Hospitalapp.SpringBoot_hospitalApp.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class ApplicationConfig {

	public Docket getDocket() {
		springfox.documentation.service.Contact contact = new springfox.documentation.service.Contact("ty", "www.tyffh",
				"ty@hn8");

		List<VendorExtension> list = new ArrayList<>();

		ApiInfo apiInfo = new ApiInfo("hospital app", "hopsital v.0.4", "version .1", "www.ty.com", contact, "ghj", "tyui", list);

		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("spring_boot_Hospitalapp.SpringBoot_hospitalApp")).build()
				.apiInfo(apiInfo).useDefaultResponseMessages(false);

	}
}
