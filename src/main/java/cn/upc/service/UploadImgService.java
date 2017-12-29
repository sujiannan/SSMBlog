package cn.upc.service;

import org.springframework.web.multipart.MultipartFile;

import cn.upc.pojo.PicLoadResult;

public interface UploadImgService {

	public PicLoadResult uploadPic(MultipartFile file, String contextPath);
}
