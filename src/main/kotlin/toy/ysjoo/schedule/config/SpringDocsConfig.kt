package toy.ysjoo.schedule.config

import io.swagger.v3.oas.models.Components
import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.security.SecurityScheme
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SpringDocsConfig {

    @Bean
    fun customJWTBearerSecuritySchemaOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info().title("Toy Schedule API")
                    .description("Toy Project API Document Page.")
                    .version("v0.0.1")
            )
            .components(
                Components()
                    .addSecuritySchemes(
                        "Authorization",
                        SecurityScheme().type(SecurityScheme.Type.APIKEY)
                            .type(SecurityScheme.Type.APIKEY).name("Authorization").`in`(SecurityScheme.In.HEADER)
                    )
            )
    }
}