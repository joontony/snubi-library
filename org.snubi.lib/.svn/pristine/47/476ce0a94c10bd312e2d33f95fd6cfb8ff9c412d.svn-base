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
 * Ver  Date        Author    	Modification
 * ===============================================================
   1.0  2018.05.08  mh.choi     Create
   1.1  2018.05.12  mh.choi     Chaset 인코딩이 없는 경우가 있다(ANSI등)
****************************************************************************************/
package org.snubi.lib.file;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.List;

import org.mozilla.universalchardet.UniversalDetector;
import org.snubi.lib.misc.Misc;

public class FileReaderCSV<T> implements FileReaderInterface<T> {

	byte[] byteBuffer = null;
	UniversalDetector clsDetector = null;
	String strEncodeing = null;
	int intRead;

	@SuppressWarnings("resource")
	@Override
	public List<T> read(File file, T param,boolean flag) throws Exception {
		byteBuffer = new byte[(int)file.length()];
		FileInputStream clsFileInputStream = new FileInputStream(file);
		clsDetector = new UniversalDetector(null);
		while((intRead = clsFileInputStream.read(byteBuffer)) > 0 && !clsDetector.isDone()) {
			clsDetector.handleData(byteBuffer, 0, intRead);
		}
		clsDetector.dataEnd();
		// 메모패등에서 작성한 text 문서일 경우 encoding-char가 null 인 경우가 있을 수 있음.
		this.strEncodeing = clsDetector.getDetectedCharset();
		clsDetector.reset();
		return null;
	}
	@Override
	public String getEncodingChar() throws Exception {
		return this.strEncodeing;
	}
	@Override
	public String getBuffer(String strCharset) throws Exception {
		if(Misc.isEmtyString(this.strEncodeing) == true || Misc.isEmtyString(strCharset) == true) {
			return new String(byteBuffer);
		} else if(strCharset.toUpperCase().equals(this.strEncodeing.toUpperCase()) == true) {
			return new String(byteBuffer,this.strEncodeing);
		} else {
			Charset charset = Charset.forName(strCharset);
			CharBuffer charBuffer = CharBuffer.wrap(new String(byteBuffer).toCharArray());
			ByteBuffer byteBuffer = charset.encode(charBuffer);
			return new String(byteBuffer.array(), charset);
		}
	}
	@Override
	public int getLength() throws Exception {
		return this.intRead;
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
