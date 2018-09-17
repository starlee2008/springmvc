package cap.mapper;

import cap.model.Article;

import java.util.List;

public interface ArticleMapper {
    public Article selectByPrimaryKey(Integer id);

    public List<Article> selectAllArticle();

    public int deleteArticle(Integer id);
}
