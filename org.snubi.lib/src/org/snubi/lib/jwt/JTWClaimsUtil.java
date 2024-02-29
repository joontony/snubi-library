/****************************************************************************************
 * File Name    : JTWClaimsUtil.java
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
   1.0  2018.07.07  mh.choi    Create
****************************************************************************************/
package org.snubi.lib.jwt;

import java.util.Arrays;
import java.util.List;
import org.snubi.lib.misc.Misc;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class JTWClaimsUtil {

	@SuppressWarnings("unchecked")
	public JWTClaims getClaims(String strHTTPHeader,String strKey) throws Exception {
		JWTClaims clsJWTClaims = new JWTClaims();
		if(Misc.isEmtyString(strHTTPHeader) != true) {			
			
			Claims clsClaims = Jwts.parser().setSigningKey(strKey.getBytes()).parseClaimsJws(strHTTPHeader).getBody();			
			clsJWTClaims.setDepartment	((String) clsClaims.get("department"));
			clsJWTClaims.setId			((String) clsClaims.get("id"));
			clsJWTClaims.setName		((String) clsClaims.get("name"));
			clsJWTClaims.setOrganization((String) clsClaims.get("organization"));
			clsJWTClaims.setTitle		((String) clsClaims.get("title"));
			clsJWTClaims.setDeviceId	( (List<String>) clsClaims.get("device-id") );		
			clsJWTClaims.setToken		(strHTTPHeader);
//			FIXME >> 아래코드는 로드된 시스템코드를 사용하도록 수정해야함. organization 제외
			List<String> listSystemName = Arrays.asList("platform","agent","xnethub","xnet","avatar","bioemr","auth","knet","agreement");
			for(String systemName : listSystemName) {				
				if(clsClaims.get(systemName) != null) {
					clsJWTClaims.addAuth(systemName,(String) clsClaims.get(systemName));
				}
			}
		}
		return clsJWTClaims;
	}
}
