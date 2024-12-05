package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.repository.MyUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ThyTestController {

    @Autowired
    private MyUserRepository userRepository;

    @GetMapping("/ThyTest")
    public String thyTest(Model model) {
        String msg = "new text!";
        User myUser = new User(); // Пустой пользователь для формы
        model.addAttribute("myUser", myUser);
        model.addAttribute("message", msg);
        return "index"; // Возвращает index.html
    }

    @PostMapping("/ThyTest")
    public String thyTestPost(Model model, @ModelAttribute User myUser) {
        // Пример списка пользователей
        User[] myUsers = {
                new User("Иван", "123"),
                new User("Олег", "345")
        };

        // Добавляем в модель данные
        model.addAttribute("myUsers", myUsers);
        model.addAttribute("user_add", myUser);

        // Логирование добавленного пользователя
        System.out.println(myUser);
        System.out.println("Добавленный пользователь: " + myUser.getUsername());
        return "test"; // Возвращает test.html
    }

}
