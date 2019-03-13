package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
@Controller
public class HomeController {
    @GetMapping("/carform")
    public String loadCarForm(Model model) {
        model.addAttribute("cartype", new Car());
        return "carform";
        }

    @PostMapping("/carform")
    public String processCarForm(@ModelAttribute ("cartype") @Valid Car cartype, BindingResult result/*, Model model*/) {
//        model.addAttribute("cartype", cartype);
        if (result.hasErrors()) {
            return  "carform";
        }

//        System.out.println(cartype.getName());
//        model.addAttribute("cartype", cartype);
        return "cartypeconfirm";

    }
}
