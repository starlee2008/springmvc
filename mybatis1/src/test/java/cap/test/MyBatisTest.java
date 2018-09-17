package cap.test;

import cap.mapper.ArticleMapper;
import cap.model.Article;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MyBatisTest {
    private SqlSessionFactory sessionFactory;

    @Before
    public void init() {
        try {
            String resource = "mybatis-conf.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void testSelectByPrimaryKey() {
        try {
            SqlSession session = sessionFactory.openSession();
            // 映射sql的标识字符串
            String statement = "cap.mapper.ArticleMapper.selectByPrimaryKey";
            Article article = session.selectOne(statement, 1);
            System.out.println(article.getTitle());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testSelectAllArticle() {
        SqlSession session = sessionFactory.openSession();
        ArticleMapper articleMapper = session.getMapper(ArticleMapper.class);
        List<Article> articleList = articleMapper.selectAllArticle();
        for (Article article : articleList) {
            System.out.println(article.getTitle());
        }

    }

    @Test
    public void testDeleteArticle() {
        SqlSession session = sessionFactory.openSession();
        ArticleMapper articleMapper = session.getMapper(ArticleMapper.class);
        articleMapper.deleteArticle(13);
        session.commit();
    }

}

