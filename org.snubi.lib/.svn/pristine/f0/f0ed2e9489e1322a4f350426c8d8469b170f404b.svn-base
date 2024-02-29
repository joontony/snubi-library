///****************************************************************************************
// * File Name    : SmsSender
// * Function     :
// * Author       : 장태훈
// * Tester       :
// * Page         :
// * Target       :
// * Description  :
// * Modification Log
// * ======================================================================================
// * Ver  Date        	Author     	Modification
// * ======================================================================================
//   1.0
//   1.1 	2019.06.14		mh.choi	 	연동규격등을 수정함
//****************************************************************************************/
//package org.snubi.lib.http;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//public class PushSender {
//	public static boolean send(String device_id, String message, String title) {
//		boolean	result = false;
//		final String apiKey = "AIzaSyBp41F_y-VNZppHxUcoZLC2yqdI5XC7LAo";
//		try {
//			URL url = new URL("https://fcm.googleapis.com/fcm/send");
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//			conn.setDoOutput(true);
//			conn.setRequestMethod("POST");
//			conn.setRequestProperty("Content-Type", "application/json");
//			conn.setRequestProperty("Authorization", "key=" + apiKey);
//			conn.setDoOutput(true);
//			// 이걸로 보내면 특정 토큰을 가지고있는 어플에만 알림을 날려준다  위에 둘중에 한개 골라서 날려주자
//			String input = "{\"notification\" : {\"click_action\" : \"FCM_PLUGIN_ACTIVITY\",\"sound\" : \"default\",\"title\" : \""+title+"\", \"body\" : \""+title+" 알림입니다!\"},\"data\" : {\"message\" : \""+message+"\"},\"to\":\""+device_id+"\"}";
//			OutputStream os = conn.getOutputStream();
//			// 서버에서 날려서 한글 깨지는 사람은 아래처럼  UTF-8로 인코딩해서 날려주자
//			os.write(input.getBytes("UTF-8"));
//			os.flush();
//			os.close();
//			int responseCode = conn.getResponseCode();
//			System.out.println("Sending 'POST' request to URL : " + url);
//			System.out.println("Post parameters : " + input);
//			System.out.println("Response Code : " + responseCode);
//			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//			String inputLine;
//			StringBuffer response = new StringBuffer();
//			while ((inputLine = in.readLine()) != null) {
//			    response.append(inputLine);
//			}
//			in.close();
//			// print result
//			System.out.println("Response "  +response.toString());
//			result = true;
//		} catch(Exception e) {
//		 	result = false;
//		 	e.printStackTrace();
//		}
//		return result;
//	}
//}
