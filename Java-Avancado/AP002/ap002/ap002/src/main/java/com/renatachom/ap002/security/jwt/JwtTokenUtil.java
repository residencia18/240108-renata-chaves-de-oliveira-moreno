
package com.renatachom.ap002.security.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;

public class JwtTokenUtil {

    public boolean verifyToken(String token, String publicKey) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build()
                    .parseClaimsJws(token);
            
            // O token foi verificado com sucesso
            return true;
        } catch (Exception e) {
            // O token não pôde ser verificado ou é inválido
            return false;
        }
    }

    public static void main(String[] args) {
        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c";
        
        String publicKey = "-----BEGIN PUBLIC KEY-----\n" +
                           "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAzifYmPq12OI2mEGI1GfM\n" +
                           "FhPw7aZ5Vn3B8qAVc8e28BOOb329gAZ1VBNfOjGe+9OTsGutlm1WYBQj7O0ZTuEl\n" +
                           "wvH+dEO6Q8dyNek1yBiVTT/Ok/aDzVGOHdS0v0tMVfQA8jxmHNVz807YVmE36vCN\n" +
                           "qv0nmx5jQAMGNI77N/q54LNHBwhWBOsvOP/yQBRappONColLK5GBoxHtIKA2AT6t\n" +
                           "c8B1pPW9GSfLq4xHmiY25bgaMaBMwPLKFMw+syzwW6sn97xzkH4/zh6y+C/onX3z\n" +
                           "Qw3TNNhnKg1LUGCGj2aIIOj3xbr2VYINx1U+TIW2S+gPV0gLAxcRiNHqkCP/PsSD\n" +
                           "wQIDAQAB\n" +
                           "-----END PUBLIC KEY-----";
        
        JwtTokenUtil jwtVerifier = new JwtTokenUtil();
        boolean isTokenValid = jwtVerifier.verifyToken(token, publicKey);
        
        if (isTokenValid) {
            System.out.println("O token é válido.");
        } else {
            System.out.println("O token é inválido.");
        }
    }
}
