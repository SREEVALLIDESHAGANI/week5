/*package com.example.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.dto.SignupReq;
import com.example.myapp.model.User;
import com.example.myapp.repo.UserRepo;

@CrossOrigin(origins = "*")
@RestController
public class Auth {
    
    @Autowired
    UserRepo db;

    @PostMapping("/signup")
    String Signup(@RequestBody SignupReq sd){
        System.out.println("\n\t name : "+sd.getName());
        System.out.println("\n\t email : "+sd.getEmail());
        System.out.println("\n\t password : "+sd.getPassword());

        User ud=new User();
        ud.setName(sd.getName());
        ud.setEmail(sd.getEmail());
        ud.setPassword(sd.getPassword());


        db.save(ud);
        return "signup sucess ...!";
    }
    
}*/
package com.example.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.myapp.model.User;
import com.example.myapp.repo.UserRepo;

@RestController
@RequestMapping("/auth")
public class Auth {

    @Autowired
    private UserRepo userRepo;

    // ✅ SIGNUP / REGISTER
    @PostMapping("/signup")
    public String signup(@RequestBody User user) {

        User existingUser = userRepo.findByUsername(user.getUsername());

        if (existingUser != null) {
            return "Username already exists";
        }

        userRepo.save(user);
        return "Signup successful";
    }

    // ✅ LOGIN
    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = userRepo.findByUsername(user.getUsername());

        if (dbUser == null) {
            return "User not found";
        }

        if (dbUser.getPassword().equals(user.getPassword())) {
            return "Login successful";
        } else {
            return "Invalid password";
        }
    }
}

