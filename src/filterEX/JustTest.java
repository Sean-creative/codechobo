package filterEX;

import java.io.UnsupportedEncodingException;

public class JustTest {

	public static void main(String[] args) {
		String str = "123ascv가adasd";
		try {
			System.out.println(str.getBytes("UTF-8").length);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			System.out.println("UTF-8 에러발생!!");
		}
		
		if ( isOnlyNumAndAlpha(str))
			System.out.println("영문&숫자입니다!");
		else 
			System.out.println("영문&숫자가 아닙니다!");					
	}

	// 특수문자를 제외한 오직 숫자와 영문자만을 입력받을 때
	public static boolean isOnlyNumAndAlpha(String textInput) {

		char chrInput;
		for (int i = 0; i < textInput.length(); i++) {

			chrInput = textInput.charAt(i); // 입력받은 텍스트에서 문자 하나하나 가져와서 체크

			// 영문(소문자) OK!
			if (chrInput >= 0x61 && chrInput <= 0x7A) {}
			// 영문(대문자) OK!
			else if (chrInput >= 0x41 && chrInput <= 0x5A) {} 
			// 숫자 OK!
			else if (chrInput >= 0x30 && chrInput <= 0x39) {}
			else {
				// 영문자도 아니고 숫자도 아님!
				return false; 
			}
		}
		return true;
	}
	
}
