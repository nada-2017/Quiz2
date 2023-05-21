package com.example.quiz2.Controller;


import com.example.quiz2.Model.Student;
import com.example.quiz2.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudent(){
        return ResponseEntity.status(200).body(studentService.getStudents());

    }

    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid@RequestBody Student student, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Student added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable int id, @Valid@RequestBody Student student, Errors errors){
        if (errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if (studentService.updateStudent(id,student))
            return ResponseEntity.status(200).body("Student updated");
        return ResponseEntity.status(400).body("Not found");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable int id){
        if (studentService.deleteStudent(id))
            return ResponseEntity.status(200).body("Student deleted");
        return ResponseEntity.status(400).body("Not found");
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestBody String name){
        Student student = studentService.search(name);
        if (student != null)
            return ResponseEntity.status(200).body(student);
        return ResponseEntity.status(400).body("Not found");
    }
}
