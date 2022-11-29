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
    String key = "jXn2r5u8x!A%D*G-"; // 128 bit key
    String encoded="";
    Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
    Cipher cipher = Cipher.getInstance("AES");
    cipher.init(Cipher.ENCRYPT_MODE, aesKey);
    byte[] encrypted = cipher.doFinal(body.getBytes());
    message.setBody(encrypted.encodeBase64().toString());
    return message;
    
}