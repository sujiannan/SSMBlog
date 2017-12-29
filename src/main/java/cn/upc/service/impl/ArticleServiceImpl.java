package cn.upc.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.upc.mapper.ArticleMapper;
import cn.upc.pojo.Article;
import cn.upc.pojo.ArticleExample;
import cn.upc.pojo.ArticleExample.Criteria;
import cn.upc.pojo.ArticleLinkType;
import cn.upc.pojo.ArticlePageInfo;
import cn.upc.service.ArticleService;
import cn.upc.utils.CleanHtmlUtil;
@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleMapper articleMapper;
	
	public List<Article> findAllWithoutText() {
//		ArticleExample example = new ArticleExample();
//		Criteria createCriteria = example.createCriteria();
//		List<Article> artiList = articleMapper.selectByExample(example );
		List<Article> artiList = articleMapper.selectAllWithoutText();
		return artiList;
	}
	
	/**
	 * 联表查询    1 对 1  
	 */
	public List<ArticleLinkType> findAllWithTypeName() {
		List<ArticleLinkType> list = articleMapper.findAllWithTypeName();
		return list;
	}

	public void insertArticle(Article arti) {
		articleMapper.insert(arti);
	}

	public void deleteArtiById(Integer id) {
		articleMapper.deleteByPrimaryKey(id);
	}

	public Article findArtiById(Integer id) {
		Article arti = articleMapper.selectByPrimaryKey(id);
		return arti;
	}

	public void updateArticle(Article arti) {
		articleMapper.updateByPrimaryKeyWithBLOBs(arti);
	}

	public List<Article> findNew5Article() {
		return articleMapper.findNew5Article();
	}

	public ArticlePageInfo findAllBySplitPage(int startPage, int perPageSum) {
		// 设置分页
		PageHelper.startPage(startPage, perPageSum);
		
		List<Article> list = articleMapper.findAllByDESC();
		// 取分页后结果
		PageInfo<Article> pageInfo = new PageInfo<Article>(list);
		//处理aricle数据 
		for (Article article : list) {
			StringBuilder sb = new StringBuilder();
			String imgHtml = CleanHtmlUtil.getImgHtml(article.getContext());
			sb.append(imgHtml);
			if(StringUtils.isNoneBlank(imgHtml)){
				sb.append("<br/>");
			}
			String context = CleanHtmlUtil.CleanHtml(article.getContext());
			sb.append(context);
			article.setContext(sb.toString());
		}
//		long total = pageInfo.getTotal(); 	//总计记录数
		ArticlePageInfo info = new ArticlePageInfo();
		info.setList(list);
		int pages = pageInfo.getPages();  //总页数
		info.setTotalPage(pages);
		info.setNowPage(startPage);
		return info;
	}
	/**
	 * 根据 文章type 查询 分页
	 */
	public ArticlePageInfo findByTypeIdSplitPage(Integer typeId, Integer nowPage, int totalShow) {
		// 设置分页
		PageHelper.startPage(nowPage, totalShow);
		List<Article> list = articleMapper.findAllByTypeIdDESC(typeId);
		//处理aricle数据 
		for (Article article : list) {
			StringBuilder sb = new StringBuilder();
			String imgHtml = CleanHtmlUtil.getImgHtml(article.getContext());
			sb.append(imgHtml);
			if(StringUtils.isNoneBlank(imgHtml)){
				sb.append("<br/>");
			}
			String context = CleanHtmlUtil.CleanHtml(article.getContext());
			sb.append(context);
			article.setContext(sb.toString());
		}
		// 取分页后结果
		PageInfo<Article> pageInfo = new PageInfo<Article>(list);
		ArticlePageInfo info = new ArticlePageInfo();
		info.setList(list);
		int pages = pageInfo.getPages();  //总页数
		info.setTotalPage(pages);
		info.setNowPage(nowPage);
		return info;
	}

}
