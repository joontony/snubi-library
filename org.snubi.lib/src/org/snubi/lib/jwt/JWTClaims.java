/****************************************************************************************
 * File Name    : JWTClaims.java
 * Function     :
 * Author       : mh.choi
 * Tester       :
 * Page         :
 * Target       :
 * Description  :
 * Modification Log
 * ======================================================================================
 * Ver  Date        Author     Modification
 * ======================================================================================
   1.0  2018.07.07  mh.choi    Create
   1.1  2019.06.18  mh.choi    권한은 시스템이 추가될때 마다 수정되어야 하므로 map으로 수정함
****************************************************************************************/
package org.snubi.lib.jwt;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JWTClaims {

	String 				token		;
	String 				organization;
	String 				department	;
	long 				exp			;
	String 				id			;
	String 				name		;
	String 				title		;
	List<String> 		deviceId	;
	Map<String,String>	mapAuth		;
	
	
	public List<String> getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(List<String> deviceId) {
		this.deviceId = deviceId;
	}	
	public void addAuth(String systemName,String role) {
		if(this.mapAuth == null) {
			this.mapAuth = new HashMap<String,String>();
		}
		mapAuth.put(systemName,role);
	}
	public String getAuth(String systemName) {
		return mapAuth.get(systemName);
	}
	public String getToken() {
		return token;
	}
	public Map<String,String> getMapAuth() {
		return mapAuth;
	}
	public void setMapAuth(Map<String,String> mapAuth) {
		this.mapAuth = mapAuth;
	}
	public String getOrganization() {
		return organization;
	}
	public String getDepartment() {
		return department;
	}
	public long getExp() {
		return exp;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getTitle() {
		return title;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setExp(long exp) {
		this.exp = exp;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "JWTClaims [token=" + token + ", organization=" + organization + ", department=" + department + ", exp="
				+ exp + ", id=" + id + ", name=" + name + ", title=" + title + ", mapAuth=" + mapAuth + "]";
	}

}


