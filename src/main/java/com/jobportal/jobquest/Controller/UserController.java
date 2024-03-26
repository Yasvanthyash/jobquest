package com.jobportal.jobquest.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;

import com.jobportal.jobquest.Dto.AuthRequest;
import com.jobportal.jobquest.Model.UserModel;
import com.jobportal.jobquest.Repository.UserRepository;
import com.jobportal.jobquest.Service.JwtService;
import com.jobportal.jobquest.Service.UserService;

@RestController
@RequestMapping("/api/job_application")
@CrossOrigin(origins = "http://localhost:5173/", allowedHeaders = "*")

public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<UserModel> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public UserModel getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    @PostMapping("/addUser")
    public UserModel saveLogin(@RequestBody UserModel login) {
        return userService.saveLogin(login);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));

                final UserModel student = userRepository.findByEmail(authRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Email not found"));
        if (authentication.isAuthenticated()) {
            
            return jwtService.generateToken(authRequest.getEmail(),student.getRoleAsString());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }
    @GetMapping("/email/{email}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public UserModel getStudentByEmail(@PathVariable String email) {
    return userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Student not found with email: " + email));
    }
    @PutMapping("update/{id}")
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ResponseEntity<UserModel> updateUser(@PathVariable Long id, @RequestBody UserModel updatedUser) {
        UserModel updated = userService.updateUser(id, updatedUser);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
