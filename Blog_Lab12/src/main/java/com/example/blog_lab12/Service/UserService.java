package com.example.blog_lab12.Service;

import com.example.blog_lab12.ApiResponse.ApiException;
import com.example.blog_lab12.Model.User;
import com.example.blog_lab12.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void Register(User user) {
        user.setRole("USER");
        String hashPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(hashPassword);
        userRepository.save(user);
    }

    public void UpdateUser(Integer user_id, User user) {
        User oldUser = userRepository.findUserById(user_id);
        if (oldUser == null) {
            throw new ApiException("user not found");
        }
        if (!oldUser.getId().equals(user_id)) {
            throw new ApiException("you are not authorized to update this user");
        }
        oldUser.setUsername(user.getUsername());
        String hashPassword = new BCryptPasswordEncoder().encode(user.getPassword());
        oldUser.setPassword(hashPassword);
        userRepository.save(oldUser);
    }

    public void DeleteUser(User user) {
        userRepository.delete(user);
    }
    public List<User> findAll() {
        return userRepository.findUserByRole("USER");
    }


}
