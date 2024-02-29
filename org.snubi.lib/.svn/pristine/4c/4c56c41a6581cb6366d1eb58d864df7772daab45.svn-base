/**************************************************************************************** 
 * File Name    : ModelBioEmrCrf
 * Function     : 
 * Author       : mh.choi
 * Tester       : 
 * Page         : 
 * Target       : 
 * Description  : BioEmrCFR Form을 파싱하여. 리턴할 모델 
 * Modification Log
 * =============================================================== 
 * Ver  Date        Author     Modification
 * ===============================================================
   1.0  2018.06.19  mh.choi     Create
****************************************************************************************/
package org.snubi.lib.model.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

public class ModelBioEmrCrfSection {
	
	String name;
	long FSId;
	String instruction;
	List<ModelBioEmrCrfQuestion> listModelBioEmrCrfQuestion;
	
	public String getName() {
		return name;
	}
	public long getFSId() {
		return FSId;
	}
	public String getInstruction() {
		return instruction;
	}
	public List<ModelBioEmrCrfQuestion> getListModelBioEmrCrfQuestion() {
		return listModelBioEmrCrfQuestion;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name="f_s_id")
	public void setFSId(long fSId) {
		FSId = fSId;
	}
	@XmlElement
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	@XmlElement(name="question")
	public void setListModelBioEmrCrfQuestion(List<ModelBioEmrCrfQuestion> listModelBioEmrCrfQuestion) {
		this.listModelBioEmrCrfQuestion = listModelBioEmrCrfQuestion;
	}
	public void addListModelBioEmrCrfQuestion(ModelBioEmrCrfQuestion clsModelBioEmrCrfQuestion) {
		this.listModelBioEmrCrfQuestion.add(clsModelBioEmrCrfQuestion);
	}
}
