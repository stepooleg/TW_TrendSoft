package tw.trend.soft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tw.trend.soft.models.Category;
import tw.trend.soft.services.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {
   @Autowired
   CategoryService categoryService;

        @GetMapping
        public String categoryList(Model model) {
            model.addAttribute("category", categoryService.findAll());
            return "categoryList";
        }

        @PostMapping("add")
        public String addCategory(
                @RequestParam String name,
                Category category,
                Model model){
            categoryService.addCategory(category, name);
            return "redirect:/category";
        }

        @GetMapping("/del/{id}")
        public String delCategory(Model model, @PathVariable Long id){
            categoryService.delCategory(id);
            return "redirect:/category";
        }
}

