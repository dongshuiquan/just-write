package com.dsq.security.util;

import org.apache.commons.codec.DecoderException;
import org.bouncycastle.util.encoders.Hex;
import org.junit.Test;

/**
 * Created by DELL on 2017/9/2.
 */
public class HexTest {

    @Test
    public void bcHex() {
        String str = "24002";
        byte[] input = str.getBytes();
        byte[] data = Hex.encode(input);
        System.out.println("编码后 ：" + new String(data));
        byte[] output = Hex.decode(data);
        System.out.println("解码后 : " + new String(output));
    }
    @Test
    public void ccHex() throws DecoderException {
        String str = "Hex 编码";
        byte[] input = str.getBytes();
        String data = org.apache.commons.codec.binary.Hex.encodeHexString(input);
        System.out.println("编码后 ：" + data);
        byte[] output = org.apache.commons.codec.binary.Hex.decodeHex(data.toCharArray());
        System.out.println("解码后 : " + new String(output));
    }
}
