package tw.trend.soft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tw.trend.soft.models.Category;
import tw.trend.soft.models.News;
import tw.trend.soft.repositories.NewsRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NewsService{
    @Autowired
    NewsRepo newsRepo;

    public List<News> findAll() {
        return newsRepo.findAll();
    }

    public void save(News news, String title, String text, Category category){
        news.setParent(category);
        news.setTitle(title);
        news.setText(text);
        newsRepo.save(news);
    }

    public void delNews (Long id){
        newsRepo.deleteById(id);
    }

    public List<News> findByCategory(List<Category> categoryList) {
        return newsRepo.findAllByParentIn(categoryList);
    }

    public List<News>searchInNews(List<News> newsList, String filter, boolean inTitle, boolean inText){
        String filterNews=filter.toLowerCase().trim();
        if(newsList.size()==0){
            newsList=this.findAll();
        }
        if(!filterNews.isEmpty()){
            if(inTitle&&inText||!inTitle&&!inText){
                return newsList.stream()
                        .filter(news ->news.getTitle()
                                .contains(filterNews)||news.getText()
                                .contains(filterNews))
                        .collect(Collectors.toList());

            }else if(inTitle&&!inText){
               
                        return newsList.stream()
                                .filter(news ->news.getTitle()
                                        .contains(filterNews))
                                .collect(Collectors.toList());
                  
            }
            else if(!inTitle&&inText){
                return newsList.stream()
                        .filter(news ->news.getText()
                                .contains(filterNews))
                        .collect(Collectors.toList());
            }
        } else {
            return  newsList;
        }
        return  newsList;
    }


}
