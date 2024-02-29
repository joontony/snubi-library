/****************************************************************************************
 * File Name    : EMRFileList
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
   1.0  2018.04.04  mh.choi     Create
   1.0  2018.05.11  mh.choi     처리할 파일을 재 처리등의 목적으로 모두 UTF8로 변경후 처리함.
****************************************************************************************/
package org.snubi.lib.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

import org.snubi.lib.misc.Misc;

public class EMRFileList implements FileListInterface {

	@Override
	public File[] get(File fileDirectory) throws Exception {
		if (fileDirectory.isDirectory() == true) {
			return fileDirectory.listFiles();
		}
		throw new Exception("파라미터가 디렉토리가 아닙니다.");
	}
	@Override
	public boolean move(File fileDest, File FileDirectory) throws Exception {
		String newFileName = Misc.setEndWith(FileDirectory.getPath(), File.separator) + fileDest.getName();
		File target = new File(newFileName);
		return fileDest.renameTo(target);
	}
	@Override
	public File makeSubDirectory(File dirBase, String strPrefix) throws Exception {
		String strNewFileName = Misc.setEndWith(dirBase.getPath(), File.separator) + strPrefix;
		File dirTarget = new File(strNewFileName);
		if (dirTarget.exists() == true) {
			return dirTarget;
		} else {
			if (dirTarget.mkdirs() == true) {
				return dirTarget;
			}
		}
		return null;
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean convertFile2UTF(File fileTarget) throws Exception {
		StringBuffer stringBuffer = new StringBuffer();
		Writer clsWriter = null;
		FileReaderCSV clsCSVFileReader = new FileReaderCSV();
		clsCSVFileReader.read(fileTarget,this.getClass(),false);
		// UTF-8로 변환저장
		if(StandardCharsets.UTF_8.name().equals(clsCSVFileReader.getEncodingChar()) == false) {
			stringBuffer.append(clsCSVFileReader.getBuffer(clsCSVFileReader.getEncodingChar()));
			FileOutputStream clsFileOutputStream = new FileOutputStream(fileTarget);
			clsWriter = new OutputStreamWriter(clsFileOutputStream, StandardCharsets.UTF_8.name());
			clsWriter.write("\uFEFF");
			clsWriter.write(stringBuffer.toString());
			stringBuffer.setLength(0);
			clsWriter.close();
		}
		return true;
	}
}
