/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;
/**
 *
 * @author vinyak
 */
public class NewAesEncryption {
    private static final String ALGORITHM = "AES";
    
    public static SecretKey generateKey() throws Exception{
        KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
        keyGen.init(128);
        return keyGen.generateKey();
    }
    
    public static String encrypt(String msg, SecretKey key) throws Exception{
        Cipher myCipher = Cipher.getInstance(ALGORITHM);
        myCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = myCipher.doFinal(msg.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    
    public static String decrypt(String EncryptedMsg, SecretKey key) throws Exception{
        Cipher myCipher = Cipher.getInstance(ALGORITHM);
        myCipher.init(Cipher.DECRYPT_MODE,key);
        byte[] decodedBytes = Base64.getDecoder().decode(EncryptedMsg);
        byte[] decryptedBytes = myCipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }
    
    public static void main(String args[]) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the message : ");
        String message = sc.nextLine();
        SecretKey key = generateKey();
        
        String encryptedText = encrypt(message,key);
        System.out.println("Encrypted Message : "+ encryptedText);
        
        String decryptedText = decrypt(encryptedText,key);
        System.out.println("Decrpted message  :" + decryptedText);
        
    }
}
