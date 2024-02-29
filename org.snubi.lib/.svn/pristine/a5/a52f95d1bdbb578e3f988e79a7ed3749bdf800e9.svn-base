/****************************************************************************************
 * File Name    : FileWriterConductXlsFile
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

import java.util.HashMap;
import java.util.Map;

import org.snubi.lib.model.xls.ModelConductToExcel;

import net.sf.jxls.transformer.XLSTransformer;

public class FileWriterConductXls extends FileWriterInterface {

	public String write(Map<String, Object> mapParameter) throws Exception {
		Map<String, Object> mapForJXLS = new HashMap<String, Object>();
		String strTemplateFile = (String) mapParameter.get("TemplateFile");
		String strFileName = (String) mapParameter.get("FileName") + "." + (String) mapParameter.get("FileExtension");
		boolean isToFile = (boolean) mapParameter.get("IsToFile");
		mapForJXLS.put("records", (ModelConductToExcel) mapParameter.get("records"));
		XLSTransformer transformer = new XLSTransformer();
		if (isToFile == true) {
			transformer.transformXLS(strTemplateFile, mapForJXLS, strFileName);
		} else {
			// 스트림으로 전달하는 경우는 현재 상태에서는 생략한다
			// InputStream clsInputStream = new BufferedInputStream(new FileInputStream(strTemplateFile));
			// Workbook resultWorkbook = (Workbook) transformer.transformXLS(clsInputStream,mapParam);
			// response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + ".xlsx\"");
			// OutputStream clsOutputStream = response.getOutputStream();
			// resultWorkbook.write(clsOutputStream);
		}
		return strFileName;
	}
//	public String write(Map<String, Object> mapParameter) throws Exception {
//		Map<String, Object> mapForJXLS = new HashMap<String, Object>();
//		String strTemplateFile = (String) mapParameter.get("TemplateFile");
//		String strFileName = (String) mapParameter.get("FileName") + "." + (String) mapParameter.get("FileExtension");
//		boolean isToFile = (boolean) mapParameter.get("IsToFile");
//		mapForJXLS.put("records", (ModelConductToExcel) mapParameter.get("records"));
//		XLSTransformer transformer = new XLSTransformer();
//		if (isToFile == true) {
//			transformer.transformXLS(strTemplateFile, mapForJXLS, strFileName);
//		} else {
//			// 스트림으로 전달하는 경우는 현재 상태에서는 생략한다
//			// InputStream clsInputStream = new BufferedInputStream(new FileInputStream(strTemplateFile));
//			// Workbook resultWorkbook = (Workbook) transformer.transformXLS(clsInputStream,mapParam);
//			// response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + ".xlsx\"");
//			// OutputStream clsOutputStream = response.getOutputStream();
//			// resultWorkbook.write(clsOutputStream);
//		}
//		return strFileName;
//	}
}

