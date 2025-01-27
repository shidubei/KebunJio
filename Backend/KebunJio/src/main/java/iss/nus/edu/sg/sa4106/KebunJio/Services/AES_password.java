package iss.nus.edu.sg.sa4106.KebunJio.Services;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES_password {
    public static void main(String[] args) throws Exception {
        // 明文数据
        String plainText = "Hello, AES Encryption!";

        // 生成密钥
        SecretKey secretKey = generateKey();

        // 转换密钥为字节数组（为了演示，通常密钥应该安全保存）
        byte[] keyBytes = secretKey.getEncoded();

        // 打印密钥
        System.out.println("Generated Key: " + Base64.getEncoder().encodeToString(keyBytes));

        // 加密
        String encryptedText = encrypt(plainText, keyBytes);
        System.out.println("Encrypted Text: " + encryptedText);

        // 解密
        String decryptedText = decrypt(encryptedText, keyBytes);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    // 生成AES密钥
    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128); // AES支持128/192/256位密钥
        return keyGen.generateKey();
    }

    // 加密方法
    public static String encrypt(String plainText, byte[] keyBytes) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keySpec);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes); // 转Base64便于展示
    }

    // 解密方法
    public static String decrypt(String encryptedText, byte[] keyBytes) throws Exception {
        SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }
}
