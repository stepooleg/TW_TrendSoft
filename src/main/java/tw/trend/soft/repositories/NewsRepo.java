package tw.trend.soft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tw.trend.soft.models.Category;
import tw.trend.soft.models.News;

import java.util.List;

@Repository
public interface NewsRepo extends JpaRepository<News,Long> {
    List<News> findAll();
    List<News> findAllByParentIn(List<Category> category);
    News findByTitle(String title);

    News findByText(String text);

    News findByParent(String parent);


}
