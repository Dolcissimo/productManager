package me.sungJ.productManager.Application;

import org.modelmapper.ModelMapper;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.sql.Connection;

@Configuration
public class ApplicationConfig {

//    @Bean
//    public ModelMapper modelMapper() {
//        ModelMapper modelMapper = new ModelMapper();
//        modelMapper.getConfiguration()
//                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
//                .setFieldMatchingEnabled(true);
//        return modelMapper;
//    }

    @Bean
    @Profile("prod")
    public ApplicationRunner runner (DataSource dataSource) {
        return args -> {
            Connection connection = dataSource.getConnection();
        };
    }
}
