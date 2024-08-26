package com.ra.session02.repository.design;

import com.ra.session02.model.entity.Student;
import org.springframework.data.repository.CrudRepository;

public interface IStudentRepo extends CrudRepository<Student, Integer> {

}
