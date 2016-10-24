package rtf.rshop.logic;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public abstract class RLogicAction{
	/*
	 * RLogicAction返回json字符串
	 */
	protected Map<String,Object> responseProperties = new HashMap<String,Object>() ;
	
	public Map<String,Object> getResponseProperties(){
		return responseProperties ;
	}
	
	public abstract void performExecute();
	
	public String execute(){
		
		//执行将由子类定义的逻辑
		performExecute();
		
		
		
		return "success" ;
	}
	/**
	 * 设置action返回的json参数
	 * @param responseProperties
	 */
	protected void setResponseProperties(Map<String, Object> responseProperties){
		this.responseProperties = responseProperties ;
	}
	
	/**
	 * 设置返回参数
	 * @param key 参数键名
	 * @param value 参数值
	 */
	protected void putResponseProperty(String key , Object value){
		responseProperties.put(key, value);
	}


	
	
}
