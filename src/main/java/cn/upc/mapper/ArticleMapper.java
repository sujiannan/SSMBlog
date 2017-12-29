package cn.upc.mapper;

import cn.upc.pojo.Article;
import cn.upc.pojo.ArticleExample;
import cn.upc.pojo.ArticleLinkType;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ArticleMapper {
    int countByExample(ArticleExample example);

    int deleteByExample(ArticleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Article record);

    int insertSelective(Article record);

    List<Article> selectByExampleWithBLOBs(ArticleExample example);

    List<Article> selectByExample(ArticleExample example);

    Article selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExampleWithBLOBs(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByExample(@Param("record") Article record, @Param("example") ArticleExample example);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);
    
    List<Article> selectAllWithoutText();
    
    List<ArticleLinkType> findAllWithTypeName();

	List<Article> findNew5Article();

	List<Article> findAllByDESC();

	List<Article> findAllByTypeIdDESC(Integer typeId);
}