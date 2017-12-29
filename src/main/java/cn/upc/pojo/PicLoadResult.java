package cn.upc.pojo;

public class PicLoadResult {

	private int error;
	private String url;
	private String message;
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public PicLoadResult(int error, String url, String message) {
		super();
		this.error = error;
		this.url = url;
		this.message = message;
	}
	
	public PicLoadResult(){
		
	}
	
	public static PicLoadResult ok(String url){
		return new PicLoadResult(0,url,null);
	}
	
	public static PicLoadResult error(String msg){
		return new PicLoadResult(1,null,msg);
	}
	
}
