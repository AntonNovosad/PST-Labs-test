package com.example.pstlabstest.service;

import com.example.pstlabstest.dto.ResumeDto;
import com.example.pstlabstest.entity.Resume;
import com.example.pstlabstest.repository.ResumeRepository;
import com.example.pstlabstest.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ResumeService {

    private final static String RESUME_NOT_FOUND_MSG = "resume with id %s not found";
    private final static String USER_NOT_FOUND_MSG = "user with email %s not found";
    private final ResumeRepository resumeRepository;
    private final UserRepository userRepository;

    public Resume create(String email, ResumeDto resumeDto) {
        if (userRepository.findByEmail(email).isPresent()) {
            Resume resume = new Resume(10L, resumeDto.getName(),
                    resumeDto.getDescription()
            );
            return resumeRepository.save(resume);
        } else {
            throw new UsernameNotFoundException(String.format(USER_NOT_FOUND_MSG, email));
        }
    }

    public List<Resume> getAll() {
        return resumeRepository.findAll();
    }

    public Resume getById(long id) {
        return resumeRepository.getById(id);
    }

    public Optional<Resume> findByName(String name) {
        return resumeRepository.findByName(name);
    }

    public boolean delete(long id) {
        if (resumeRepository.existsById(id)) {
            Resume resume = resumeRepository.getById(id);
            resumeRepository.delete(resume);
            return true;
        } else {
            return false;
        }
    }

    public void update(long id, ResumeDto resumeDto) {
        if (resumeRepository.existsById(id)) {
            Resume resume = resumeRepository.getById(id);
            resume.setName(resumeDto.getName());
            resume.setDescription(resumeDto.getDescription());
            resumeRepository.save(resume);
        } else {
            throw new RuntimeException(String.format(RESUME_NOT_FOUND_MSG, id));
        }
    }
}
