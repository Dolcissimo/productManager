package me.sungJ.productManager;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class ProductManagerApplication {

	public static void main(String[] args)
    {
		SpringApplication.run(ProductManagerApplication.class, args);
	}

    }
