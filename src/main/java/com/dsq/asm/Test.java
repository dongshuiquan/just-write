package com.dsq.asm;

/**
 * Created by DELL on 2017/10/27.
 */

import static java.lang.invoke.MethodHandles.lookup;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;


class MZD {
    void thinking() {
        System.out.println("MZD");
    }
}

class MAQ extends MZD {
    void thinking() {
        System.out.println("MAQ");
    }
}

class MXY extends MAQ {
    void thinking() {
        try {
             MethodType mt = MethodType.methodType(void.class);
              MethodHandle mh = lookup().findSpecial(MZD.class,"thinking", mt, MXY.class);
            mh.invoke(this);
            /*MethodHandle mh = lookup().findVirtual(getClass().getSuperclass().getSuperclass(),"thinking", mt).bindTo(new MZD());
            mh.invokeExact();*/
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}

class Test {

    public static void main(String[] args) {
        new MXY().thinking();
    }

}