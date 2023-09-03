package pl.mobilet.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.mobilet.news.entity.Article;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    @Query(value = "SELECT * FROM Article a ORDER BY a.published_at DESC LIMIT ?1 OFFSET ?2", nativeQuery = true)
    List<Article> findAll(int limit, int offset);
}
