package com.estar.judgment.evaluation.web.frame.util;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.SecureRandom;

@SuppressWarnings("serial")
public class UUIDPK implements Serializable {
	public String POID;

	public UUIDPK() {
	}

	public UUIDPK(String id) {
		POID = id;
	}

	public String toString() {
		return POID;
	}

	public boolean equals(Object other) {
		boolean result = false;
		if (other == this) {
			return true;
		}
		if (!(other instanceof UUIDPK)) {
			return false;
		}

		result = POID == null ? ((UUIDPK) other).POID == null : POID
				.equals(((UUIDPK) other).POID);

		return result;
	}

	public int hashCode() {
		return POID == null ? 0 : POID.hashCode();
	}

	public static String getUUID(Object obj) {
		String uuid = "";
		uuid = firstPart() + secondPart() + thirdPart(obj) + fourthPart();
		return uuid;
	}

	private static String firstPart() {
		long tmp = 0L;
		String tmpHex = null;
		tmp = System.currentTimeMillis();
		tmpHex = Long.toHexString(tmp);
		return tmpHex.substring(tmpHex.length() - 8);
	}


	private static String secondPart() {
		String sndPart = "";
		int tmpIp = 0;
		int tmp = 0;
		InetAddress localIPAddr = null;
		try {
			localIPAddr = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		byte[] ipParts = localIPAddr.getAddress();
		// 0
		tmp = ipParts[0];
		tmpIp = tmp << 24;
		// 1
		tmp = ipParts[1];
		tmp = tmp << 16;
		tmpIp = tmpIp ^ tmp;
		// 2
		tmp = ipParts[2];
		tmp = tmp << 8;
		tmpIp = tmpIp ^ tmp;
		// 3
		tmp = ipParts[3];
		tmpIp = tmpIp ^ tmp;
		sndPart = Integer.toHexString(tmpIp);
		return getEightHex(sndPart);
	}

	private static String thirdPart(Object obj) {
		String tmpHex = "";
		tmpHex = Integer.toHexString(obj.hashCode());
		return getEightHex(tmpHex);
	}


	private static String fourthPart() {
		String tmpHex = "";
		SecureRandom sr = new SecureRandom();
		tmpHex = Integer.toHexString(sr.nextInt());
		return getEightHex(tmpHex);
	}


	private static String getEightHex(String part) {
		if (part.length() >= 8) {
			return part;
		}
		switch (part.length()) {
		case (0): {
			part = "00000000";
			break;
		}
		case (1): {
			part = "0000000" + part;
			break;
		}
		case (2): {
			part = "000000" + part;
			break;
		}
		case (3): {
			part = "00000" + part;
			break;
		}
		case (4): {
			part = "0000" + part;
			break;
		}
		case (5): {
			part = "000" + part;
			break;
		}
		case (6): {
			part = "00" + part;
			break;
		}
		case (7): {
			part = "0" + part;
			break;
		}
		}
		return part;
	}
}
