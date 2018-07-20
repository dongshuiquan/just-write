package com.clearbug.ex02;

import java.io.File;

/**
 * Created by clearbug on 2017/4/30.
 */
public class Constants {
    /**
     * WEB_ROOT is the directory where our HTML and other files reside.
     * For this package, WEB_ROOT is the "webroot" directory under the working directory.
     * The working directory is the location in the file system from where the java command was invoked.
     */
    public static final String WEB_ROOT = System.getProperty("user.dir") + File.separator + "webroot";

    /**
     * Servlet package namespace（这里懒得单独编译 PrimitiveServlet.java 源码了，直接使用在 com.clearbug.test 包下让编译器自动编程生成的吧！）
     */
    public static final String servletPackageNamespace = "com.clearbug.test";

    /**
     * 原文里没有这两行，不过目前我使用最新的 Chrome 并不能成功解析响应，所以只能加上响应行了。
     */
    public static final String successResponseLine = "HTTP/1.1 200 OK\r\n\r\n";
}
