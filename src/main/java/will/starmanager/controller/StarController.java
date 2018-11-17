package will.starmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class StarController {

    @GetMapping("/")
    public ModelAndView showStarList(){
        ModelAndView  modelAndView = new ModelAndView("view");
        return modelAndView;
    }


}
