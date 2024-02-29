/****************************************************************************************
 * File Name    : FileReaderXLSByPoi
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

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReaderXLSByPoi<T> implements FileReaderInterface<T> {

	@SuppressWarnings({ "resource", "rawtypes", "unchecked" })
	@Override
	public List<T> read(File file,T notnused,boolean flag) throws Exception {
		List<T> listData = new ArrayList<T>();
        FileInputStream fisFile = null;
        try
        {
        	fisFile = new FileInputStream(file.getAbsolutePath());
            XSSFWorkbook workBook = new XSSFWorkbook(fisFile);
            for(int i = 0; i < 1; i++) {
                XSSFSheet sheet = workBook.getSheetAt(i);
                Iterator rows = sheet.rowIterator();
                while(rows.hasNext()) {
                    XSSFRow row = (XSSFRow) rows.next();
                    Iterator cells = row.cellIterator();
                    List data = new LinkedList();
                    while (cells.hasNext()) {
                        XSSFCell cell = (XSSFCell) cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        data.add(cell);
                    }
                    listData.add((T) data);
                }
            }
        }
        catch(Exception Ex) {
            Ex.printStackTrace();
        }
        finally {
            if(fisFile != null) {
                try {
                	fisFile.close();
                }
                catch(Exception Ex) {
                    Ex.printStackTrace();
                }
            }
        }
        return listData;
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
