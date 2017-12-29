package cn.upc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.upc.pojo.MsgNote;
import cn.upc.service.MsgService;

@Controller
@RequestMapping("/back/")
public class AdminMsgController {

	@Autowired
	private MsgService msgService;
	
	@RequestMapping("bMsg.do")
	public String bMsg(Model model) {
		List<MsgNote> msgList = msgService.findAll();
		model.addAttribute("msgList", msgList);
		return "bMsg";
	}
	
	@RequestMapping("deleteMsg.do")
	public String delMsg(Integer id) {
		msgService.delMsg(id);
		return "redirect:bMsg.do";
	}
	
}
