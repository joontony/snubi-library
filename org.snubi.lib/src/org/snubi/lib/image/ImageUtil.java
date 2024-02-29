/****************************************************************************************
 * File Name    : ImageUtil
 * Function     :
 * Author       : 최명호
 * Tester       :
 * Page         :
 * Target       :
 * Description  :
 * Modification Log
 * ======================================================================================
 * Ver  Date        Author  Modification
 * ======================================================================================
   1.0  2020.07.16	최명호	파일생성
   1.1  2020.07.16	최명호	mergeImageWithPNGBase64EncodingString 호출시 Draw 위치를 설정
****************************************************************************************/
package org.snubi.lib.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import javax.imageio.ImageIO;
import javax.xml.bind.DatatypeConverter;
import org.snubi.lib.date.DateUtil;
import org.snubi.lib.file.FileUtil;
import org.snubi.lib.misc.Misc;

public class ImageUtil {
	public static String mergeImageWithPNGBase64EncodingString(String encodingString,String bgImageName,String outputImagePath,String outputImageName) {
		return ImageUtil.mergeImageWithPNGBase64EncodingString(encodingString, bgImageName, outputImagePath, outputImageName,0,0);
	}
	public static String mergeImageWithPNGBase64EncodingString(String encodingString,String bgImageName,String outputImagePath,String outputImageName, int x, int y) {
//		DESC >> base64로 인코딩된 문자열이 아닌경우
		if(encodingString.toUpperCase().indexOf("DATA:IMAGE") == -1) {
			return "";
		}
		FileUtil clsFileUtil = new FileUtil();
		String stringThisDate = DateUtil.getThisDateString("yyyyMMddHHmmss");
		System.out.println("## mergeImageWithPNGBase64EncodingString ## start");
		try {
//			DESC >> 디렉터리를 설정하고, 결과파일 저장경로를 설정한다.
			File strDirBase = new File(outputImagePath);
			strDirBase = clsFileUtil.makeSubDirectory(strDirBase, stringThisDate.substring(0,4));
			strDirBase = clsFileUtil.makeSubDirectory(strDirBase, stringThisDate.substring(4,6));
			strDirBase = clsFileUtil.makeSubDirectory(strDirBase, stringThisDate.substring(6,8));
			outputImageName = Misc.setEndWith(strDirBase.getPath(),"/") + outputImageName;
			outputImageName = outputImageName.replace("\\","/");
			System.out.println("## mergeImageWithPNGBase64EncodingString ## output ## " + outputImageName);
//			DESC >> 이미지 파일을 합성한다.
			String base64ImageString = encodingString.split(",")[1];
			byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64ImageString);
			BufferedImage imageDecodingImage = ImageIO.read(new ByteArrayInputStream(imageBytes));
			BufferedImage imageBackgound = ImageIO.read(new File(bgImageName));
			imageBackgound.getGraphics().drawImage(imageDecodingImage, x, y, null);
//			DESC >> 결과파일을 생성한다.
			ImageIO.write(imageBackgound,"PNG",new File(outputImageName));
//			DESC >> 테스트를 위하여 사용자가 그린 그림을 따로 저장한다.
			ImageIO.write(imageDecodingImage,"PNG",new File(outputImageName + ".user.png"));
		} catch (Exception Ex) {
			Ex.printStackTrace();
			return "";
		}
		System.out.println("## mergeImageWithPNGBase64EncodingString ## return ## " + outputImageName);
		return outputImageName;
	}
}
