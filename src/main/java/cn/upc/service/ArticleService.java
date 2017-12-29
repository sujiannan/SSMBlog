package cn.upc.service;

import java.util.List;

import cn.upc.pojo.Article;
import cn.upc.pojo.ArticleLinkType;
import cn.upc.pojo.ArticlePageInfo;

public interface ArticleService {

	public List<Article> findAllWithoutText();
	
	public List<ArticleLinkType> findAllWithTypeName() ;  //联合查询   查找文章type
	//public List<Article> findArtiByPage();

	public void insertArticle(Article arti);

	public void deleteArtiById(Integer id);

	public Article findArtiById(Integer id);

	public void updateArticle(Article arti);

	public List<Article> findNew5Article();

	public ArticlePageInfo findAllBySplitPage(int i, int j);

	public ArticlePageInfo findByTypeIdSplitPage(Integer typeId, Integer nowPage, int totalShow);

}
