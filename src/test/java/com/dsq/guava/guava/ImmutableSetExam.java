package com.dsq.guava.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import org.junit.Test;

import java.awt.*;
import java.util.Set;

/**
 * Created by DELL on 2017/11/12.
 */
public class ImmutableSetExam {

    @Test
    public void copyOf() {
        ImmutableSet<String> COLOR_NAMES = ImmutableSet.of(
                "red",
                "orange",
                "green",
                "blue",
                "yellow",
                "purple");
        Set<String> set = ImmutableSet.copyOf(COLOR_NAMES);
        ImmutableList<String> defensiveCopy = ImmutableList.copyOf(COLOR_NAMES);

        System.out.println(set);
        System.out.println(defensiveCopy);
    }

    @Test
    public void builder() {
        Set<Color> WEBSAFE_COLORS = ImmutableSet.of();
        ImmutableSet<Color> GOOGLE_COLORS =
        ImmutableSet.<Color>builder()
                .addAll(WEBSAFE_COLORS)
                .add(new Color(0, 191, 255))
                .build();

    }
}
