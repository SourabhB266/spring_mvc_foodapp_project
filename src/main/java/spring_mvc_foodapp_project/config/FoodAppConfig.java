package spring_mvc_foodapp_project.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "spring_mvc_foodapp_project" })
public class FoodAppConfig {

	@Bean(value = "prototype")
	public EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory("sourabh").createEntityManager();
	}
}
