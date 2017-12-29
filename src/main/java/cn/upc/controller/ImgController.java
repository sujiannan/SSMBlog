package cn.upc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import cn.upc.pojo.PicLoadResult;
import cn.upc.service.UploadImgService;

/**
 * 上传图片
 * @author sjn
 */
@Controller
@RequestMapping("/img/")
public class ImgController {

	@Autowired
	private UploadImgService imgService;
	
	@RequestMapping(value="upload.do")
	@ResponseBody
	public PicLoadResult upload( MultipartFile uploadFile ,HttpServletRequest request) {
		return imgService.uploadPic(uploadFile , null);
	}
}
