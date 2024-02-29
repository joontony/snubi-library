/****************************************************************************************
 * File Name    : ModelConductToExcel
 * Function     :
 * Author       : mh.choi
 * Tester       :
 * Page         :
 * Target       :
 * Description  : JXLS 에서 사용할 모델
 * 				: 열의 개수가 미리 지정될 수 없음.
 * Modification Log
 * ===============================================================
 * Ver  Date        Author     Modification
 * ===============================================================
   1.0  2018.06.21  mh.choi     Create
****************************************************************************************/
package org.snubi.lib.model.xls;

import java.util.List;

public class ModelConductToExcel {

	String strStudyName;
	String strDateExtract;
	long longTotal;
	ModelConductToExcelHeader clsModelConductToExcelHeader;
	List<ModelConductToExcelElement> listModelConductToExcelElement;

	public ModelConductToExcelHeader getClsModelConductToExcelHeader() {
		return clsModelConductToExcelHeader;
	}
	public void setClsModelConductToExcelHeader(ModelConductToExcelHeader clsModelConductToExcelHeader) {
		this.clsModelConductToExcelHeader = clsModelConductToExcelHeader;
	}
	public String getStrStudyName() {
		return strStudyName;
	}
	public String getStrDateExtract() {
		return strDateExtract;
	}
	public long getLongTotal() {
		return longTotal;
	}
	public List<ModelConductToExcelElement> getListModelConductToExcelElement() {
		return listModelConductToExcelElement;
	}
	public void setStrStudyName(String strStudyName) {
		this.strStudyName = strStudyName;
	}
	public void setStrDateExtract(String strDateExtract) {
		this.strDateExtract = strDateExtract;
	}
	public void setLongTotal(long longTotal) {
		this.longTotal = longTotal;
	}
	public void setListModelConductToExcelElement(List<ModelConductToExcelElement> listModelConductToExcelElement) {
		this.listModelConductToExcelElement = listModelConductToExcelElement;
	}
	@Override
	public String toString() {
		return "ModelConductToExcel [strStudyName=" + strStudyName + ", strDateExtract=" + strDateExtract
				+ ", longTotal=" + longTotal + ", clsModelConductToExcelHeader=" + clsModelConductToExcelHeader
				+ ", listModelConductToExcelElement=" + listModelConductToExcelElement + "]";
	}
}
