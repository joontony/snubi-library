/**************************************************************************************************
 * File Name    : CSVFileReader
 * Function     :
 * Author       : 최명호
 * Tester       :
 * Page         :
 * Target       :
 * Description  :
 * Modification Log
 * ================================================================================================
 * Ver  Date        Author     Modification
 * ================================================================================================
   1.0  2018.05.08  최명호     	Create
   1.1  2019.04.05  최명호     	바인딩방식을 수정함.
   1.2  2019.05.06  최명호     	첫번째 행을 Validation에 사용함.
   1.3	2020.07.24	최명호 		개행문자를 전달받은 프래그에 따라 특정문자로 치환한다.
   1.4	2021.04.23	최명호		백병원 - vitalsign 예외처리, 자료가 없는 경우, 구분자가 부족함.
   1.5	2021.05.11	최명호 		CSV파일처리시  deletemeter를 파라미터로 수신하여 처리하도록.
**************************************************************************************************/
package org.snubi.lib.file;

import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.snubi.lib.misc.Misc;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class FileReaderOpenCSV<T> implements FileReaderInterface<T> {

	String _DELEMETER_ = "^";

	@Override
	public List<T> read(File file, T param,boolean flagForCRLF,String delemeter) throws Exception {
		_DELEMETER_ = delemeter;
		List<T> listT = read(file,param, flagForCRLF);
//		DESC >> 변경사용후, 원래 구분자로..
		_DELEMETER_ = "^";
		return listT;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<T> read(File file,T param, boolean flagForCRLF) throws Exception {
		CsvToBean<T> 	csvToBean 	;
		Reader 			clsReader 	= null;
		FileUtil 		clsFileUtil = new FileUtil();
		try {
			clsFileUtil.insertUOM2File(file,false);
			List<String> listLineString = FileUtils.readLines(file,StandardCharsets.UTF_8.name());
			StringBuffer strBuffer = new StringBuffer();
			int maxCount = Misc.getDelemeterCount(listLineString.get(0),_DELEMETER_);
        	int forCount = 0;

        	for(String strLine : listLineString) {
//        		DESC >> 파일예외처리 : 서울백병원인 경우, 구분자가 모자람. 병원에서 파일을 수정함.
        		if(file.getName().contains("vitalsign") == true) {
        			for(int x = 0; x < (11-Misc.getDelemeterCount(strLine,"^")); x ++ ) {
        				strLine += "^";
        			}
        		}
        		forCount += Misc.getDelemeterCount(strLine,_DELEMETER_);
        		if(forCount < maxCount)	{
        			if(flagForCRLF == true)
        					strBuffer.append(strLine + "__CRLF__");
        			else 	strBuffer.append(strLine + " ");
        		}
        		else {
        			strBuffer.append(strLine + "\n");
        			forCount = 0;
        		}
            }
        	clsReader = new StringReader(strBuffer.toString());
			ColumnPositionMappingStrategy clsColumnPositionMappingStrategy = new ColumnPositionMappingStrategy();
			clsColumnPositionMappingStrategy.setType(param.getClass());
//			HISTORY >> 첫번째 행은 이름을 검사하도록 수정함.
//			HISTORY >> .withSkipLines(1)
			csvToBean  = new CsvToBeanBuilder<T>(clsReader)
							.withSeparator(_DELEMETER_.charAt(0))
							.withMappingStrategy(clsColumnPositionMappingStrategy)
							.withType((Class<T>) param.getClass())
							.withIgnoreLeadingWhiteSpace(true)
							.build();
			List<T> listT = csvToBean.parse();
			return listT;
		} catch (Exception Ex) {
			throw Ex;
		} finally {
			try {
				clsReader.close();
			} catch (Exception EE) {

			}
		}
	}
	@Override
	public String getEncodingChar() throws Exception {
		throw new Exception("not supported");
	}
	@Override
	public String getBuffer(String strCharset) throws Exception {
		throw new Exception("not supported");
	}
	@Override
	public int getLength() throws Exception {
		return 0;
	}
	@Override
	public List<T> read(File file, T param) throws Exception {
		return read(file,param, false);
	}
}
