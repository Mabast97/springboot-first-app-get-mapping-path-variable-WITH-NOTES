package com.example.springbootfirstapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> allStudents = new ArrayList<>();

    @GetMapping("/student")
    public Student getStudent() {
        return new Student("Mabast", "Hashim");
    }

    @GetMapping("/all-students")
    public List<Student> getStudents() {
        allStudents.add(new Student("Mabast", "Hashm"));
        allStudents.add(new Student("Mabast2", "Hashm2"));
        allStudents.add(new Student("Mabast3", "Hashm3"));
        allStudents.add(new Student("Mabast4", "Hashm4"));
        allStudents.add(new Student("Mabast5", "Hashm5"));

        return allStudents;
    }    // FOR TEST: in the browser write (http://localhost:8086/all-students)


    // If we want :  http://localhost:8086/student/Mabast/Hashm
    @GetMapping("student/{firstName}/{lastName}")
    // Here we use @PathVariable in order to bind the value of URL template variable with the method variable
    public Student studentPathVariable(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName) {  // this is for mapping the method variable with the value of URL
        return new Student(firstName, lastName);
    } // FOR TEST: in the browser write (http://localhost:8086/student/firstName=Mabast&lastName=Hashm)


    // Build Rest API to handle query parameters
    // http://localhost:8086/student?firstName=Mabast&lastName=Hashm

    @GetMapping("/student/query")
    public Student studentQueryParam(@RequestParam(name = "firstName") String firstName,
                                     @RequestParam(name = "lastName") String lastName) { // in order to handle query parameters, we should use @RequestParam
        return new Student(firstName, lastName);
    }    // FOR TEST: in the browser write (http://localhost:8086/student/query?firstName=Mabast&lastName=Hashm)



}
