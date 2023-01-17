package com.tekupminiproject.TekupMiniProject.controllers;

import com.tekupminiproject.TekupMiniProject.entities.Role;
import com.tekupminiproject.TekupMiniProject.entities.User;
import com.tekupminiproject.TekupMiniProject.respositories.RoleRepository;
import com.tekupminiproject.TekupMiniProject.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.BeanDefinitionDsl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository ;

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/register")
    public String register(){
        return "register";
    }

   /* @PostMapping("/register")
    public String registerpost(@ModelAttribute("user") User user , HttpServletRequest request)throws ServletException{
        String password =user.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles =new ArrayList<>();
        roles.add(roleRepository.findById(2).get());
        user.setRoles(roles);
        userRepository.save(user);
        request.login(user.getEmail(),password);
        return "redirect:/";
    }*/










}


