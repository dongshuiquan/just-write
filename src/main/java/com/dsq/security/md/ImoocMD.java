package com.dsq.security.md;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * Created by DELL on 2017/7/13.
 */
public class ImoocMD {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String src = "i";
    @Test
    public void jdkMD5(){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(src.getBytes());
            logger.info("jdk MD5 : {}",Hex.encodeHexString(md5Bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void jdkMD2(){
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] md2Bytes = md.digest(src.getBytes());
            logger.info("jdk MD2 : {}",Hex.encodeHexString(md2Bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bcMD4(){
        try {
            Digest digest = new MD4Digest();
            digest.update(src.getBytes(), 0 , src.getBytes().length);
            byte[] md4Bytes = new byte[digest.getDigestSize()];
            digest.doFinal(md4Bytes, 0);
            logger.info("BC MD4 : {}", org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bcMD5(){
        try {
            Digest digest = new MD5Digest();
            digest.update(src.getBytes(), 0 , src.getBytes().length);
            byte[] md5Bytes = new byte[digest.getDigestSize()];
            digest.doFinal(md5Bytes, 0);
            logger.info("BC MD5 : {}", org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bcMD4_02(){
        try {
            Security.addProvider(new BouncyCastleProvider());
            MessageDigest md = MessageDigest.getInstance("MD4");
            byte[] md4Bytes = md.digest(src.getBytes());
            logger.info("BC MD4 : {}", org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void ccMD5(){
        String md5 =  DigestUtils.md5Hex(src);
        logger.info("CC MD5 : {}", md5);
    }


    @Test
    public void ccMD2(){
        String md2 =  DigestUtils.md2Hex(src);
        logger.info("CC MD2 : {}", md2);
    }

     @Test
    public void sha() throws NoSuchAlgorithmException {
         MessageDigest md = MessageDigest.getInstance("SHA");
         byte[] bytes = md.digest(src.getBytes());
         logger.info("jdk MD2 : {}",Hex.encodeHexString(bytes));
    }


}
