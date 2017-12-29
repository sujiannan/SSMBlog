package cn.upc.service.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Random;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cn.upc.pojo.PicLoadResult;
import cn.upc.service.UploadImgService;
import cn.upc.utils.SFTPUtil;

@Service
public class UploadImgServiceImpl implements UploadImgService{

	public static final String IMG_PATH = "http://123.56.219.223:81/";
	
	public PicLoadResult uploadPic(MultipartFile file ,String contextPath) {
		InputStream inputStream = null;
		String url = contextPath + "/";
		if(file.isEmpty()) {
			return PicLoadResult.error("图片为空！");
		}
		
		try {
			inputStream = file.getInputStream();
			String originalFilename = file.getOriginalFilename();
			int index = originalFilename.lastIndexOf(".");
			String lastName = originalFilename.substring(index);
			long currentTimeMillis = System.currentTimeMillis();
			Random r = new Random();
			StringBuffer sb = new StringBuffer();
			sb.append(currentTimeMillis);
			for (int i = 0; i < 5; i++) {
				sb.append(r.nextInt(10));
			}
			sb.append(lastName);
			String picName = sb.toString();
			// 通过sftp 上传到图片服务器
			SFTPUtil.uploadImg(picName, inputStream);
			
			inputStream.close();
			return PicLoadResult.ok( IMG_PATH + picName);
		} catch (Exception e) {
			e.printStackTrace();
			return PicLoadResult.error("图片服务器出错！");
		}
	}

	
}
