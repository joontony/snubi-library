/****************************************************************************************
 * File Name    : LoginPacket
 * Function     :
 * Author       : 최명호
 * Tester       :
 * Page         :
 * Target       :
 * Description  : 로그인 요청 바디
 * ======================================================================================
 * Ver  Date        	Author     	Modification
 * ======================================================================================
   1.0 	2020.03.06		mh.choi	 	파일생성
****************************************************************************************/
package org.snubi.lib.auth;

import org.snubi.lib.json.JsonUtil;

public class LoginPacket {

	String email;
	String password;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LoginPacket(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	public String toJsonString() throws Exception {
		JsonUtil<LoginPacket> clsJsonUtil = new JsonUtil<LoginPacket>();
		return clsJsonUtil.toString(this);
	}
}
