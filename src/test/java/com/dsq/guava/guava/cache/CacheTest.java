package com.dsq.guava.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.sun.corba.se.impl.orbutil.graph.Graph;
import org.junit.Test;

import java.security.Key;
import java.util.concurrent.TimeUnit;

public class CacheTest {

    @Test
    public void test01(){
        LoadingCache<Key, Graph> graphs = CacheBuilder.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(10, TimeUnit.MINUTES)
                .removalListener(null)
                .build(new CacheLoader<Key, Graph>() {
                    @Override
                    public Graph load(Key key) throws Exception {
                        return null;
                    }
                });
    }
}
