package com.example.pstlabstest.controller;

import com.example.pstlabstest.dto.request.ResumeRequestDto;
import com.example.pstlabstest.service.ResumeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user/resume")
@AllArgsConstructor
public class ResumeController {

    private final ResumeService resumeService;

    @PostMapping("/create/{email}")
    public ResponseEntity<?> createResume(@PathVariable String email, @RequestBody ResumeRequestDto resumeRequestDto) {
        return new ResponseEntity<>(resumeService.create(email, resumeRequestDto), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(resumeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id) {
        return new ResponseEntity<>(resumeService.getById(id), HttpStatus.OK);
    }

    @PutMapping("/update/{resumeId}")
    public void update(@PathVariable long resumeId, @RequestBody ResumeRequestDto resumeRequestDto) {
        resumeService.update(resumeId, resumeRequestDto);
    }

    @DeleteMapping("/delete/{resumeId}")
    public ResponseEntity<?> delete(@PathVariable long resumeId) {
        if (resumeService.delete(resumeId)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
