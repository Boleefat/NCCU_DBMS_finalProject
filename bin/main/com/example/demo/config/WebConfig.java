import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@NonNullApi
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api")
                .allowedOrigins("*") // 允許所有來源
                .allowedMethods("GET", "POST", "PUT", "DELETE"); // 允許的HTTP方法
    }
}
