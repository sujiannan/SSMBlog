package cn.upc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.upc.pojo.ArtiType;
import cn.upc.pojo.ArticlePageInfo;
import cn.upc.service.ArticleService;
import cn.upc.service.ArticleTypeService;

@Controller
public class ArticleController {

	@Autowired
	private ArticleTypeService articleTypeService;
	
	@Autowired
	private ArticleService articleService;
	/**
	 * 跳转页面
	 */
	@RequestMapping("/article/{nowPage}")
	public String article(Model model , @PathVariable Integer nowPage) {
		List<ArtiType> artiTypeList = articleTypeService.findAll();
		model.addAttribute("typeList", artiTypeList);
		if( nowPage == null || nowPage.equals("") || nowPage < 1) {
			nowPage = 1;
		}
		ArticlePageInfo info = articleService.findAllBySplitPage( nowPage , 5 );
		if( nowPage > info.getTotalPage()) {
			nowPage = info.getTotalPage();
			info = articleService.findAllBySplitPage( nowPage , 5 );
		}
		model.addAttribute("artiInfo", info);
		return "article";
	}
	
	/**
	 * 根据typeID显示文章内容 分页
	 */
	@RequestMapping("/type/{typeId}/{nowPage}")
	public String toContact(@PathVariable Integer typeId, 
			@PathVariable Integer nowPage, Model model) {
		List<ArtiType> artiTypeList = articleTypeService.findAll();
		model.addAttribute("typeList", artiTypeList);
		if( nowPage == null || nowPage.equals("") || nowPage < 1) {
			nowPage = 1;
		}
		int totalShow = 5;
		ArticlePageInfo info =  articleService.findByTypeIdSplitPage(typeId , nowPage , totalShow);
		model.addAttribute("artiInfo", info);
		model.addAttribute("type_id", typeId);
		
		return "article2";
	}
	
}
