/****************************************************************************************
 * File Name    : CSVFileReader
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
   1.0  2018.05.08  mh.choi     Create
****************************************************************************************/
package org.snubi.lib.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class OpenCSVFileReader<T> implements FileReaderInterface<T> {
	@SuppressWarnings("unchecked")
	@Override
	public List<T> read(File file,T param,boolean flag) throws Exception {
		BufferedReader fileReader = null;
		CsvToBean<T> csvToBean = null;
		try {
			fileReader = new BufferedReader(new FileReader(file));
			csvToBean  = new CsvToBeanBuilder<T>(fileReader)
							.withSkipLines(1)
							.withSeparator('^')
							.withType((Class<? extends T>) param)
							.withIgnoreLeadingWhiteSpace(true)
							.build();
			List<T> listT = csvToBean.parse();
			return listT;
		} catch (Exception Ex) {
			throw Ex;
		} finally {
			try {
				fileReader.close();
			} catch (Exception EE) {
				throw EE;
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
	@Override
	public List<T> read(File file, T param, boolean flagCRLF, String delemeter) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
