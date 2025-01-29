package iss.nus.edu.sg.sa4106.KebunJio.Controllers;

import iss.nus.edu.sg.sa4106.KebunJio.Models.User;
import iss.nus.edu.sg.sa4106.KebunJio.Services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

//Login
    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String emailOrUsername, @RequestParam String password, HttpSession session,Model model) {
        try {
            User user = userService.loginUser(emailOrUsername, password);
            session.setAttribute("loggedInUser", user);
            return "redirect:/dashboard";
        }catch (Exception e){
            model.addAttribute("error",e.getMessage());
            return "login";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Logout successful!";
    }

    @GetMapping("/current")
    public User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("loggedInUser");
    }

    //Register
    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";  // 渲染 `register.html`
    }

    @PostMapping("/process-register")
    public String processRegister(
            @RequestParam String email,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String confirmPassword,
            Model model) {
        if (!password.equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match!");
            return "register"; // 返回注册页面并显示错误信息
        }
        try {
            User newUser = new User();
            newUser.setEmail(email);
            newUser.setUsername(username);
            newUser.setPassword(password);

            userService.registerUser(newUser);

            model.addAttribute("success", "Registration successful! Please login.");
            return "login"; // 注册成功后跳转到登录页面
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "register";
        }
    }
}

