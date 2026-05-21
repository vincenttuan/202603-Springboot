package javasecurity.jwt;

import com.nimbusds.jwt.JWTClaimsSet;

import javasecurity.util.KeyUtil;

/**
 * 建立一個 JWT 令牌
 * 驗證 JWT 令牌
 * */
public class SimpleJWT {
	public static void main(String[] args) throws Exception {
		// 1. 生成簽名密鑰
		// JWK: 產生簽名用的密鑰(32bytes)
		String signingSecret = KeyUtil.generateSecret(32);
		System.out.printf("密鑰: %s%n", signingSecret);
		
		// 2. 創建 JWT 的聲明(claim)
		// JWT: 這是我們要進行簽名的部分(資料主體)
		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				.subject("Welcome") // 主題
				.issuer("https://welcome.com") // 發行單位
				.claim("id", "001") // 自訂聲明內容
				.claim("name", "John") // 自訂聲明內容
				.claim("dept", "IT") // 自訂聲明內容
				.claim("floor", "7") // 自訂聲明內容
				.claim("tel", "#212") // 自訂聲明內容
				.build();
		System.out.printf("Payload: %s%n", claimsSet);
		
		// 3. 進行簽名(將 claimSet 進行簽名) 的到 token(JWT)
		String token = KeyUtil.signJWT(claimsSet, signingSecret);
		System.out.printf("Token(JWT): %s%n", token);
				
		
		
	}
}
