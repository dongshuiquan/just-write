package com.dsq.security.sha;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.MessageUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * Created by DELL on 2017/7/13.
 */
public class ImoocSHA {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private String src = "24002";

    @Test
    public void jdkSHA1() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(src.getBytes());
            byte[] result = md.digest();
            logger.info("jdk sha-1 : {}", Hex.encodeHexString(result));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void bcSHA1(){
        Digest digest = new SHA1Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] result = new byte[digest.getDigestSize()];
        digest.doFinal(result, 0);
        logger.info(" bc sha-1 : {}", org.bouncycastle.util.encoders.Hex.toHexString(result));
    }

    @Test
    public void bcSHA224(){
        Digest digest = new SHA224Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] result = new byte[digest.getDigestSize()];
        digest.doFinal(result, 0);
        logger.info("bc sha-224 : {}", org.bouncycastle.util.encoders.Hex.toHexString(result));
    }
    @Test
    public void bcSHA224_02() throws NoSuchAlgorithmException {
        //Security.addProvider(new BouncyCastleProvider());
        MessageDigest md = MessageDigest.getInstance("SHA-224");
        byte[] result = md.digest(src.getBytes());
        logger.info("bc sha-224_02 : {}", org.bouncycastle.util.encoders.Hex.toHexString(result));
    }

}
