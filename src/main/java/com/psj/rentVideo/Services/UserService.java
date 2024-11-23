package com.psj.rentVideo.Services;

import com.psj.rentVideo.Entities.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public User registerUser(User user);

    public UserDetails loadUserByUserName(String email);
}
