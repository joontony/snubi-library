/**************************************************************************************** 
 * File Name    : ModelEmrDrug
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

public class ModelEmrDrug {
	
	long seq;
	String patient;
	String ediCode;
	String department;
	String quantity;
	String frequency;
	String time;
	String route;
	String descriptionId;
	String startDate;
	String endDate;
	String duration;
	
	public long getSeq() {
		return seq;
	}
	public String getPatient() {
		return patient;
	}
	public String getEdiCode() {
		return ediCode;
	}
	public String getDepartment() {
		return department;
	}
	public String getQuantity() {
		return quantity;
	}
	public String getFrequency() {
		return frequency;
	}
	public String getTime() {
		return time;
	}
	public String getRoute() {
		return route;
	}
	public String getDescriptionId() {
		return descriptionId;
	}
	public String getStartDate() {
		return startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public String getDuration() {
		return duration;
	}
	public void setSeq(long seq) {
		this.seq = seq;
	}
	public void setPatient(String patient) {
		this.patient = patient;
	}
	public void setEdiCode(String ediCode) {
		this.ediCode = ediCode;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public void setRoute(String route) {
		this.route = route;
	}
	public void setDescriptionId(String descriptionId) {
		this.descriptionId = descriptionId;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	@Override
	public String toString() {
		return "ModelEmrDrug [seq=" + seq + ", patient=" + patient + ", ediCode=" + ediCode + ", department="
				+ department + ", quantity=" + quantity + ", frequency=" + frequency + ", time=" + time + ", route="
				+ route + ", descriptionId=" + descriptionId + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", duration=" + duration + "]";
	}	
}
