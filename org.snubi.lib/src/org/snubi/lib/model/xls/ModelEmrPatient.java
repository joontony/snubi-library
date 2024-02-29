/**************************************************************************************** 
 * File Name    : ModelEmrPatient
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
   1.0  2018.06.21  mh.choi     Create
****************************************************************************************/
package org.snubi.lib.model.xls;

public class ModelEmrPatient {
	
	long seq		;
	String number	;	
	String name		;
	String birth	;
	String gender	;
	
	public long getSeq() {
		return seq;
	}
	public String getNumber() {
		return number;
	}
	public String getName() {
		return name;
	}
	public String getBirth() {
		return birth;
	}
	public String getGender() {
		return gender;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "ModelEmrPatient [seq=" + seq + ", number=" + number + ", name=" + name + ", birth=" + birth + ", gender=" + gender + "]";
	}
}
