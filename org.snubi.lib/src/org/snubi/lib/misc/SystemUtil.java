/**************************************************************************************** 
 * File Name    : SystenUtil
 * Function     : 
 * Author       : mh.choi
 * Tester       : 
 * Page         : 
 * Target       : 
 * Description  : 
 * Modification Log
 * =============================================================== 
 * Ver  Date        Author		Modification
 * ===============================================================
   1.0  2019.05.06	최명호		시스템 모니터링
****************************************************************************************/
package org.snubi.lib.misc;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.sun.management.OperatingSystemMXBean;

@SuppressWarnings("restriction")
public class SystemUtil {

	public Map<String,BigDecimal> getDiskUsageByGB() {
		File root = null;
		Map<String,BigDecimal> mapReturn = new HashMap<String,BigDecimal>();
		try {
			root = new File("/");
			BigDecimal total = new BigDecimal(root.getTotalSpace()/(1024*1024) / 1000.0).setScale(2, BigDecimal.ROUND_DOWN);
			BigDecimal free  = new BigDecimal(root.getUsableSpace()/(1024*1024) / 1000.0).setScale(2, BigDecimal.ROUND_DOWN);
			mapReturn.put("Total",total);
			mapReturn.put("Used" ,total.subtract(free));
			mapReturn.put("Free" ,free);
		} catch (Exception Ex) {
			Ex.printStackTrace();
		}
		return mapReturn; 
	}
	public Map<String,BigDecimal> getMemoryUsageByGB() {
		Map<String,BigDecimal> mapReturn = new HashMap<String,BigDecimal>();
		try {
			OperatingSystemMXBean clsOperatingSystemMXBean = (com.sun.management.OperatingSystemMXBean)ManagementFactory.getOperatingSystemMXBean();
			BigDecimal total = new BigDecimal(clsOperatingSystemMXBean.getTotalPhysicalMemorySize()/(1024*1024) / 1000.0).setScale(2, BigDecimal.ROUND_DOWN);
			BigDecimal free = new BigDecimal(clsOperatingSystemMXBean.getFreePhysicalMemorySize()/(1024*1024) / 1000.0).setScale(2, BigDecimal.ROUND_DOWN);
			mapReturn.put("Total",total);
			mapReturn.put("Free" ,free);
			mapReturn.put("Used" ,total.subtract(free));
		} catch (Exception Ex) {
			Ex.printStackTrace();
		}
		return mapReturn;
	}
	public Map<String,BigDecimal> getCPUByPercent() {
		Map<String,BigDecimal> mapReturn = new HashMap<String,BigDecimal>();
		try {
			double load = 0;
			OperatingSystemMXBean clsOperatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
			while (true) {
				load = clsOperatingSystemMXBean.getSystemCpuLoad();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException Ex) {
					Ex.printStackTrace();
				}
				if (load * 100.0 > 0.0 && load * 100.0 < 100) {
					break;
				}
			}
			mapReturn.put("Total",new BigDecimal("0"));
			mapReturn.put("Free" ,new BigDecimal("0"));
			mapReturn.put("Used" ,new BigDecimal(load*100).setScale(2, BigDecimal.ROUND_DOWN));
		} catch (Exception Ex) {
			Ex.printStackTrace();
		}
		return mapReturn;
	}
}
