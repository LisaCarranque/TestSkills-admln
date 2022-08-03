package candidate;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import candidate.configuration.Generated;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * this class is the main class for searchPatient microservice
 */
@Slf4j
@EnableSwagger2
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"candidate"})
@EnableFeignClients("candidate")
@Generated
public class Application {

    public static void main(String[] args) {
        log.info("Launch candidate module");
        SpringApplication.run(Application.class, args);
    }

}
