/**************************************************************************************** 
 * File Name    : ModelBioEmrCrfJaxB
 * Function     : 
 * Author       : mh.choi
 * Tester       : 
 * Page         : 
 * Target       : 
 * Description  : BioEmrCFR Form을 파싱하여. 리턴할 모델 
 * 				: @XmlElement 지정함에 유의하라
 * Modification Log
 * =============================================================== 
 * Ver  Date        Author     Modification
 * ===============================================================
   1.0  2018.06.19  mh.choi     Create
****************************************************************************************/
package org.snubi.lib.model.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "form")
public class ModelBioEmrCrfJaxB {
	
	String id;
	String name;
		
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	@XmlElement(name="id")
	public void setId(String id) {
		this.id = id;
	}
	@XmlElement(name="name")
	public void setName(String name) {
		this.name = name;
	}
	
	List<ModelBioEmrCrfSection> listModelBioEmrCrfSection;
	
	public List<ModelBioEmrCrfSection> getListModelBioEmrCrfSection() {
		return listModelBioEmrCrfSection;
	}
	@XmlElement(name="section")
	public void setListModelBioEmrCrfSection(List<ModelBioEmrCrfSection> listModelBioEmrCrfSection) {
		this.listModelBioEmrCrfSection = listModelBioEmrCrfSection;
	}
	public void addListModelBioEmrCrfSection(ModelBioEmrCrfSection clsModelBioEmrCrfSection) {
		this.listModelBioEmrCrfSection.add(clsModelBioEmrCrfSection);
	}
	public void print() {
		System.out.println("#id# " + getId());
		System.out.println("#name# " + getName());
		for(int i = 0; i < listModelBioEmrCrfSection.size(); i ++ ) {
			printWithoutNull("#form#section#name#",listModelBioEmrCrfSection.get(i).getName());
			printWithoutNull("#form#section#FSId#",listModelBioEmrCrfSection.get(i).getFSId() + "");
			List<ModelBioEmrCrfQuestion> listModelBioEmrCrfQuestion = listModelBioEmrCrfSection.get(i).getListModelBioEmrCrfQuestion();
			if(listModelBioEmrCrfQuestion != null) {
				for(int j = 0; j < listModelBioEmrCrfQuestion.size(); j ++ ) {
					printWithoutNull("#form#section(" + i + ")#question#name#",listModelBioEmrCrfQuestion.get(j).getParameterName()
							+ " >> " + listModelBioEmrCrfQuestion.get(j).getFsqId()
							+ " >> " + listModelBioEmrCrfQuestion.get(j).getDatatype()
							+ " >> " + listModelBioEmrCrfQuestion.get(j).getRepresentationType()
							+ " >> " + listModelBioEmrCrfQuestion.get(j).getDeName()
							+ " >> " + listModelBioEmrCrfQuestion.get(j).getDeId()
							+ " >> " + listModelBioEmrCrfQuestion.get(j).getListStrItem()
							);					
				}			
			}
		}
	}	
	private void printWithoutNull(String strTitle,String strBuffer) {
		try {
			System.out.println(strTitle + " " + strBuffer);
		} catch(Exception Ex) {
			System.out.println(strTitle + " null");
		}
	}
}
