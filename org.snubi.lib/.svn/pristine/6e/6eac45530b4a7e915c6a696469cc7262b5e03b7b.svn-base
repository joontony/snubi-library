/**************************************************************************************** 
 * File Name    : ModelSnubiResponseCode.java
 * Function     : 
 * Author       : mh.choi
 * Tester       : 
 * Page         : 
 * Target       : 
 * Description  : 
 * Modification Log
 * =============================================================== 
 * Ver  Date        Author     Modification
 * ===============================================================
   1.0  2018.05.25  mh.choi    Create
****************************************************************************************/
package org.snubi.lib.response;

import java.sql.Timestamp;

public class SnubiResponseJwt {
	
	String strSub;
	String strOrganization;
	String strName;
	String strId;
	Long longExp;
	String strDepartment;
	String strTitle;
	
	public String getStrSub() {
		return strSub;
	}
	public String getStrOrganization() {
		return strOrganization;
	}
	public String getStrName() {
		return strName;
	}
	public String getStrId() {
		return strId;
	}
	public Long getLongExp() {
		return longExp;
	}
	public String getStrDepartment() {
		return strDepartment;
	}
	public String getStrTitle() {
		return strTitle;
	}
	public void setStrSub(String strSub) {
		this.strSub = strSub;
	}
	public void setStrOrganization(String strOrganization) {
		this.strOrganization = strOrganization;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public void setStrId(String strId) {
		this.strId = strId;
	}
	public void setLongExp(Long longExp) {
		this.longExp = longExp;
	}
	public void setStrDepartment(String strDepartment) {
		this.strDepartment = strDepartment;
	}
	public void setStrTitle(String strTitle) {
		this.strTitle = strTitle;
	}
	public boolean isExpired() {
		Timestamp clsTimestamp = new Timestamp(System.currentTimeMillis());		
		if(this.longExp < clsTimestamp.getTime()) {			
			return false;
		}				
		return true;
	}
	public void print() {
		System.out.println("strSub	        : [" + strSub 			+ "]");
		System.out.println("strOrganization	: [" + strOrganization 	+ "]");
		System.out.println("strName	        : [" + strName 			+ "]");
		System.out.println("strId	        : [" + strId 			+ "]");
		System.out.println("strExp	        : [" + longExp 			+ "]");
		System.out.println("strDepartment	: [" + strDepartment 	+ "]");
		System.out.println("strTitle	    : [" + strTitle 		+ "]");
		System.out.println("isExpired	    : [" + isExpired() 		+ "]");
	}
}