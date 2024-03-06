package com.slavbx.monserv.controllers;

import com.slavbx.monserv.models.Meter;
import com.slavbx.monserv.models.User;
import com.slavbx.monserv.services.MeterService;
import com.slavbx.monserv.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.util.List;

@Controller
public class MainController {
    MeterService recordService;
    UserService userService;

    @Autowired
    public MainController(MeterService recordService, UserService userService) {
        this.recordService = recordService;
        this.userService = userService;
    }

    @GetMapping("getrecord")
    @ResponseBody
    public Meter getRecord(@RequestParam(value = "id") Long id) {
        return recordService.findById(id).orElse(null);
    }

    @GetMapping("/getallrecords")
    @ResponseBody
    public List<Meter> getAllRecord() {
        List<Meter> list = recordService.findActualAllUsers();
        list.forEach(System.out::println);
        return list;

    }

    @GetMapping("/actual-record")
    //@ResponseBody
    public String viewActualRecord(Model model) {
        String username = "slav"; //сделать динамику
        model.addAttribute("username", username);
        return "actual-record";
    }

    @GetMapping("/init")
    @ResponseBody
    public String init() {
        if (userService.findByName("slav").isEmpty()) {
            User user = new User(1L, User.Level.USER, "slav", "123");
            userService.save(user);
            recordService.save(new Meter(1L, 111,11,11, user, LocalDate.parse("2023-11-12")));
            recordService.save(new Meter(2L, 222,22,22, user, LocalDate.parse("2023-12-15")));
            recordService.save(new Meter(3L, 333,33,33, user, LocalDate.parse("2024-01-05")));


        }
        return "good";
    }

    @GetMapping("getuserbyname")
    @ResponseBody
    public User getRecord(@RequestParam(value = "name") String name) {
        return userService.findByName(name).orElse(null);
    }


}
