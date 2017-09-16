package com.dsq.security.provider;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Hex;
import org.junit.BeforeClass;
import org.junit.Test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.util.Map;

/**
 * Created by DELL on 2017/9/2.
 */
public class ProviderList {

    @BeforeClass
    public static void beforeClass() {
        Security.addProvider(new BouncyCastleProvider());
    }

    @Test
    public void  bcProvider() {
        Provider provider = Security.getProvider("BC");
        System.out.println(provider);
        System.out.println(provider.entrySet().size());
        for(Map.Entry<?,?> entry : provider.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    @Test
    public void encodeSHA224() throws NoSuchAlgorithmException {
        byte[] bytes = "ABC".getBytes();
        MessageDigest md = MessageDigest.getInstance("SHA-224");
        md.update(bytes);
        byte[] result = md.digest();
        System.out.println(Hex.toHexString(result));
    }
}
