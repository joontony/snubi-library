/****************************************************************************************
 * File Name    : SHA256Util.java
 * Function     :
 * Author       : 최명호
 * Tester       :
 * Page         :
 * Target       :
 * Description  :
 * Modification Log
 * ======================================================================================
 * Ver  			Date        Author     	Modification
 * ======================================================================================
   auth.1.4.004  	2021.11.15  최명호		파일생성
****************************************************************************************/

package org.snubi.lib.crypto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.snubi.lib.misc.Misc;

public class SHA256Util {

	public static String encrypt(String target) throws NoSuchAlgorithmException {
        MessageDigest clsMessageDigest = MessageDigest.getInstance("SHA-256");
        clsMessageDigest.update(target.getBytes());
        return bytesToHex(clsMessageDigest.digest());
    }
    private static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
    public boolean isEqual(String source,String target) throws Exception {
    	String encrypedTarget = SHA256Util.encrypt(target);
    	return Misc.isEqualString(source, encrypedTarget);
    }
}
