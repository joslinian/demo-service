package com.startech.demo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPersistence  extends JpaRepository<Student, Long> {

}
