package will.starmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import will.starmanager.model.Star;
import will.starmanager.service.StarService;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class StarController {

    @Autowired
    private StarService starService;

    @GetMapping("/")
    public ModelAndView showStarList(@RequestParam("search") Optional<String> search, @PageableDefault(size = 10) Pageable pageable) {
        Page<Star> stars;
        if (search.isPresent()) {
            stars = starService.findAllByNameContaining(search.get(), pageable);
        } else {
            stars = starService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("stars", stars);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("star", new Star());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createNewBook(@Validated @ModelAttribute("star") Star star, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView = new ModelAndView("create");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("create");
            starService.save(star);
            modelAndView.addObject("message", "New star created successful");
            modelAndView.addObject("book", new Star());
            return modelAndView;
        }
    }

    @GetMapping("/view/{id}")
    public ModelAndView showViewPage(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("star", starService.findById(id));
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("star", starService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editStar(Star book) {
        ModelAndView modelAndView = new ModelAndView("edit");
        starService.save(book);
        modelAndView.addObject("message", "Star was update succesfull");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeletePage(@PathVariable int id){
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("star", starService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public ModelAndView deleteBook(@RequestParam int id, Star star) {
        star = starService.findById(id);
        if (star != null) {
            starService.remove(id);
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("message", "Delete star successful");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("delete");
            modelAndView.addObject("message", "Delete star failed");
            return modelAndView;
        }
    }
}

