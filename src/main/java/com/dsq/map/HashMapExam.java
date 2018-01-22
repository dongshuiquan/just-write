package com.dsq.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by DELL on 2017/10/15.
 */
public class HashMapExam {
    public static void main(String[] args) {
        new HashMap<String, String>(5);
    }

    @Test
    public void newMap() {

    }

    @Test
    public void linkedMap() {
        Map<String, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put("c", "c1");
        linkedMap.put("b", "b1");
        linkedMap.put("a", "a1");
        linkedMap.forEach((k, v) -> {
            System.out.println(k + "->" + v);
        });
    }
    @Test
    public void arrayMap() {
        Map<String, String> linkedMap = new HashMap<>();
        linkedMap.put("c", "c1");
        linkedMap.put("b", "b1");
        linkedMap.put("a", "a1");
        for(String s : linkedMap.keySet()) {
            System.out.println(s);
        }
    }

}
