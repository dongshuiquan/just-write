package com.dsq.security.des;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * Created by DELL on 2017/7/10.
 */
public class ImoocDES {
    private String src = "24002";

    @Test
    public void jdkDES(){
        try {
            //生成 KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] byteKey = secretKey.getEncoded();

            //KEY 转换
            DESKeySpec desKeySpec = new DESKeySpec(byteKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            Key converetSecretKey =  factory.generateSecret(desKeySpec);

            //加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, converetSecretKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk des encrypt : " + Hex.encodeHexString(result));

            //解密
            cipher.init(Cipher.DECRYPT_MODE, converetSecretKey);
            result = cipher.doFinal(result);
            System.out.println("jdk des decrypt : " + new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bcDES(){
        try {
            Security.addProvider(new BouncyCastleProvider());

            //生成 KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES", "BC");
            keyGenerator.getProvider();
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] byteKey = secretKey.getEncoded();

            //KEY 转换
            DESKeySpec desKeySpec = new DESKeySpec(byteKey);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            Key converetSecretKey =  factory.generateSecret(desKeySpec);

            //加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, converetSecretKey);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk des encrypt : " + Hex.encodeHexString(result));

            //解密
            cipher.init(Cipher.DECRYPT_MODE, converetSecretKey);
            result = cipher.doFinal(result);
            System.out.println("jdk des decrypt : " + new String(result));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
