package com.example.postgresdemo.student.service.Impl;

import com.example.postgresdemo.student.Student;
import com.example.postgresdemo.student.repository.StudentRepository;
import com.example.postgresdemo.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

  @Autowired
  StudentRepository studentRepository;

  @Override
  public List<Student> getStudents() {
    return studentRepository.findAll();
  }

  @Override
  public void addNewStudent(Student student) {
//    return studentRepository.save(student);
    Optional<Student> studentEmail = studentRepository.findStudentByEmail(student.getEmail());
    if (studentEmail.isPresent()) {
      throw new IllegalStateException("Email already taken");
    }
    studentRepository.save(student);
    System.out.println(student);
  }

  public void deleteStudent(Long studentId) {
    boolean studentExists = studentRepository.existsById(studentId);

    if (!studentExists) {
      throw new IllegalStateException(
              "Student with ID: " + studentId + " does not exists!!"
      );
    }
    studentRepository.deleteById(studentId);
  }

  @Transactional
  public void updateStudentNameAndEmail(Long studentId, String name, String email) {
    Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new IllegalStateException(
                    "Student with ID " + studentId + " does not exists!! :("
            ));
    // check constraints for name
    if (Objects.nonNull(name) &&
        name.length() > 0 &&
        !Objects.equals(student.getName(), name)) {
      student.setName(name);
    }
    // check for email
    if (Objects.nonNull(email) &&
        email.length() > 0 &&
        !Objects.equals(email, student.getEmail())) {
      // check if the email is already taken by someone else
      Optional<Student> otherStudent = studentRepository.findStudentByEmail(email);
      System.out.println("otherStudent.toString() = " + otherStudent.toString());
      if (otherStudent.isPresent()) {
        throw new IllegalStateException("Email already taken!!!");
      }
      student.setEmail(email);
    }
  }

}
