package javasecurity.jwt;

import com.nimbusds.jwt.JWTClaimsSet;

import javasecurity.util.KeyUtil;

/**
 * 帳號密碼正確
 *    ↓
 * 伺服器發一張 JWT 通行證
 *    ↓
 * JWT 裡面寫著
 * 使用者: admin
 * 角色: ADMIN
 * 權限: USER_DELETE
 *    ↓
 * 呼叫刪除會員 API 時
 * 伺服器檢查 JWT 是否有效
 *    ↓
 * 再檢查有沒有 USER_DELETE 權限
 * 
 * */
public class LoginAndDeleteUser {
	public static void main(String[] args) throws Exception {
		// 1. 產生 JWT 簽名密鑰
		String signingSecret = KeyUtil.generateSecret(32);
		
		// 2. 模擬登入(成功之後會得到 token)
		String token = login("admin", "1234", signingSecret);
		if(token == null) {
			System.out.println("登入失敗");
			return;
		}
		
		System.out.printf("登入成功, 取得 JWT: %s%n", token);
		
		System.out.println("\n=======================\n");
		
		// 3. 模擬呼叫刪除會員 API
		deleteUserApi(token, signingSecret);
		
	}
	
	// 刪除會員 API
	public static void deleteUserApi(String token, String signingSecret) throws Exception {
		System.out.println("呼叫 API: 刪除會員");
		System.out.println("需要權限: USER_DELETE");
		
		// 驗證 JWT 並取得 payload
		boolean check = KeyUtil.verifyJWTSignature(token, signingSecret);
		if(!check) {
			System.err.println("JWT 驗證失敗");
			return;
		}
		System.out.println("JWT 驗證成功");
		
		JWTClaimsSet claims = KeyUtil.getClaimsFromToken(token);
		String subject = claims.getSubject();
		String role = claims.getStringClaim("role");
		String permission = claims.getStringClaim("permission");
		
		System.out.printf("使用者: %s%n", subject);
		System.out.printf("角色: %s%n", role);
		System.out.printf("權限: %s%n", permission);
		
		// 檢查權限是否足夠
		if("USER_DELETE".equals(permission)) {
			System.out.println("授權成功: 可以刪除會員");
		} else {
			System.err.println("授權失敗: 權限不足, 不可刪除會員");
		}
	}
	
	public static String login(String username, String password, String signingSecret) throws Exception {
		// 帳密判斷
		if(!"admin".equals(username) || !"1234".equals(password)) {
			return null;
		}
		
		// 建立 JWT payload
		JWTClaimsSet claimsSet = new JWTClaimsSet.Builder()
				.subject(username)
				.issuer("https://my-system.com")
				.claim("role", "ADMIN")
				.claim("permission", "USER_DELETE")
				.build();
		
		return KeyUtil.signJWT(claimsSet, signingSecret);
	}
}
