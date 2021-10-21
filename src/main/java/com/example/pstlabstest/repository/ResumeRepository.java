package com.example.pstlabstest.repository;

import com.example.pstlabstest.entity.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface ResumeRepository extends JpaRepository<Resume, Long> {
    Optional<Resume> findByName(String name);
}
