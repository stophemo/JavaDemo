/**
 * @Description:
 * @Author: Huo Jie
 * @CreateDate： 2023/2/9 16:51
 */
public class test {
    public static void main(String[] args) {

        String decryptStr = "afsdgasdfbb飞鸟时代尽快给您尽快";
        String encryptStr = Cryption.encryption(decryptStr);
        System.out.println(Cryption.encryption(encryptStr));
//        System.out.println(Cryption.decryption(encryptStr));
    }
}
