package cn.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.upc.pojo.Article;
import cn.upc.service.ArticleService;

@Controller
public class ArticleDetailController {

	@Autowired
	private ArticleService articleService;
	/**
	 * 跳转到文章详情页面
	 */
	@RequestMapping("/detail/{id}")
	public String artiDetail(@PathVariable Integer id ,Model model) {
		Article arti = articleService.findArtiById(id);
		model.addAttribute("arti", arti);
		return "post";
	}
}
