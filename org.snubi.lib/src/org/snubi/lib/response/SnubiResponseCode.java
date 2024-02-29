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

public class SnubiResponseCode {
	
	String strSystem;
	String strSystemSub;
	String strCode;
	String strName;
	String strDescription;
	String strTag;
	ModelSnubiResponseCodeExtended clsModelSnubiResponseCodeExtended = new ModelSnubiResponseCodeExtended();
	 
	public void print() {
		System.out.println("strSystem       : [" + strSystem 		+ "]");
		System.out.println("strSystemSub    : [" + strSystemSub 	+ "]");
		System.out.println("strCode         : [" + strCode 			+ "]");
		System.out.println("strName         : [" + strName 			+ "]");
		System.out.println("strDescription  : [" + strDescription 	+ "]");
		System.out.println("strTag          : [" + strTag  			+ "]");
		System.out.println("EXT-strTelephone: [" + clsModelSnubiResponseCodeExtended.strTelephone	+ "]");
		System.out.println("EXT-strPost     : [" + clsModelSnubiResponseCodeExtended.strPost  		+ "]");
		System.out.println("EXT-strAddress  : [" + clsModelSnubiResponseCodeExtended.strAddress  	+ "]");
		System.out.println("EXT-strHomePage : [" + clsModelSnubiResponseCodeExtended.strHomePage  	+ "]");
	}
	public ModelSnubiResponseCodeExtended getClsModelSnubiResponseCodeExtended() {
		return clsModelSnubiResponseCodeExtended;
	}
	public void setClsModelSnubiResponseCodeExtended(ModelSnubiResponseCodeExtended clsModelSnubiResponseCodeExtended) {
		this.clsModelSnubiResponseCodeExtended = clsModelSnubiResponseCodeExtended;
	}
	public String getStrTag() {
		return strTag;
	}
	public void setStrTag(String strTag) {
		this.strTag = strTag;
	}
	public String getStrSystem() {
		return strSystem;
	}
	public String getStrSystemSub() {
		return strSystemSub;
	}
	public String getStrCode() {
		return strCode;
	}
	public String getStrName() {
		return strName;
	}
	public String getStrDescription() {
		return strDescription;
	}
	public void setStrSystem(String strSystem) {
		this.strSystem = strSystem;
	}
	public void setStrSystemSub(String strSystemSub) {
		this.strSystemSub = strSystemSub;
	}
	public void setStrCode(String strCode) {
		this.strCode = strCode;
	}
	public void setStrName(String strName) {
		this.strName = strName;
	}
	public void setStrDescription(String strDescription) {
		this.strDescription = strDescription;
	}	
	
	public class ModelSnubiResponseCodeExtended {
		
		String strTelephone = null;
		String strPost = null;
		String strAddress = null;
		String strHomePage = null;
		
		public String getStrTelephone() {
			return strTelephone;
		}
		public String getStrPost() {
			return strPost;
		}
		public String getStrAddress() {
			return strAddress;
		}
		public String getStrHomePage() {
			return strHomePage;
		}
		public void setStrTelephone(String strTelephone) {
			this.strTelephone = strTelephone;
		}
		public void setStrPost(String strPost) {
			this.strPost = strPost;
		}
		public void setStrAddress(String strAddress) {
			this.strAddress = strAddress;
		}
		public void setStrHomePage(String strHomePage) {
			this.strHomePage = strHomePage;
		}		
	}
}