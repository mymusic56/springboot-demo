package com.mymusic56.demo;

import com.mymusic56.demo.entity.Customer;
import lombok.extern.slf4j.Slf4j;
import com.mymusic56.demo.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		JdbcTemplateAutoConfiguration.class,
//		HibernateJpaAutoConfiguration.class
})
//@ComponentScan("com")
@Slf4j
public class AppApplication {
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CustomerRepository repository) {
		return (args) -> {
			long c = repository.count();
			log.info("--customer count: "+c);
			if (c == 0) {
				// save a few customers
				repository.save(new Customer("Jack", "Bauer", "Jack@163.com"));
				repository.save(new Customer("Chloe", "O'Brian", "Chloe@163.com"));
				repository.save(new Customer("Kim", "Bauer", "Kim@163.com"));
				repository.save(new Customer("David", "Palmer", "David@163.com"));
				repository.save(new Customer("Michelle", "Dessler", "Michelle@163.com"));
			}

//			// fetch all customers
//			log.info("Customers found with findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//
//			// fetch an individual customer by ID
//			Customer customer = repository.findById(1L);
//			log.info("Customer found with findById(1L):");
//			log.info("--------------------------------");
//			log.info(customer.toString());
//			log.info("");
//
//			// fetch customers by last name
//			log.info("Customer found with findByLastName('Bauer'):");
//			log.info("--------------------------------------------");
//			repository.findByLastName("Bauer").forEach(bauer -> {
//				log.info(bauer.toString());
//			});
//			log.info("Customer found with findByFirstName('Kim'):");
//			log.info("--------------------------------------------");
//			repository.findByFirstName("Kim").forEach(a -> {
//				log.info(a.toString());
//			});
//			log.info("Customer found with findByFirstNameAndLastName('David', 'Palmer'):");
//			log.info("--------------------------------------------");
//			repository.findByFirstNameAndLastName("David", "Palmer").forEach(a -> {
//				log.info(a.toString());
//			});
//			// for (Customer bauer : repository.findByLastName("Bauer")) {
//			//  log.info(bauer.toString());
//			// }
		};
	}
}
