package com.example.springmongorefresh.services.impl;

import com.example.springmongorefresh.entity.Student;
import com.example.springmongorefresh.entity.models.Address;
import com.example.springmongorefresh.repository.StudentRepository;
import com.example.springmongorefresh.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
public class StudentServiceImpl implements StudentService {
  @Autowired
  StudentRepository studentRepository;
  @Autowired
  MongoTemplate mongoTemplate;

  @Override
  public List<Student> getAllStudents() {
    return studentRepository.findAll();
  }

  @Override
  public void addStudent(Student student) {
    Optional<Student> anotherStudent = studentRepository.findStudentByEmail(student.getEmail());
    if(anotherStudent.isPresent()) {
      throw new IllegalStateException(" Student with email " + student.getEmail() + " already exist!!");
    }
    
    studentRepository.save(student);
  }

  @Override
  public void deleteStudentByEmail(String email) {
    Optional<Student> anotherStudent = studentRepository.findStudentByEmail(email);
    if(!anotherStudent.isPresent()) {
      throw new IllegalStateException("Unable to delete student. Student with email " + email + " does not exist!!");
    }

    studentRepository.deleteStudentByEmail(email);
  }

  @Override
//  @Transactional
  public void updateStudent(Student student) {
    Optional<Student> anotherStudent = studentRepository.findStudentByEmail(student.getEmail());
    if (!anotherStudent.isPresent()) {
      throw new IllegalStateException(
              "Student with email " + student.getEmail() + " does not exist"
      );
    }

    Query query = new Query();
    query.addCriteria(Criteria.where("email").is(student.getEmail()));

//    mongoTemplate.updateFirst(query, student);
  }

  @Override
  public void updateStudentNameAndAddress(String email, String firstName, String lastName, Address address) {
    Optional<Student> anotherStudent = studentRepository.findStudentByEmail(email);
    if (!anotherStudent.isPresent()) {
      throw new IllegalStateException(
              "Student with email " + email + " does not exist"
      );
    }

    Query query = new Query();
    query.addCriteria(Criteria.where("email").is(email));

//    ion = new Upd
    Update update = new Update();
    update.set("firstName", firstName);
    update.set("lastName", lastName);
    update.set("address", address);
    mongoTemplate.updateFirst(query, update, Student.class);
  }

}
