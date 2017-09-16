package com.dsq.security.base64;

import org.apache.commons.codec.binary.Base64;
import org.junit.BeforeClass;
import org.junit.Test;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;

/**
 * Created by DELL on 2017/7/9.
 */
public class ImoocBase64 {

    private static String src = "s13s";  //imooc security base64

    @BeforeClass
    public static void print(){
        byte[] bytes = src.getBytes();
        for(byte b : bytes){
            System.out.println(b);
        }
    }

    @Test
    public void jdkBase64(){
        BASE64Encoder encoder = new BASE64Encoder();
        String encode = encoder.encode(src.getBytes());
        System.out.println("encode : " + encode);

        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] resultByte = decoder.decodeBuffer(encode);
            System.out.println("decode : " + new String(resultByte));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void commonsCodesBase64(){
        byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
        System.out.println(new String(encodeBytes));

        byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
        System.out.println(new String(decodeBytes));
    }

    @Test
    public void bouncyCastleBase64(){
        byte[] encode = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println(new String(encode));

        byte[] decode =  org.bouncycastle.util.encoders.Base64.decode(encode);
        System.out.println(new String(decode));
    }

}

