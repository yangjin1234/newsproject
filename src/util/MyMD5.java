package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyMD5 {

	/**
	 * 加密解密算法，执行一次加密，两次解密
	 * @param inStr
	 * @return
	 */
	private static String convertMD5(String inStr){
		char[] a=inStr.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i]=(char)(a[i]^'t');
		}
		String s=new String(a);
		return s;
		
	}
	
	/**
	 * MD5加密，生成32位md5吗
	 * @param args
	 * @throws NoSuchAlgorithmException
	 */
	private static String string2MD5(String inStr){
		MessageDigest md5=null;
		try {
			md5=MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		char[] charArray=inStr.toCharArray();
		byte[] byteArray=new byte[charArray.length];
		for (int i = 0; i < byteArray.length; i++) {
			byteArray[i] =(byte)charArray[i];
		}
		byte[] md5Bytes=md5.digest(byteArray);
		StringBuffer hexValue=new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val=((int)md5Bytes[i] & 0xff);
			if(val<16){
				hexValue.append("0");
			}
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}
	
	/**
	 * 加密
	 * @param args
	 * @throws NoSuchAlgorithmException
	 */
	public static String encrypt(String lpass){
		return string2MD5(lpass);
	}
	
	/**
	 * 解密
	 * @param args
	 * @throws NoSuchAlgorithmException
	 */
	public static String decode(String lpass){
		return convertMD5(convertMD5(lpass));
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String s = "asdf";
		System.out.println("原始的字符串是："+s);
		System.out.println("加密后："+encrypt(s));
		System.out.println("解密后："+decode(s));
		
	}
}
