package com.dsq.proxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.Serializable;
import java.io.Writer;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by dong on 2018/5/20.
 */
public class ProxyVersion_0 implements Serializable {

    public static Object newProxyInstance() throws Exception {
        String src = "package com.dsq.proxy;\n" +
                "public class StaticProxy implements HelloWorld {\n" +
                "    private HelloWorld helloWorld;\n" +
                "    public StaticProxy(HelloWorld helloWorld) {\n" +
                "        this.helloWorld = helloWorld;\n" +
                "    }\n" +
                "    @Override\n" +
                "    public void print() {\n" +
                "        System.out.println(\"Before Hello World!\");\n" +
                "        helloWorld.print();\n" +
                "        System.out.println(\"After Hello World!\");\n" +
                "    }\n" +
                "}";

        String fileDir = System.getProperty("user.dir");
        String fileName = fileDir + "/src/main/java/com/dsq/proxy/StaticProxy.java";
        File javaFile = new File(fileName);
        System.out.println(javaFile.exists());
        Writer writer = new FileWriter(javaFile);
        writer.write(src);
        writer.close();

        // 动态编译
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager sjfm = compiler.getStandardFileManager(null, null, null);
        Iterable<? extends JavaFileObject> iter = sjfm.getJavaFileObjects(fileName);
        JavaCompiler.CompilationTask task = compiler.getTask(null, sjfm, null, null, null, iter);
        task.call();
        sjfm.close();

        //加载
        URL[] urls = new URL[] {(new URL("file:\\" + System.getProperty("user.dir") + "\\src"))};
        URLClassLoader ul = new URLClassLoader(urls);
        Class<?> c = ul.loadClass("com.dsq.proxy.StaticProxy");

        /** 利用反射将c实例化出来 */
        Constructor<?> constructor = c.getConstructor(HelloWorld.class);
        HelloWorld helloWorldImpl = new HelloWorldImpl();
        HelloWorld helloWorld = (HelloWorld)constructor.newInstance(helloWorldImpl);

        /** 使用完毕删除生成的代理.java文件和.class文件，这样就看不到动态生成的内容了 */
        File classFile = new File(fileDir + "\\src\\main\\java\\com\\dsq\\proxy\\StaticProxy.class");
        //javaFile.delete();
        classFile.delete();

        return helloWorld;
    }

    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        HelloWorld helloWorld = (HelloWorld)ProxyVersion_0.newProxyInstance();
        System.out.println("动态生成代理耗时：" + (System.currentTimeMillis() - start) + "ms");
        helloWorld.print();
        System.out.println();
    }
}
