package Contoller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
	static MessageDigest md; // 암호화를 하기 위한 변수
	static StringBuffer sb; // 암호화 된 것을 스트링으로 변화하는 변수 StringBuffer
	public static String getEncryption(String userPw) {
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
        md.update(userPw.getBytes());//암호문이 만들어 진다.
        byte byteData[] = md.digest();
        sb = new StringBuffer(); 
        for(int i = 0 ; i < byteData.length ; i++){
           sb.append(
        		   Integer.toString(
        				   (byteData[i]&0xff) + 0x100, 16).substring(1));
        }
		return sb.toString();
	}
}
