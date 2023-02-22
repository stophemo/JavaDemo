import java.math.BigInteger;
import java.net.URLEncoder;

import static java.lang.Integer.parseInt;
import static java.lang.Integer.toHexString;

/**
 * @Description: 加密解密工具
 * @Author: Huo Jie
 * @CreateDate： 2023/2/9 14:47
 */
public class Cryption {
    // 加密
    public static String encryption(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        str = URLEncoder.encode(str);
        String pwd = "ae8b516cbffde62a74b726c82eb6748ad41d251480d84ce2e96ebf57ebaa8b22";
        pwd = URLEncoder.encode(pwd);
        if (pwd == null || pwd.length() <= 0) {
            System.out.println("Please enter a password with which to encrypt the message.");
            return null;
        }
        StringBuilder prandBuilder = new StringBuilder();
        for (int i = 0; i < pwd.length(); i++) {
            prandBuilder.append(Integer.valueOf(pwd.charAt(i)));
        }
        final int sPos = prandBuilder.length() / 5;
        StringBuilder multBuilder = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            multBuilder.append(prandBuilder.charAt(sPos * i));
        }
        int mult = parseInt(String.valueOf(multBuilder));
        int incr = (int)Math.ceil((double)pwd.length() / 2);
        long modu = (long) (Math.pow(2, 31) - 1);
        if (mult < 2) {
            System.out.println("Algorithm cannot find a suitable hash. Please choose a different password. /nPossible considerations are to choose a more complex or longer password.");
            return null;
        }
        long salt = Math.round(Math.random() * 1000000000) % 100000000;
        prandBuilder.append(salt);

        while (prandBuilder.length() > 10) {
            BigInteger test = new BigInteger(prandBuilder.substring(0, 10)).add(new BigInteger(prandBuilder.substring(10, prandBuilder.length())));
        }
        long prand = parseInt(String.valueOf(prandBuilder));
        prand = (mult * prand + incr) % modu;
        int encChr;
        StringBuilder encStr = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            encChr = (int) str.charAt(i) ^ (int) Math.floor(((double) prand / modu) * 255);
            if (encChr < 16) {
                encStr.append('0').append(Integer.toString(encChr, 16));
            } else {
                encStr.append(Integer.toString(encChr, 16));
            }
            prand = (mult * prand + incr) % modu;
        }
        StringBuilder saltBuilder = new StringBuilder(Long.toHexString(salt));
        while (saltBuilder.length() < 8) {
            saltBuilder.insert(0, '0');
        }
        encStr.append(saltBuilder);
        return String.valueOf(encStr);
    }

    // 解密
    public static String decryption(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        String pwd = "ae8b516cbffde62a74b726c82eb6748ad41d251480d84ce2e96ebf57ebaa8b22";
        pwd = URLEncoder.encode(pwd);
        if (str == null || str.length() < 8) {
            System.out.println("A salt value could not be extracted from the encrypted message because it's length is too short. The message cannot be decrypted.");
            return null;
        }
        if (pwd == null || pwd.length() <= 0) {
            System.out.println("Please enter a password with which to decrypt the message.");
            return null;
        }
        StringBuilder prandBuilder = new StringBuilder();
        for (int i = 0; i < pwd.length(); i++) {
            prandBuilder.append(Integer.valueOf(pwd.charAt(i)));
        }
        final int sPos = prandBuilder.length() / 5;
        StringBuilder multBuilder = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            multBuilder.append(prandBuilder.charAt(sPos * i));
        }
        int mult = parseInt(String.valueOf(multBuilder));
        int incr = pwd.length() / 2 + 1;
        long modu = (long) (Math.pow(2, 31) - 1);
        int salt = parseInt(str.substring(str.length() - 8), 16);
        str = str.substring(0, str.length() - 8);
        prandBuilder.append(salt);
        while (prandBuilder.length() > 10) {
             prandBuilder = new StringBuilder(parseInt(prandBuilder.substring(0, 10)) +
                    parseInt(prandBuilder.substring(10,prandBuilder.length())));
        }
        long prand = ((long) mult * parseInt(String.valueOf(prandBuilder)) + incr) % modu;
        int encChr;
        StringBuilder encStr = new StringBuilder();
        for (int i = 0; i < str.length(); i += 2) {
            encChr = parseInt(String.valueOf(parseInt(str.substring(i, i + 2), 16)  ^ (int)Math.floor(((double) prand / modu) * 255)));
            encStr.append((char)encChr);
            prand = (mult * prand + incr) % modu;
        }
        return URLEncoder.encode(String.valueOf(encStr));
    }
}
