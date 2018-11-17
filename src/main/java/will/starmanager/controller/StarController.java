package will.starmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import will.starmanager.model.Star;
import will.starmanager.service.StarService;

@Controller
@RequestMapping("/")
public class StarController {

    @Autowired
    private StarService starService;

    @GetMapping("/")
    public ModelAndView showStarList() {
        ModelAndView modelAndView = new ModelAndView("view");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("star", new Star());
        return modelAndView;
    }

}
