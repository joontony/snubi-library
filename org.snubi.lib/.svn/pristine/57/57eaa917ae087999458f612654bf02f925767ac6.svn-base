/****************************************************************************************
 * File Name    : PUSHUtil.java
 * Function     :
 * Author       : 최명호
 * Tester       :
 * Page         :
 * Target       : HTTP-form 전송을 통해 PUSH 메시지를 전송한다.
 * Description  :
 * Modification Log
 * ======================================================================================
 * Ver  Date        Author     Modification
 * ======================================================================================
   1.0  2021.09.07  최명호    Create
****************************************************************************************/
package org.snubi.lib.message;

import org.snubi.lib.http.HttpUtilPost;
import org.snubi.lib.misc.Misc;
import org.snubi.lib.response.SnubiResponse;

public class PUSHUtil {
	public static boolean send(String url,String os,String destin,String title,String body) {
//		DESC : 메시지발송 권한 여부는 파라미터로 전달받은 URL 에서 함,
		try {
			@SuppressWarnings("rawtypes")
			HttpUtilPost clsHttpUtilPost = new HttpUtilPost();
			clsHttpUtilPost.setStrUrl(url);
			clsHttpUtilPost.setStrCharset("UTF-8");
			clsHttpUtilPost.setStrType("application/x-www-form-urlencoded");
			SnubiResponse clsSnubiResponse = clsHttpUtilPost.post("&to=" + destin + "&os=" + os+ "&title=" + title+ "&body=" + body);
			return Misc.isEqualString("success",clsSnubiResponse.getStrCode());
		} catch (Exception Ex) {
			Ex.printStackTrace();
			return false;
		}
	}
}