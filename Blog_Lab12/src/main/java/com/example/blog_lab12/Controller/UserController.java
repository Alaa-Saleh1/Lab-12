package com.example.blog_lab12.Controller;


import com.example.blog_lab12.ApiResponse.ApiResponse;
import com.example.blog_lab12.Model.User;
import com.example.blog_lab12.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> Register(@RequestBody @Valid User user) {
        userService.Register(user);
        return ResponseEntity.status(200).body(new ApiResponse("User registered successfully"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> Update(@AuthenticationPrincipal User user, @RequestBody @Valid User updateUser) {
        userService.UpdateUser(user.getId(), updateUser);
        return ResponseEntity.status(200).body(new ApiResponse("User updated successfully"));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> Delete(@AuthenticationPrincipal User user) {
        userService.DeleteUser(user);
        return ResponseEntity.status(200).body(new ApiResponse("User deleted successfully"));
    }
    @GetMapping("/all-users")
    public ResponseEntity<?> getAllUsers(){
        List<User> users = userService.findAll();
        return ResponseEntity.status(200).body(users);
    }


}
