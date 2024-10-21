/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import java.util.Base64;
/**
 *
 * @author vinyak
 */
public class DesEncryption {
    
    public static SecretKey generateKey() throws Exception{
        KeyGenerator keyGen  = KeyGenerator.getInstance("DES");
        keyGen.init(56);
        return keyGen.generateKey();
    }
    
    public static String encrypt(String text, SecretKey key) throws Exception{
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedText = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedText);
    }
    
    public static String decrypt(String text, SecretKey key) throws Exception{
        Cipher cipher  = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedText = Base64.getDecoder().decode(text);
        byte[] decryptedText = cipher.doFinal(decodedText);
        return new String(decryptedText);
    }
    
    public static void main(String args[])throws Exception{
        String msg = "This is the attack today.";
        SecretKey key = generateKey();
        
        String encryptedText = encrypt(msg,key);
        String decryptedText = decrypt(encryptedText,key);
        
        System.out.println("Encryptedtext : "+ encryptedText);
        System.out.println("Decryptedtext : "+ decryptedText);
    }
}
