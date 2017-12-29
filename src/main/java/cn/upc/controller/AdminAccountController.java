package cn.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.upc.pojo.Account;
import cn.upc.service.AccountService;
import cn.upc.utils.MD5Utils;

@Controller
@RequestMapping("/back/")
public class AdminAccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping("bAccount.do")
	public String bAccount() {
		return "bAccount";
	}
	
	/**
	 * 	更改密码 
	 */
	@RequestMapping("bChangeAccount.do")
	public String bzhanghao(Model model, Account account ,String newPwd,String newPwd2) {
		account.setPassword(MD5Utils.md5(account.getPassword()));
		Account acc = accountService.findAccountByNameAndPwd(account);
		if(acc != null) {
			if(newPwd.equals(newPwd2)){
				acc.setPassword(MD5Utils.md5(newPwd));
				accountService.updateAccountPwd(acc);
			} else {
				model.addAttribute("msgpwd", "两次密码输入不一致，请重新输入！");
				return "bAccount";
			}
		} else {
			model.addAttribute("msg", "原密码输入错误，请重新输入！");
			return "bAccount";
		}
		return "redirect:bManager.do";
	}
	
//	public static void main(String[] args) {
//		String md5 = MD5Utils.md5("admin");
//		System.out.println(md5);
//	}
}
