package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyMD5 {

	/**
	 * ���ܽ����㷨��ִ��һ�μ��ܣ����ν���
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
	 * MD5���ܣ�����32λmd5��
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
	 * ����
	 * @param args
	 * @throws NoSuchAlgorithmException
	 */
	public static String encrypt(String lpass){
		return string2MD5(lpass);
	}
	
	/**
	 * ����
	 * @param args
	 * @throws NoSuchAlgorithmException
	 */
	public static String decode(String lpass){
		return convertMD5(convertMD5(lpass));
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		String s = "asdf";
		System.out.println("ԭʼ���ַ����ǣ�"+s);
		System.out.println("���ܺ�"+encrypt(s));
		System.out.println("���ܺ�"+decode(s));
		
	}
}
