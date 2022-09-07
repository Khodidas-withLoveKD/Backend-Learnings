package com.example.springmongorefresh;

import com.example.springmongorefresh.entity.Student;
import com.example.springmongorefresh.entity.models.Address;
import com.example.springmongorefresh.entity.models.Gender;
import com.example.springmongorefresh.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringMongoRefreshApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoRefreshApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (StudentRepository repository) {
		return args ->  {
			Address address = new Address(
							"Surat",
							395004,
							"India"
			);

			List<String> favSubjects = new ArrayList<String>(){{
				add("Computer Science");
				add("Maths");
			}};

			Student student = new Student(
							"Khodidas",
							"Chauhan",
							"chauhan.khodidas@gmail.com",
							Gender.MALE,
							address,
							favSubjects,
							BigDecimal.TEN,
							LocalDateTime.now()
			);
			repository.save(student);
		};
	}

}
