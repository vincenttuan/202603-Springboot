package javasecurity.encryption;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Arrays;
import java.util.Base64;

import javasecurity.util.KeyUtil;

// 非對稱式加密
public class RSASample {

	public static void main(String[] args) throws Exception {
		System.out.println("RSA-2048");
		System.out.println("==============================");
		String originalText = "明早7:30要招開人事緊急會議";
		System.out.printf("1. 原始明文: %s%n", originalText);
		System.out.println("------------------------------");
		
		// 1. 生成 RSA 密鑰對(公私鑰)
		KeyPair keyPair = KeyUtil.generateRSAKeyPair(); // RSA-2048
		PublicKey publicKey = keyPair.getPublic(); // 公鑰
		PrivateKey privateKey = keyPair.getPrivate(); // 私鑰
		
		// 2. 加密 - 利用公鑰進行加密
		byte[] encryptedBytes = KeyUtil.encryptWithPublicKey(publicKey, originalText.getBytes());
		System.out.printf("2. 加密後: %s%n", Arrays.toString(encryptedBytes));
		
		// 3. 編碼 - 透過 Base64 編碼以利傳輸
		String encoderECBBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
		System.out.printf("3. 編碼後: %s%n", encoderECBBase64);
		System.out.println("------------------------------");
		
	}

}
