package com.dsq.security.des;

import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;

/**
 * Created by DELL on 2017/7/10.
 */
public class Imooc3des {
    private String src = "24002";

    @Test
    public void jdk3DES(){
        try {
            //生成 KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
            keyGenerator.init(168);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] byteKey = secretKey.getEncoded();

            //KEY 转换
            DESedeKeySpec desKeySpec = new DESedeKeySpec(byteKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DESede");
            Key converetSecretKey =  factory.generateSecret(desKeySpec);

            //加密
            Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, converetSecretKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk 3des encrypt : " + Hex.encodeHexString(result));

            //解密
            cipher.init(Cipher.DECRYPT_MODE, converetSecretKey);
            result = cipher.doFinal(result);
            System.out.println("jdk 3des decrypt : " + new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
