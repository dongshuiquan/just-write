package com.dsq.reflect;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

/**
 * Created by DELL on 2018/5/9.
 */
public class InvokeSpecial {

    class GGrandFather{
        protected void thinking(){
            System.out.println("i am gg grandfather");
        }
    }

    class GrandFather extends GGrandFather{
        @Override
        protected void thinking(){
            System.out.println("i am grandfather");
        }

        private void special() {
            System.out.println("GrandFather private method!");
        }
    }

    class Father extends GrandFather{
        protected void thinking(){
            System.out.println("i am father");
        }
    }

    class son extends Father{
        protected void thinking(){
            try{
                //                MethodType mt = MethodType.methodType(void.class);
                //                MethodHandle mh = lookup().findSpecial(GrandFather.class,
                //                    "thinking", mt, getClass());
                //                mh.invoke(this);


                Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                IMPL_LOOKUP.setAccessible(true);
                MethodHandles.Lookup lkp = (MethodHandles.Lookup) IMPL_LOOKUP.get(null);
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = lkp.findSpecial(GGrandFather.class, "thinking", mt, GrandFather.class);
                mh.invoke(this);
            }catch(Throwable e){
                e.printStackTrace();
            }
        }

        public void hello() {
            try{
                Field IMPL_LOOKUP = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
                IMPL_LOOKUP.setAccessible(true);
                MethodHandles.Lookup lkp = (MethodHandles.Lookup) IMPL_LOOKUP.get(null);
                MethodType mt = MethodType.methodType(void.class);
                MethodHandle mh = lkp.findSpecial(GrandFather.class, "special", mt, GrandFather.class);
                mh.invoke(this);
            }catch(Throwable e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        InvokeSpecial invokeSpecial = new InvokeSpecial();
        (invokeSpecial.new son()).thinking();
        (invokeSpecial.new son()).hello();
    }

}
