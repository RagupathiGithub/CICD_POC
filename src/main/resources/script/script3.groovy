import javax.crypto.Cipher
import javax.crypto.SecretKey
import javax.crypto.SecretKeyFactory
import javax.crypto.spec.IvParameterSpec
import javax.crypto.spec.PBEKeySpec
import javax.crypto.spec.SecretKeySpec
import java.security.Key
import java.security.spec.KeySpec
import org.apache.commons.codec.binary.Base64;
import com.sap.gateway.ip.core.customdev.util.Message;
import java.util.HashMap;

def Message processData(Message message) {
    
     def body = message.getBody();
     //String key = "jXn2r5u8x!A%D*G-"; // 128 bit key
    
    /* String key = "A?D(G-KaPdSgVkYp";
     Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
     Cipher cipher = Cipher.getInstance("AES");
     cipher.init(Cipher.DECRYPT_MODE, aesKey);
     byte[] encryptedbyte = body.decodeBase64()
     byte[] decryptedValue=cipher.doFinal(encryptedbyte);
     String decrypted = new String(decryptedValue,"UTF-8");
     message.setBody(decrypted);
     return message;
     */
     String Flag = "True"
     try {
     String key = "A?D(G-KaPdSgVkYp";
     Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
     Cipher cipher = Cipher.getInstance("AES");
     cipher.init(Cipher.DECRYPT_MODE, aesKey);
     byte[] encryptedbyte = body.decodeBase64()
     byte[] decryptedValue=cipher.doFinal(encryptedbyte);
     String decrypted = new String(decryptedValue,"UTF-8");
     message.setBody(decrypted);
     Flag = "True"
     message.setProperty("Flag", Flag)
    
     } catch(Exception e) {
      String exceptions = "${e}"
      message.setBody(exceptions);
      Flag = "False"
      message.setProperty("Flag", Flag)
     }
     
 
 return message;
}