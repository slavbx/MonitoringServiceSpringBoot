package com.slavbx.monserv.controllers;

import com.slavbx.monserv.models.Record;
import com.slavbx.monserv.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    RecordService recordService;

    @Autowired
    public MainController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("getrecord")
    @ResponseBody
    public Record getRecord(@RequestParam(value = "id") Long id) {
        return recordService.findById(id).orElse(null);
    }

    @GetMapping("/actual-record")
    //@ResponseBody
    public String viewActualRecord(Model model) {
        String username = "slav"; //сделать динамику
        model.addAttribute("username", username);
        return "actual-record";
    }


}
