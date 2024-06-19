package com.html.input.InputController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculateController {
    @GetMapping("/calculate")
    public ModelAndView calculator(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("calculate");
        return modelAndView;
    }

    @PostMapping("calculate")
    public String calculate(@RequestParam("num1") double num1,
                            @RequestParam("num2") double num2,
                            @RequestParam("operator") String operator,
                            Model model){
        double result = 0;
        switch (operator){
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            case "*":
                result = num1 * num2;
                break;
        }
        model.addAttribute("result", result);
        return "calculate";
    }
}
