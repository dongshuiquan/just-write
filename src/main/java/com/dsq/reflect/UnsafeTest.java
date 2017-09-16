package com.dsq.reflect;

import org.junit.BeforeClass;
import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * Created by DELL on 2017/7/16.
 */
public class UnsafeTest {

    private static Unsafe unsafe;
    @BeforeClass
    public static void before(){
        try {
            Class<Unsafe> clazz = (Class<Unsafe>) Class.forName("sun.misc.Unsafe");
            Constructor<Unsafe> constructor =  clazz.getDeclaredConstructor();
            constructor.setAccessible(true);
            unsafe = constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void offset() throws NoSuchFieldException {
        Class<Person> clazzPerson = (Class<Person>) Person.class;
        Field age = clazzPerson.getDeclaredField("age");
        System.out.println(unsafe.objectFieldOffset(age));
        Field name = clazzPerson.getDeclaredField("name");
        long offset = unsafe.objectFieldOffset(name);
        System.out.println(offset);

        Person person = new Person(1, "a");
        //System.out.println(unsafe.getObject(age, 2));
        //System.out.println(unsafe.getObject(person, 0));
    }
    @Test
    public void swap(){
        Person person = new Person(20, "a");
        System.out.println(person);
        boolean flag = unsafe.compareAndSwapInt(person, 8, 20, 30);
        unsafe.compareAndSwapObject(person, 12, "a", "abc");
        System.out.println(flag);
        System.out.println(person);

       /* person =new Person(20, "a");
        unsafe.getAndSetObject(person, 12, "aabbcc");
        System.out.println(person);*/
    }

    @Test
    public void string() throws Exception{
        Class<String> clazz=  String.class;
        Field value = clazz.getDeclaredField("value");
        long offset = unsafe.objectFieldOffset(value);
        //System.out.println(offset);
        String s = "abc";
        System.out.println(s + "\t" + s.hashCode());
        System.out.println(System.identityHashCode(s));
        Object obj = unsafe.getAndSetObject(s, offset, new char[]{'d', 'e', 'f', 'g', 'h'});
        System.out.println(System.identityHashCode(s));
//        char[] arr = (char[])obj;
//        String s1 = new String(arr);
//        System.out.println(s1 + "\t" + s1.hashCode());
        System.out.println(s + "\t" + s.hashCode());
        System.out.println(s.equals("abc") + "\t" + (s == "abc"));
        System.out.println(s.equals(new String("abc")) + "\t" +(s ==new String("abc")));
        String s2 = "defgh";
        System.out.println(s2 + "\t" + s2.hashCode());
    }

    @Test
    public void string02() throws Exception{
        Class<String> clazz=  String.class;
        Field value = clazz.getDeclaredField("value");
        long offset = unsafe.objectFieldOffset(value);
        String s = "abc";
        System.out.println(s + "\t" + s.hashCode());
        System.out.println(System.identityHashCode(s));
        Object obj = unsafe.getAndSetObject(s, offset, new char[]{'d', 'e', 'f', 'g', 'h'});
        System.out.println(s + "\t" + s.hashCode());
        System.out.println(System.identityHashCode(s));
    }

}
