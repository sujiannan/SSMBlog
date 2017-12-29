package cn.upc.controller;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.upc.pojo.Account;
import cn.upc.pojo.ArtiType;
import cn.upc.pojo.Article;
import cn.upc.pojo.ArticleEx;
import cn.upc.pojo.ArticleLinkType;
import cn.upc.service.AccountService;
import cn.upc.service.ArticleService;
import cn.upc.service.ArticleTypeService;
import cn.upc.utils.MD5Utils;

/**
 * 后端管理controller + 文章处理controller
 * @author sjn
 */
@Controller
@RequestMapping("/back/")
public class AdminCotroller {

	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private ArticleTypeService articleTypeService;
	
	/**
	 * 登录检查check 
	 */
	@RequestMapping("/loginCheck.do")
	public String bLoginCheck(Model model ,Account account,HttpSession session) {
		//设置Md5加密后的密文
		if(account.getPassword() != null)
			account.setPassword(MD5Utils.md5(account.getPassword()));
		
		Account ac = accountService.findAccountByNameAndPwd(account);
		if(ac != null) {
			model.addAttribute("msg", null);
			session.setAttribute("loginSuccess", "true"); //记录登陆成功
			return "redirect:bManager.do"; 
		} else {
			model.addAttribute("msg", "用户名或密码错误,请重新输入!");
			return "login";
		}
	}
	
	
//----------------------------文章 controller-----------------------------------------------
	/**
	 * 跳转到文章page
	 */
	@RequestMapping("/bArticle.do")
	public String bArticle(Model model) {
		List<ArticleLinkType> resList = articleService.findAllWithTypeName();
//		List<Article> artiList = articleService.findAllWithoutText();
		List<ArtiType> typeList = articleTypeService.findAll();
		model.addAttribute("artilist", resList);
		model.addAttribute("typeList", typeList);
		return "bArticle";
	}
	
	@RequestMapping("/bManager.do")
	public String toManager() {
		return "bManager";
	}
	
	/**
	 * 跳转到新增文章page 
	 * 	需要type
	 */
	@RequestMapping("/bAddArti.do")
	public String bAddArti(Model model) {
		List<ArtiType> list = articleTypeService.findAll();
		model.addAttribute("typeList",list);
		return "bAddArticle";
	}
	
	/**
	 * 提交文章form
	 */
	@RequestMapping("/bAddArtiComplete.do")
	public String bAddArtiComplete(ArticleEx artiEx) {
		if(artiEx.getTypeId() == null || artiEx.getTypeId().equals("")){
			artiEx.setTypeId(1);  //默认为1
		}
		if(artiEx.getTypeId().equals(0)){ 
			if(StringUtils.isNoneBlank(artiEx.getOtherType())) {
				//新增type
				articleTypeService.insertReturnId(artiEx.getOtherType());
				//System.out.println("插入sql  ， id为：" + typeId);
				//artiEx.setTypeId(typeId);
				int typeId = articleTypeService.findIdByTypeName(artiEx.getOtherType());
				artiEx.setTypeId(typeId);
			} else {
				//默认为1
				artiEx.setTypeId(1);
			}
		} 
		artiEx.setTime(new Date());
		articleService.insertArticle(artiEx);
		return "redirect:bArticle.do";
	}
	
	/**
	 * 删除文章
	 */
	@RequestMapping("bDeleteArti.do")
	public String bDeleteArti(Integer id) {
		articleService.deleteArtiById(id);
		return "redirect:bArticle.do";
	}
	
	/**
	 * 跳转到更改文章页面
	 */
	@RequestMapping("bUpdateArti.do")
	public String bUpdateArti(Model model ,Integer id) {
		Article arti = articleService.findArtiById(id);
		//整理回显数据 context
		String context = arti.getContext();
		Pattern p = Pattern.compile("\t|\r|\n");
		Matcher m = p.matcher(context);
		context = m.replaceAll("");
		context = context.replaceAll("'", "\"");
		arti.setContext(context);
		
		model.addAttribute("arti", arti);
		// 文章type
		List<ArtiType> list = articleTypeService.findAll();
		model.addAttribute("typeList",list);
		
		return "bUpdateArti";
	}
	
	/**
	 * 提交修改后的文章
	 */
	@RequestMapping("bUpdateArtiComplete.do")
	public String bUpdateArtiComplete(ArticleEx artiEx) {
		System.out.println(artiEx.getContext());
		if(artiEx.getTypeId().equals(0)){ 
			if(StringUtils.isNoneBlank(artiEx.getOtherType())) {
				//新增type
				articleTypeService.insertReturnId(artiEx.getOtherType());
				int typeId = articleTypeService.findIdByTypeName(artiEx.getOtherType());
				artiEx.setTypeId(typeId);
			} else {
				//默认为1
				artiEx.setTypeId(1);
			}
		} 
		artiEx.setTime(new Date());
		articleService.updateArticle(artiEx);
		return "redirect:bArticle.do";
	}
}
