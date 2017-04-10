package de.holisticon.jdk9showcase;

import io.undertow.UndertowOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;

@EnableAutoConfiguration
@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Value("${http.version:'HTTP2'}")
    private String httpVersion;

    @Bean
    UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
        UndertowEmbeddedServletContainerFactory factory = new UndertowEmbeddedServletContainerFactory();
        if ("HTTP2".equals(httpVersion)) {
            factory.addBuilderCustomizers(
                    builder -> builder
                            .setServerOption(UndertowOptions.ENABLE_HTTP2, true)
                            .setServerOption(UndertowOptions.HTTP2_SETTINGS_ENABLE_PUSH, true)
            );
        }
        return factory;
    }

}
