package cn.upc.controller;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.upc.pojo.Article;
import cn.upc.service.ArticleService;
import cn.upc.utils.CleanHtmlUtil;
/**
 * 首页 Home Page
 * @author Administrator
 *
 */
@Controller
public class IndexController {

	private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式  
	
	@Autowired
	private ArticleService aticleService;
	
	/**
	 * 跳转主页页面
	 * @return
	 */
	@RequestMapping("/")
	public String to(Model model) {
		return toIndex(model);
	}
	@RequestMapping("/index.do")
	public String to2(Model model) {
		return toIndex(model);
	}
	private String toIndex(Model model) {
		List<Article> artiList = aticleService.findNew5Article(); //获取最新5条记录
		//处理aricle数据 
		for (Article article : artiList) {
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
		model.addAttribute("artiList", artiList);
		return "index";
	}
	
	/**
	 * 跳转到about Page
	 */
	@RequestMapping("/about.do")
	public String as() {
		return "about";
	}
	
	@RequestMapping("/post.do")
	public String aas() {
		return "post";
	}
	
	
	/**
	 * 登录到后台 login page
	 */
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String isLogin = (String) session.getAttribute("loginSuccess");
		if("true".equals(isLogin)) {
			return "redirect:/back/bManager.do"; 
		}
		return "login";
	}
	
	/**
	 * 登出 log out  返回到博客首页
	 */
	@RequestMapping("/bLogout.do")
	public String logOut(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("loginSuccess");
		return "redirect:index.do";
	}
}
