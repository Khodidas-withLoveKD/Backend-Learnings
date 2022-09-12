package com.example.springmongorefresh;

import com.example.springmongorefresh.entity.Student;
import com.example.springmongorefresh.entity.models.Address;
import com.example.springmongorefresh.entity.models.Gender;
import com.example.springmongorefresh.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringMongoRefreshApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongoRefreshApplication.class, args);
	}

//	@Bean
//	CommandLineRunner runner (StudentRepository repository, MongoTemplate mongoTemplate) {
//		return args ->  {
//			Address address = new Address(
//							"Surat",
//							395004,
//							"India"
//			);
//
//			List<String> favSubjects = new ArrayList<String>(){{
//				add("Computer Science");
//				add("Maths");
//			}};
//
//			String email = "chauhan.khodidas@gmail.com";
//			Student student = new Student(
//							"Khodidas",
//							"Chauhan",
//							email,
//							Gender.MALE,
//							address,
//							favSubjects,
//							BigDecimal.TEN,
//							LocalDateTime.now()
//			);
//
////			findStudentUsingMongoTemplateAndQuery(repository, mongoTemplate, email, student);
//			Optional<Student> otherStudent = repository.findStudentByEmail(email);
//			System.out.println("otherStudent = " + otherStudent);
//			if (otherStudent.isPresent()) {
//				System.out.println("Student with email " + email + " already exists!!");
//			} else {
//				System.out.println("Creating Student: " + student);
//				repository.insert(student);
//			}
//		};

	private void findStudentUsingMongoTemplateAndQuery(StudentRepository repository, MongoTemplate mongoTemplate, String email, Student student) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email`").is(email));
		List<Student> students = mongoTemplate.find(query, Student.class);

		if (students.size() > 0) {
			System.out.println("Student with email " + email + " already exists!!");
			throw new IllegalStateException(
							"Student with email " + email + " already exists!!"
			);
		}

		System.out.println("Creating Student: " + student);
		repository.insert(student);
	}

}
