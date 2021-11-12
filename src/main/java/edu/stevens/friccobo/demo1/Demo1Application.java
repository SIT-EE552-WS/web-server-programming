package edu.stevens.friccobo.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class Demo1Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

}

/*

POST = create, submit, change...
GET = view, open, redirect

(1) As a professor I want to create an assignment in Canvas and link that assignment to one in Github Classroom
POST

(2) As a professor, I want to know when students have finished a Github Classroom assignment and it is ready for grading
GET

(3) As a student, I want to open a Canvas assignment and have it take me to the Github Assignment
GET

(4) When finished, I want a simple way to let the professor know that the assignment is ready to be graded (submit the asssignment).
POST
 */
