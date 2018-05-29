package com.david.edshirorolesystem.web.controller;

import com.david.edshirorolesystem.po.StudentCustom;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    /**
     * 学生信息显示
     */
    @RequestMapping("/showStudent")
    public String showStudent(Model model, Integer page) {

        return "admin/showStudent";
    }
}
