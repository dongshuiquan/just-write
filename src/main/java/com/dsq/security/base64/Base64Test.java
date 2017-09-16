package com.dsq.security.base64;

import org.bouncycastle.jcajce.provider.symmetric.ARC4;
import org.bouncycastle.util.encoders.Base64;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Created by DELL on 2017/9/2.
 */
public class Base64Test {

    @Test
    public void test01() throws UnsupportedEncodingException {
        String charset = "UTF-8"; //GBK
        String str = "base64 编码";
        byte[] input = str.getBytes(charset);
        System.out.println(input.length);
        byte[] data = Base64.encode(input);
        System.out.println("编码后:\t" + new String(data));
        byte[] output = Base64.decode(data);
        System.out.println("解码后:\t" + new String(output, charset));
    }
}
