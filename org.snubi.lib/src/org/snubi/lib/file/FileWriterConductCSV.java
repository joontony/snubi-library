/****************************************************************************************
 * File Name    : FileWriterConductCSVFile
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
package org.snubi.lib.file;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.snubi.lib.model.xls.ModelConductToExcel;
import org.snubi.lib.model.xls.ModelConductToExcelElement;
import org.snubi.lib.model.xls.ModelConductToExcelHeader;

import com.opencsv.CSVWriter;

public class FileWriterConductCSV extends FileWriterInterface {

	@Override
	public String write(Map<String, Object> mapParameter) throws Exception {
		@SuppressWarnings("unused")
		boolean isToFile = (boolean) mapParameter.get("IsToFile");
		String strFileName = (String) mapParameter.get("FileName") + "." + (String) mapParameter.get("FileExtension");
		Writer clsWriter = new FileWriter(new File(strFileName));
		CSVWriter clsCSVWriter = new CSVWriter(clsWriter, ',', ' ', '-', "\n");
		try {
			int index = 0;
			/**
			 * 저장할 자료를 String배열로 전달해야 한다.
			 */
			ModelConductToExcel clsModelConductToExcel = (ModelConductToExcel) mapParameter.get("records");
			ModelConductToExcelHeader clsModelConductToExcelHeader = clsModelConductToExcel.getClsModelConductToExcelHeader();
			List<ModelConductToExcelElement> listModelConductToExcelElement = clsModelConductToExcel.getListModelConductToExcelElement();
			String[] arrStringHeader = new String[clsModelConductToExcelHeader.getListStrTitle().size() + 2];
			arrStringHeader[index++] = clsModelConductToExcelHeader.getStrSubjectId();
			arrStringHeader[index++] = clsModelConductToExcelHeader.getStrSubmitDate();
			for (String strTitle : clsModelConductToExcelHeader.getListStrTitle()) {
				arrStringHeader[index++] = strTitle;
			}
			clsCSVWriter.writeNext(arrStringHeader);

			String[] arrStringBody = new String[arrStringHeader.length];
			for (ModelConductToExcelElement clsModelConductToExcelElement : listModelConductToExcelElement) {
				index = 0;
				arrStringBody = new String[arrStringHeader.length];
				arrStringBody[index++] = clsModelConductToExcelElement.getStrSubjectId();
				arrStringBody[index++] = clsModelConductToExcelElement.getStrSubmitDate();

				for (Object strData : clsModelConductToExcelElement.getListDataObject()) {
					arrStringBody[index++] = (String) strData;
				}
				clsCSVWriter.writeNext(arrStringBody);
			}
		} catch(Exception Ex) {
			Ex.printStackTrace();
			return null;
		} finally {
			clsCSVWriter.close();
		}
		return strFileName;
	}
//	public String write(Map<String, Object> mapParameter) throws Exception {
//
//		@SuppressWarnings("unused")
//		boolean isToFile = (boolean) mapParameter.get("IsToFile");
//		String strFileName = (String) mapParameter.get("FileName") + "." + (String) mapParameter.get("FileExtension");
//		Writer clsWriter = new FileWriter(new File(strFileName));
//		CSVWriter clsCSVWriter = new CSVWriter(clsWriter, ',', ' ', '-', "\n");
//		try {
//			int index = 0;
//			/**
//			 * 저장할 자료를 String배열로 전달해야 한다.
//			 */
//			ModelConductToExcel clsModelConductToExcel = (ModelConductToExcel) mapParameter.get("records");
//			ModelConductToExcelHeader clsModelConductToExcelHeader = clsModelConductToExcel.getClsModelConductToExcelHeader();
//			List<ModelConductToExcelElement> listModelConductToExcelElement = clsModelConductToExcel.getListModelConductToExcelElement();
//			String[] arrStringHeader = new String[clsModelConductToExcelHeader.getListStrTitle().size() + 2];
//			arrStringHeader[index++] = clsModelConductToExcelHeader.getStrSubjectId();
//			arrStringHeader[index++] = clsModelConductToExcelHeader.getStrSubmitDate();
//			for (String strTitle : clsModelConductToExcelHeader.getListStrTitle()) {
//				arrStringHeader[index++] = strTitle;
//			}
//			clsCSVWriter.writeNext(arrStringHeader);
//
//			String[] arrStringBody = new String[arrStringHeader.length];
//			for (ModelConductToExcelElement clsModelConductToExcelElement : listModelConductToExcelElement) {
//				index = 0;
//				arrStringBody = new String[arrStringHeader.length];
//				arrStringBody[index++] = clsModelConductToExcelElement.getStrSubjectId();
//				arrStringBody[index++] = clsModelConductToExcelElement.getStrSubmitDate();
//				for (Object strData : clsModelConductToExcelElement.getListDataObject()) {
//					arrStringBody[index++] = (String) strData;
//				}
//				clsCSVWriter.writeNext(arrStringBody);
//			}
//		} catch(Exception Ex) {
//			Ex.printStackTrace();
//			return null;
//		} finally {
//			clsCSVWriter.close();
//		}
//		return strFileName;
//	}
}
