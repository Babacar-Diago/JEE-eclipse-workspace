package org.sid.servicecompany;

import java.util.stream.Stream;
import org.sid.servicecompany.dao.CompanyRepository;
import org.sid.servicecompany.entities.Company;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceCompanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCompanyApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CompanyRepository companyRepository){
		return args -> {
			Stream.of("A", "B", "C").forEach(cn->{
				companyRepository.save(new Company(null, cn, 100+Math.random()*900));
			});
			companyRepository.findAll().forEach(System.out::println);
		};
	}

}