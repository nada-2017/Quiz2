package com.example.quiz2.Controller;

import com.example.quiz2.Model.Teacher;
import com.example.quiz2.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/get")
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PostMapping("/add")
    public ResponseEntity addTeacher(@Valid@RequestBody Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added");

    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable int id, @Valid@RequestBody Teacher teacher, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (teacherService.updateTeacher(id,teacher))
            return ResponseEntity.status(200).body("Teacher updated");
        return ResponseEntity.status(400).body("Not found");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable int id){
        if (teacherService.deleteTeacher(id))
            return ResponseEntity.status(200).body("Teacher deleted");
        return ResponseEntity.status(400).body("Not found");
    }

    @GetMapping("/search/{id}")
    public ResponseEntity search(@PathVariable int id){
        Teacher teacher = teacherService.search(id);
        if (teacher != null)
            return ResponseEntity.status(200).body(teacher);
        return ResponseEntity.status(400).body("Not found");
    }
}
