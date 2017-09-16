package com.dsq.security.aes;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * Created by DELL on 2017/7/10.
 */
public class ImoocAES {
    private String src = "imooc security aes";
    @Test
    public void jdkAES(){
        try {
            //生成KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey =  keyGenerator.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            //KEY转换
            Key key = new SecretKeySpec(keyBytes, "AES");
            System.out.println(Hex.encodeHexString(key.getEncoded()));
            //加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println(Hex.encodeHexString(result));

            //解密
            cipher.init(Cipher.DECRYPT_MODE, key);
            result = cipher.doFinal(result);
            System.out.println(new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
