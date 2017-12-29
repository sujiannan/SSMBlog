package cn.upc.controller;

import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.upc.pojo.MsgNote;
import cn.upc.service.MsgService;

@Controller
public class ContactController {

	@Autowired
	private MsgService msgService;
	
	@RequestMapping("/contact.do")
	public String toContact(HttpServletRequest request ,Model model) {
		// 生成UUID
		UUID uuid = UUID.randomUUID();  
        String uuID = uuid.toString();  
		HttpSession session = request.getSession();
		session.setAttribute("UUID", uuID);
		model.addAttribute("Token", uuID);
		
		return "contact";
	}
	
	/**
	 * 提交留言 Token防止重复提交	token：UUID  之前UUID存储于session中
	 */
	@RequestMapping("/contactOk.do")
	public String fuqi(String Token , MsgNote msg ,HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session.getAttribute("UUID") == null){
			return "redirect:contact.do";
		}
		String uuid = (String) session.getAttribute("UUID");
		if(Token.equals(uuid)) {
			// 存入数据库
			msg.setTime(new Date());
			msgService.insertMsgInfo(msg);
			session.removeAttribute("UUID");
		}
		return "redirect:contact.do";
	}
}
