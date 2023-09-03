package pl.mobilet.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.mobilet.news.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
}
