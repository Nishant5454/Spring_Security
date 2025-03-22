package com.example.Security.Service;

import com.example.Security.Entity.Authorities;
import com.example.Security.Entity.Users;
import com.example.Security.Repository.AuthorityRepository;
import com.example.Security.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityRepository authorityRepository;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
    }

    public ResponseEntity<Users>saveUser(String username, String password) {
        String hashedpassword=passwordEncoder.encode(password);
        Users users=new Users(username,hashedpassword);
        userRepository.save(users);
        Authorities authorities=new Authorities(username,"ROLE_USER");
        authorityRepository.save(authorities);
        return ResponseEntity.status(HttpStatus.CREATED).body(users);

    }

    public boolean getUser(String username, String password) {
      Optional<Users>users=userRepository.findByUsername( username);
      if(users.isPresent()){
          return passwordEncoder.matches(password,users.get().getPassword());
}
      return false;
    }
}
