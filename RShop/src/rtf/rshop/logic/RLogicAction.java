package rtf.rshop.logic;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

public abstract class RLogicAction{
	/*
	 * RLogicAction����json�ַ���
	 */
	protected Map<String,Object> responseProperties = new HashMap<String,Object>() ;
	
	public Map<String,Object> getResponseProperties(){
		return responseProperties ;
	}
	
	public abstract void performExecute();
	
	public String execute(){
		
		//ִ�н������ඨ����߼�
		performExecute();
		
		
		
		return "success" ;
	}
	/**
	 * ����action���ص�json����
	 * @param responseProperties
	 */
	protected void setResponseProperties(Map<String, Object> responseProperties){
		this.responseProperties = responseProperties ;
	}
	
	/**
	 * ���÷��ز���
	 * @param key ��������
	 * @param value ����ֵ
	 */
	protected void putResponseProperty(String key , Object value){
		responseProperties.put(key, value);
	}


	
	
}
