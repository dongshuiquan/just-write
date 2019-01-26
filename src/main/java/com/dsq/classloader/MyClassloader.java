package com.dsq.classloader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by DELL on 2018/8/25.
 */
public class MyClassloader extends ClassLoader {

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        try {
            byte[] bytes1 = Files.readAllBytes(Paths.get("c:/xmp"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO
        byte[] bytes = new byte[1];
        return defineClass(name, bytes, 0, bytes.length);
    }
}
