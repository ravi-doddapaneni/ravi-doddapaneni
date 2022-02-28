package org.neobank.profile.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.*;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.List;

@Configuration
public class SwaggerConfiguration {

    public static final String SERVICE_TAG = "Profile Management Service";
    public static final String TITLE_TAG = "Neobank-Retail-Profile-Service";
    public static final String DESCRIPTOIN_TAG = "A Profile domain microservice which is responsible for profile management of the customer.";

    @Bean
    public Docket generateApi()
    {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(getApiInfo())
                .tags(new Tag(SERVICE_TAG, SERVICE_TAG))
                .globalRequestParameters(getGlobalParameters())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .paths(PathSelectors.any())
                .build();
    }

    private List<RequestParameter> getGlobalParameters()
    {
        var correlationIdHeader = new RequestParameterBuilder()
                                                        .name("Correlation-ID")
                                                        .description("Relates all linked requests")
                                                        .required(false).in(ParameterType.HEADER)
                                                        .query(q ->q.model(m -> m.scalarModel(ScalarType.UUID)))
                                                        .build();
        return List.of(correlationIdHeader);
    }

    private ApiInfo getApiInfo()
    {
        return new ApiInfoBuilder()
                .title(TITLE_TAG)
                .version("1.0.0")
                .description(DESCRIPTOIN_TAG)
                .contact(new Contact("Publicis Sapient","", ""))
                .build();
    }
}