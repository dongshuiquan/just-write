package com.dsq.security.util;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by DELL on 2017/9/2.
 */
public class DigestUtilsTest {

    @Test
    public void md5Test() {
        String str = "24002";
        String md5Hex = DigestUtils.md5Hex(str);
        System.out.println("加密后 : " + md5Hex);
    }

    @Test
    public void md5Test02() throws NoSuchAlgorithmException {
        String str = "MD5消息摘要";
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes());
        byte[] result = md.digest();
        System.out.println(Hex.encodeHexString(result));
    }
}
