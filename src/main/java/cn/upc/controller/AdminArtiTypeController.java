package cn.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.upc.pojo.ArtiType;
import cn.upc.service.ArticleTypeService;

@Controller
@RequestMapping("/back/")
public class AdminArtiTypeController {

	@Autowired
	private ArticleTypeService articleTypeService;
	
	@RequestMapping("/bDeleteArtiType.do")
	public String bDelArtiType(Integer id) {
		articleTypeService.delArtiType(id);
		return "redirect:bArticle.do";
	}
	
	@RequestMapping("/bUpdateArtiType.do")
	@ResponseBody
	public ArtiType bUpdateArtiType(@RequestBody ArtiType arti) {
		articleTypeService.updateArtiType(arti);
		ArtiType a = new ArtiType();
		return arti;
	}
}
