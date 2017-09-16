package com.dsq.guava.StringProcess;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import org.junit.Test;

import java.util.Arrays;

public class StringProcessTest {

    @Test
    public void testJoiner(){
        Joiner joiner = Joiner.on(", ").skipNulls();
        String result = joiner.join("Harry", null, "Rom", "Hermione");
        System.out.println(result);
        System.out.println(joiner.join(Arrays.asList(2, 3, 7)));
    }

    @Test
    public void testSplitter(){
        String in = ",a,,b,";
        String[] result = in.split(",");
        for(String s : result){
            System. out.println(s);
        }
        System.out.println("end");
        Iterable<String>  it = Splitter.on(",").trimResults().omitEmptyStrings().split(in);
        it.forEach(System.out::println);
        System.out.println("end");
    }

    @Test
    public void testCharMather(){
        String theDigits = CharMatcher.DIGIT.retainFrom("abc123def456");
        System.out.println(theDigits);
        String spaced = CharMatcher.WHITESPACE.trimAndCollapseFrom("  abc   a,bc" ,' ');
        System.out.println(spaced);
        //去除两端的空格，并把中间的连续空格替换成单个空格
        String noDigits = CharMatcher.JAVA_DIGIT.replaceFrom("ase32dd3d", "*"); //用*号替换所有数字
        System.out.println(noDigits);
        String lowerAndDigit = CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("ab34a$%d");
        System.out.println(lowerAndDigit);
        // 只保留数字和小写字母

    }
}
