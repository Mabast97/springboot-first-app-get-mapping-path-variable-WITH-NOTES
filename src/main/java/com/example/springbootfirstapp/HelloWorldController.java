package com.example.springbootfirstapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller  // in order to make the class as a spring MVC class and handle the web requests
@ResponseBody

// Instead of the two annotations above, you can use this :
@RestController  // it can handle the web requests and rest API request.
public class HelloWorldController {

    @GetMapping("/hello-world") // It means that this method serve as API
    public String helloWorld(){
        return "Hello World!.";
    }

}
