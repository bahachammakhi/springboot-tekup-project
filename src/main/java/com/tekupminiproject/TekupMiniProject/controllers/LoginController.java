package com.tekupminiproject.TekupMiniProject.controllers;

import com.tekupminiproject.TekupMiniProject.dto.UserDto;
import com.tekupminiproject.TekupMiniProject.dto.productDTO;
import com.tekupminiproject.TekupMiniProject.entities.Role;

import com.tekupminiproject.TekupMiniProject.entities.User;
import com.tekupminiproject.TekupMiniProject.respositories.RoleRepository;
import com.tekupminiproject.TekupMiniProject.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String register(Model model){
        model.addAttribute("user",new UserDto());
        return "register";
    }

@PostMapping("/register")
    public String registerPost(@ModelAttribute("user") UserDto userDto, HttpServletRequest request)throws ServletException{
        User user=new User();
        String password =userDto.getPassword();
        user.setPassword(bCryptPasswordEncoder.encode(password));
        List<Role> roles =new ArrayList<>();
        roles.add(roleRepository.findById(2).get());
        user.setRoles(roles);
        user.setEmail(userDto.getEmail());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());


        userRepository.save(user);
        request.login(user.getEmail(),password);
        return "redirect:/";
    }









}


