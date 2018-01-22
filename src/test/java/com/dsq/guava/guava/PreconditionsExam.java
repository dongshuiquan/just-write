package com.dsq.guava.guava;

import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * Created by DELL on 2017/11/11.
 */
public class PreconditionsExam {

    @Test(expected = IllegalArgumentException.class)
    public void checkArgument() {
        Preconditions.checkArgument(false);
    }

    @Test(expected = NullPointerException.class)
    public void checkNotNull() {
        String s = "a";
        s = Preconditions.checkNotNull(s);
        System.out.println(s);
        s = null;
        Preconditions.checkNotNull(s);
    }

    @Test(expected = IllegalStateException.class)
    public void checkState() {
        Preconditions.checkState(false);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void checkElementIndex() {
        Preconditions.checkElementIndex(1, 1);
    }

    //检查index作为位置值对某个列表、字符串或数组是否有效。index>=0 && index<=size *
    @Test(expected = IndexOutOfBoundsException.class)
    public void checkPositionIndex() {
        Preconditions.checkPositionIndex(1, 0);
    }

    @Test
    public void array() {
        Object ss = new double[0];
        System.out.println(ss.getClass());
    }

}
