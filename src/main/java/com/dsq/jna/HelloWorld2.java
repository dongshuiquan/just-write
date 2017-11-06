package com.dsq.jna; /**
 * Created by DELL on 2017/11/3.
 */

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;

/** Simple example of JNA interface mapping and usage. */
public class HelloWorld2 {

    // This is the standard, stable way of mapping, which supports extensive
    // customization and mapping of Java to native types.

    public interface CLibrary extends Library {
        CLibrary INSTANCE = (CLibrary) Native.loadLibrary("Test", CLibrary.class);
        int ADD(int a, int b);
        String addString(String  a,String b);
    }

    public static void main(String[] args) {
        System.out.println(Platform.isWindows());
        CLibrary library = CLibrary.INSTANCE;
        System.out.println(library);
        System.out.println(library.ADD(1, 2));
        System.out.println(library.addString(null, null));

    }
}
