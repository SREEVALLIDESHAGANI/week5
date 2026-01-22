/*package com.example.myapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myapp.model.User;

public interface UserRepo extends JpaRepository<User,Long>{
    
}*/
package com.example.myapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.myapp.model.User;

public interface UserRepo extends JpaRepository<User, String> {

    User findByUsername(String username);
}

