package com.whale.security.app.support;

/**
  *@ClassName AppSecretException
  *@Description TODO
  *@Author coco
  *@Data 2019/9/27 13:49
  *@Version 1.0
  **/
public class AppSecretException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1629364510827838114L;

	public AppSecretException(String msg){
		super(msg);
	}
	
}
