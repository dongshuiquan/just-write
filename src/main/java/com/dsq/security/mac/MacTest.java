package com.dsq.security.mac;

import org.junit.Test;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

/**
 * Created by DELL on 2017/9/3.
 */
public class MacTest {

    @Test
    public void jdkMac() throws Exception {
        byte[] data = "ABC".getBytes();
        KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] key = secretKey.getEncoded();

        SecretKey secretKey1 = new SecretKeySpec(key, "HmacMD5");
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);
        data = mac.doFinal(data);
    }
}
