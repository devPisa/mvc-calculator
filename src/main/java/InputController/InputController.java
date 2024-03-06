package InputController;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class InputController {
    @GetMapping("/")
    public ModelAndView calculator(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Input");
        return modelAndView;
    }

    @PostMapping("calculate")
    public String calculate(@RequestParam("num1") double num1,
                            @RequestParam("num2") double num2,
                            @RequestParam("operador") String operador,
                            Model model){
        double result = 0;
        switch (operador){
            case "+":
                result = num1+num2;
                break;
            case "-":
                result = num1-num2;
                break;
            case "/":
                result = num1/num2;
                break;
            case "*":
                result = num1*num2;
                break;
        }
        model.addAttribute("resul", result);
        return "calculator";
    }
}
