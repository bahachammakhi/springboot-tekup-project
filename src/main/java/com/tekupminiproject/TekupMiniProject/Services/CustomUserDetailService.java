package com.tekupminiproject.TekupMiniProject.Services;

import com.tekupminiproject.TekupMiniProject.entities.CustomUserDetail;
import com.tekupminiproject.TekupMiniProject.entities.User;
import com.tekupminiproject.TekupMiniProject.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user =userRepository.findUserByEmail(email);
        user.orElseThrow(()-> new UsernameNotFoundException("user not found"));
        return user.map(CustomUserDetail::new).get();

        }
}
