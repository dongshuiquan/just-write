package com.dsq.jna;

/**
 * Created by DELL on 2017/11/3.
 */

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/** Simple example of JNA interface mapping and usage. */
public class HelloWorld {

    // This is the standard, stable way of mapping, which supports extensive
    // customization and mapping of Java to native types.

    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary)
                Native.loadLibrary((Platform.isWindows() ? "msvcrt" : "c"),
                        CLibrary.class);

        void printf(String format, Object... args);
        char getchar();
    }

    public static void main(String[] args) {
        CLibrary.INSTANCE.printf("Hello, World\n");
        System.out.println(Platform.isWindows());
        for (int i=0;i < args.length;i++) {
            CLibrary.INSTANCE.printf("Argument %d: %s\n", i, args[i]);
        }
        System.out.println(CLibrary.INSTANCE.getchar());
    }
}
