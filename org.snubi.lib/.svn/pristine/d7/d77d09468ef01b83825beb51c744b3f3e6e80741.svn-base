/****************************************************************************************
 * File Name    : FileUtil.java
 * Function     :
 * Author       : mh.choi
 * Tester       :
 * Page         :
 * Target       :
 * Description  :
 * Modification Log
 * ======================================================================================
 * Ver  Date        Author     Modification
 * ======================================================================================
   1.0  2018.06.15  mh.choi    	Create
   1.1  2018.05.08	최명호		move 시 이전파일 강제삭제
   1.2	2019.12.19	최명호		파일사이즈를 비교, 파일쓰기가 완료되었는지 확인함
 ****************************************************************************************/
package org.snubi.lib.file;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileDeleteStrategy;
import org.apache.commons.io.FileUtils;
import org.snubi.lib.misc.Misc;

import com.ibm.icu.text.CharsetDetector;
import com.ibm.icu.text.CharsetMatch;

@SuppressWarnings({"unchecked","rawtypes"})
public class FileUtil implements FileUtilInterface {

	@Override
	public File[] get(File fileDirectory) throws Exception {
		if (fileDirectory.isDirectory() == true) {
			return fileDirectory.listFiles();
		}
		throw new Exception("파라미터가 디렉토리가 아닙니다.");
	}
	private boolean isCompletelyWritten(File file) throws Exception {
	    Long fileSizeBefore = file.length();
	    Thread.sleep(100);
	    Long fileSizeAfter = file.length();
	    if (fileSizeBefore.equals(fileSizeAfter)) {
	        return true;
	    }
	    return false;
	}
	@Override
	public List<File> get(String strDirectory) throws Exception {
		List<File> listFile = new ArrayList<File>();
		File[] arrayFiles = this.get(new File(strDirectory));
		for(File clsFile : arrayFiles) {
			if(clsFile.isFile()) {
				if(isCompletelyWritten(clsFile) == true) {
					listFile.add(clsFile);
				}
			}
		}
		return listFile;
	}
	@Override
	public List<File> get(String strDirectory,boolean isChecked) throws Exception {
		List<File> listFile = new ArrayList<File>();
		File[] arrayFiles = this.get(new File(strDirectory));
		for(File clsFile : arrayFiles) {
			if(clsFile.isFile()) {
				if(isChecked == true) {
					if(isCompletelyWritten(clsFile) == true) {
						listFile.add(clsFile);
					}
				} else listFile.add(clsFile);
			}
		}
		return listFile;
	}

	public String copyToDirectory(File fileSource, File fileTargetDirectory) throws Exception {
		File target = null;
		try {
			String newFileName = Misc.setEndWith(fileTargetDirectory.getPath(), File.separator) + fileSource.getName();
			target = new File(newFileName);
			if(target.exists()) target.delete();
			Files.copy(fileSource.toPath(),target.toPath(),StandardCopyOption.REPLACE_EXISTING);
			return newFileName;
		} catch(Exception Ex) {
			System.out.println("#Ex.Lib.FileUtil:copyToDirectory# " + Ex.getMessage() +  " ##");
		}
		return null;
	}
	@Override
	public boolean moveToDirectory(File fileSource, File fileTargetDirectory) throws Exception {
		File target = null;
		try {
			String newFileName = Misc.setEndWith(fileTargetDirectory.getPath(), File.separator) + fileSource.getName();
			target = new File(newFileName);
			if(target.exists()) target.delete();
			Files.move(fileSource.toPath(),target.toPath(),StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch(Exception Ex) {
			System.out.println("#Ex.Lib.FileUtil# " + Ex.getMessage() +  " ##");
			try {
				FileDeleteStrategy.FORCE.delete(target);
				FileUtils.moveFile(fileSource, target);
			} catch(IOException Ee) {
				System.out.println("@Ex.Lib.FileUtil:moveToDirectory@ " + Ee.getMessage() +  " @@");
			}
			return false;
		}
	}
	@Override
	public boolean moveFile(File fileSource, File fileTarget) throws Exception {
		try {
			if(fileTarget.exists()) fileTarget.delete();
			Files.move(fileSource.toPath(),fileTarget.toPath(),StandardCopyOption.REPLACE_EXISTING);
			return true;
		} catch(Exception Ex) {
			System.out.println("#Ex.Lib.FileUtil# " + Ex.getMessage() +  " ##");
			try {
				FileDeleteStrategy.FORCE.delete(fileTarget);
				FileUtils.moveFile(fileSource, fileTarget);
			} catch(IOException Ee) {
				System.out.println("@Ex.Lib.FileUtil@ " + Ee.getMessage() +  " @@");
			}
			return false;
		}
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
	public boolean insertUOM2File(File fileTarget,boolean isForced) throws Exception {
		StringBuffer stringBuffer = new StringBuffer();
		Writer clsWriter = null;
		FileReaderCSV clsCSVFileReader = new FileReaderCSV();
		clsCSVFileReader.read(fileTarget,this.getClass(),false);
		boolean flag = !StandardCharsets.UTF_8.name().equals(clsCSVFileReader.getEncodingChar());
		if(isForced == true) flag = true;
		if(flag == true) {
			stringBuffer.append(clsCSVFileReader.getBuffer(clsCSVFileReader.getEncodingChar()));
			FileOutputStream clsFileOutputStream = new FileOutputStream(fileTarget);
			clsWriter = new OutputStreamWriter(clsFileOutputStream, StandardCharsets.UTF_8.name());
			clsWriter.write("\uFEFF");
			String buffer = stringBuffer.toString().replace("encoding=\"euc-kr\"", "encoding=\"utf-8\"");
			clsWriter.write(buffer);
			stringBuffer.setLength(0);
			clsWriter.close();
		}
		return true;
	}
	public boolean convertToFileCP949ToUTF(File fileTarget)  {
		CharsetDetector clsCharsetDetector;
		FileInputStream clsFileInputStreamForDetectCharset = null;
		FileInputStream clsFileInputStreamForConvert = null;
		InputStreamReader clsInputStreamReader = null;
		String charsetFromCP949 = "CP949";
		String charsetToUTF = "UTF-8";
		String charsetEUCKR = "EUC-KR";
		try {
//			DESC >> Encoding-charset 확인
			byte[] byteData = new byte[(int) fileTarget.length()];
			clsFileInputStreamForDetectCharset = new FileInputStream(fileTarget);
			clsFileInputStreamForDetectCharset.read(byteData);
			clsFileInputStreamForDetectCharset.close();
			clsCharsetDetector = new CharsetDetector();
			clsCharsetDetector.setText(byteData);
			CharsetMatch clsCharsetMatch = clsCharsetDetector.detect();
			clsFileInputStreamForDetectCharset.close();
//			DESC >> convert : EUC-KR 이지만 CP(MS)949 로 인코딩되어 있다면
			if(Misc.isEqualStringIgnoreSpaceCase(charsetEUCKR, clsCharsetMatch.getName()) == true) {
				clsFileInputStreamForConvert = new FileInputStream(fileTarget);;
				Reader clsReader = null;
				Writer clsWriter = null;
				StringBuffer stringBuffer = new StringBuffer();
				int intRead = 0;
				Charset inputCharset = Charset.forName(charsetFromCP949);
				clsInputStreamReader = new InputStreamReader(clsFileInputStreamForConvert, inputCharset);
				clsReader = new BufferedReader(clsInputStreamReader);
				while((intRead = clsReader.read()) > -1) {
					stringBuffer.append((char)intRead);
				}
				clsReader.close();
				FileOutputStream clsFileOutputStream = new FileOutputStream(fileTarget);
				clsWriter = new OutputStreamWriter(clsFileOutputStream, charsetToUTF);
				clsWriter.write("\uFEFF");
				clsWriter.write(stringBuffer.toString());
				stringBuffer.setLength(0);
				clsWriter.close();
			}
		} catch (Exception Ex) {
			return false;
		} finally {
			try {clsFileInputStreamForDetectCharset.close();	} catch (Exception e) {}
			try {clsFileInputStreamForConvert.close();			} catch (Exception e) {}
			try {clsInputStreamReader.close();					} catch (Exception e) {}
		}
		return true;
	}
	public String downloadByStream(String strUrl, String strFile) throws Exception {
        URL clsURL = new URL(strUrl);
        BufferedInputStream bufferedInputStream = new BufferedInputStream(clsURL.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(strFile);
        byte[] buffer = new byte[1024];
        int count = 0;
        while((count = bufferedInputStream.read(buffer,0,1024)) != -1) {
        	fileOutputStream.write(buffer, 0, count);
        }
        fileOutputStream.close();
        bufferedInputStream.close();
		return strFile;
    }
	public String downloadByNIO(String strUrl, String strFile) throws Exception {
        URL clsURL = new URL(strUrl);
        ReadableByteChannel readableByteChannel = Channels.newChannel(clsURL.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(strFile);
        fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        fileOutputStream.close();
        readableByteChannel.close();
		return strFile;
    }
	public boolean isNewFile(String strUrl,String strPath) throws Exception {
		Path clsPath = Paths.get(strPath);
		URLConnection clsURLConnection = new URL(strUrl).openConnection();
		@SuppressWarnings("unused")
		String strLastModified = clsURLConnection.getHeaderField("Last-Modified");
		long longRemoteFileSize = clsURLConnection.getContentLength();
		try {
			if(Files.size(clsPath) != longRemoteFileSize || Files.exists(clsPath, LinkOption.NOFOLLOW_LINKS) == false ) {
				return true;
			}
		} catch(Exception Ex) {
			return true;
		}
		return false;
	}
	public String getFileNameOnly(String fileName) {
		int lastIndex = fileName.lastIndexOf(File.separator);
		return fileName.substring(lastIndex+1,fileName.length());
	}
	public String getFileExtension(String fileName) {
		String extension = "";
		int i = fileName.lastIndexOf('.');
		int p = Math.max(fileName.lastIndexOf('/'), fileName.lastIndexOf('\\'));

		if (i > p) {
		    extension = fileName.substring(i+1);
		}
		return extension;
	}
	public boolean writeFileContents(String strFileName,String strContents) throws Exception {
		Path path = Paths.get(strFileName);
        Files.createDirectories(path.getParent());
        FileChannel clsFileChannel = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        Charset charset = Charset.defaultCharset();
        ByteBuffer bufferByteBuffer = charset.encode(strContents);
        int byteCount = clsFileChannel.write(bufferByteBuffer);
        clsFileChannel.close();
        return byteCount > 0 ? true : false;
	}
	public String readFileContents(String strFileName) throws Exception {
		 Path clsPath = Paths.get(strFileName);
	     FileChannel fileChannel = FileChannel.open(clsPath,StandardOpenOption.READ);
	     ByteBuffer bufByteBuffer = ByteBuffer.allocate(1024*1024);
	     Charset charset = Charset.defaultCharset();
	     StringBuilder strBuilder = new StringBuilder();
	     int byteCount;
	     while(true) {
	         byteCount = fileChannel.read(bufByteBuffer);
	         if (byteCount == -1)
	             break;
	         bufByteBuffer.flip();
	         strBuilder.append(charset.decode(bufByteBuffer).toString());
	         bufByteBuffer.clear();
	    }
	    fileChannel.close();
		return strBuilder.toString();
	}
	public boolean deleteFile(String strFileName) throws Exception {
		Path path = Paths.get(strFileName);
		Files.delete(path);
		return true;
	}

}
