package com.estar.judgment.evaluation.web.frame.util;

/**
 * <p>
 * Title:验证IP的合法性
 * </p>
 * <p>
 * Description:判断已知的ip，是否在给定的范围
 * </p>
 * 
 * @author zhoushengyu
 * @version 1.0
 */

public class CheckIP {

	/**
	 * @author zhoushengyu
	 * @function: 判断已知的ip，是否在给定的范围。
	 * @param userIP
	 *            需要验证的ip,ip_start 范围开始ip,ip_end 范围结束ip
	 * @return 是,否
	 * @throws
	 */
	public static boolean ipBiJiao(String userIP, String ip_start, String ip_end) {
		boolean restemp = true;
		int[] str_ip_start = ip2Data(ip_start);
		int[] str_ip_end = ip2Data(ip_end);
		int[] str_userIP = ip2Data(userIP);

		for (int i = 0; i < 4; i++) {
			if (str_ip_start[i] < str_ip_end[i]) {
				restemp = true;
				break;
			}
			if (str_ip_start[i] > str_ip_end[i]) {
				restemp = false;
				break;
			}
		}
		if (restemp) {
			for (int i = 0; i < 4; i++) {
				if (str_userIP[i] > str_ip_start[i]) {
					restemp = true;
					break;
				}
				if (str_userIP[i] < str_ip_start[i]) {
					restemp = false;
					break;
				}
			}
			if (restemp) {
				for (int i = 0; i < 4; i++) {
					if (str_userIP[i] < str_ip_end[i]) {
						restemp = true;
						break;
					}
					if (str_userIP[i] > str_ip_end[i]) {
						restemp = false;
						break;
					}
				}
			}
		}
		return restemp;
	}

	/**
	 * @author zhoushengyu
	 * @function: 把String类型ip转换为int[]类型
	 * @param String类型ip
	 * @return int[]
	 * @throws
	 */
	private static int[] ip2Data(String ip) {
		int[] ipdata = new int[4];
		for (int i = 0; i < 4; i++) {
			int j = ip.trim().indexOf(".");
			if (j != -1) {
				ipdata[i] = Integer.parseInt(ip.trim().substring(0, j).trim());
				ip = ip.trim().substring(j + 1);
			} else {
				ipdata[i] = Integer.parseInt(ip.trim());
			}
		}
		return ipdata;
	}

}
