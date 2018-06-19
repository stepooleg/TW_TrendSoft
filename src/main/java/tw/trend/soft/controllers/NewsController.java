package tw.trend.soft.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tw.trend.soft.models.Category;
import tw.trend.soft.models.News;
import tw.trend.soft.services.CategoryService;
import tw.trend.soft.services.NewsService;

import java.util.List;

@Controller
public class NewsController {

  @Autowired
    NewsService newsService;
  @Autowired
    CategoryService categoryService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("news",newsService.findAll());
        model.addAttribute("category", categoryService.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addNews(
            @RequestParam  Long category,
            @RequestParam  String title,
            @RequestParam  String text,
            News news) {
        Category cat = categoryService.findById(category);
        newsService.save(news, title, text, cat);
        return "redirect:/";
    }

    @GetMapping("/del/{id}")
    public String delNews(Model model, @PathVariable Long id){
        newsService.delNews(id);
        return "redirect:/";
    }

    @PostMapping("/")
    public String addNews(
            @RequestParam (required = false, defaultValue = "") List<Long> selectCategory,
            @RequestParam (required = false, defaultValue = "") String filter,
            @RequestParam (required = false) boolean inText,
            @RequestParam (required = false) boolean inTitle,
            Model model) {
        List<Category> categoryList = categoryService.findAllById(selectCategory);
        List<News> newsList = newsService.findByCategory(categoryList);

        if(selectCategory!=null && !selectCategory.isEmpty()) {
            model.addAttribute("news", newsService.searchInNews(newsList, filter, inTitle, inText));
            model.addAttribute("category", categoryService.findAll());
            return "index";
        }
        else{
            model.addAttribute("news", newsService.searchInNews(newsList, filter, inTitle, inText));
            model.addAttribute("category", categoryService.findAll());
            return "index";
        }
    }

}
