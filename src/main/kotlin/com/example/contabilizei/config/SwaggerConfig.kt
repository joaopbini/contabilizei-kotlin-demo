package com.example.contabilizei.config

import com.google.common.base.Predicates
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import springfox.documentation.RequestHandler
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.paths.RelativePathProvider
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@Configuration
@EnableSwagger2
@ComponentScan("com.example.contabilizei")
class SwaggerConfig {

    @Value("#{ @environment['pathProvider'] }")
    private val pathProvider: String = "/api"

    @Bean
    fun api(): Docket {

        return Docket(DocumentationType.SWAGGER_2)
                .groupName(CONTABILIZEI_SERVICE)
                .select()
                .apis(Predicates.not<RequestHandler>(RequestHandlerSelectors.basePackage(BASE_PACKAGE)))
                .build().pathProvider(object : RelativePathProvider(null) {
                    override fun getApplicationBasePath(): String {
                        return pathProvider
                    }
                })
                .apiInfo(apiInfo())
    }

    private fun apiInfo(): ApiInfo {

        return ApiInfoBuilder()
                .title(CONTABILIZEI_SERVICE)
                .description(CONTABILIZEI_SERVICE)
                .version("1.0")
                .contact(Contact("Contabilizei Inc.", "https://www.contabilizei.com.br", "sistema@contabilizei.com.br"))
                .build()
    }

    companion object {
        private const val CONTABILIZEI_SERVICE = "contabilizei-service"
        private const val BASE_PACKAGE = "org.springframework.boot"
    }

}
