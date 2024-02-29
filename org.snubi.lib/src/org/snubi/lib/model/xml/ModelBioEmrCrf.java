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

public class ModelBioEmrCrf {
	
	ModelBioEmrCrfForm clsModelBioEmrCrfForm;
	List<ModelBioEmrCrfSection> listModelBioEmrCrfSection;
	
	public ModelBioEmrCrfForm getClsModelBioEmrCrfForm() {
		return clsModelBioEmrCrfForm;
	}
	public List<ModelBioEmrCrfSection> getListModelBioEmrCrfSection() {
		return listModelBioEmrCrfSection;
	}
	public void setClsModelBioEmrCrfForm(ModelBioEmrCrfForm clsModelBioEmrCrfForm) {
		this.clsModelBioEmrCrfForm = clsModelBioEmrCrfForm;
	}
	public void setListModelBioEmrCrfSection(List<ModelBioEmrCrfSection> listModelBioEmrCrfSection) {
		this.listModelBioEmrCrfSection = listModelBioEmrCrfSection;
	}
	public void addListModelBioEmrCrfSection(ModelBioEmrCrfSection clsModelBioEmrCrfSection) {
		this.listModelBioEmrCrfSection.add(clsModelBioEmrCrfSection);
	}
}
