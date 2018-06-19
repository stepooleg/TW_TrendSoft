package tw.trend.soft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.trend.soft.models.Category;
import tw.trend.soft.repositories.CategoryRepo;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;

    public void addCategory(Category category, String name){
        category.setName(name);
        categoryRepo.save(category);

    }
    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public void delCategory (Long id){
        categoryRepo.deleteById(id);
    }

    public Category findById (Long id){
        Optional<Category> category = categoryRepo.findById(id);
        return category.orElse(null);
    }

    public List<Category> findAllById (List<Long> id){
        return categoryRepo.findAllById(id);
    }


}
