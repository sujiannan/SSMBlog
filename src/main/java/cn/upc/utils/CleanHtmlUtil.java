package cn.upc.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CleanHtmlUtil {

	private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式  
	// 获取img标签正则  
    private static final String IMGURL_REG = "<\\s*img.+?>";  
    
    private static final String regEx_imgClass_html = "class.+?\"";
	/**
	 * 清除Html标签  截取前500字符 并去除Html标签
	 */
	public static String CleanHtml(String context) {
		if(context.length() > 500) {
			context = context.substring(0, 500);
			int len = 0;
			if(( len = context.lastIndexOf("<")) > 0) {
	        	context = context.substring(0, len);
	        }
			context +="...";
		}
		Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);  
        Matcher m_html = p_html.matcher(context);  
        context = m_html.replaceAll(""); // 过滤html标签  
  
        context =  context.trim(); // 返回文本字符串  
		return context;
	}
	
	/**
	 * 获取第一张图片html
	 */
	public static String getImgHtml(String context) {
		List<String> list = getImageUrl(context);
		if(list != null && list.size() > 0) {
			return addClassForImgHtml(list.get(0));
			//return list.get(0);
		}
		return "";
	}
	
	/*** 
     * 获取Image标签
     */  
    private static List<String> getImageUrl(String HTML) {  
        Matcher matcher = Pattern.compile(IMGURL_REG).matcher(HTML);  
        List<String> listImgUrl = new ArrayList<String>();  
        while (matcher.find()) {  
            listImgUrl.add(matcher.group());  
        }  
        return listImgUrl;  
    }  
    
    /**
	 * 给图片增加 class="img-responsive"
	 */
    private static String addClassForImgHtml(String imgHtml) {
    	if(imgHtml.contains("class")){
	    	Pattern p_html = Pattern.compile(regEx_imgClass_html, Pattern.CASE_INSENSITIVE);  
	        Matcher m_html = p_html.matcher(imgHtml);  
	        imgHtml = m_html.replaceAll(" class=\"img-responsive\""); // 过滤html标签  
    	} else {
    		imgHtml = imgHtml.substring(0, imgHtml.lastIndexOf('>'));
    		imgHtml += " class=\"img-responsive\" >";
    	}
		return imgHtml;
    }
    
	
	
    //测试
	public static void main(String[] args) {
		String imgHtml = getImgHtml(" <div class=\"two\"><img src=\"http://files.jb51.net/images/m.jb51.net.png\" data-baiduimageplus-ignore ></div> "+    
        "<li class=\"watch\"> " +
        " target=\"_blank\" rel=\"nofollow\" ><i class=\"icon\"></i>关注微信</a></div> " +
        " <img src=http:\\\\files.jb51.net/images/weixin_200.gif\" data-baiduimageplus-ignore /></div> ");
		imgHtml = addClassForImgHtml(imgHtml);
		System.out.println(imgHtml);
	}
	
	
}
