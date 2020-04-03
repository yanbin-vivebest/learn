package com.learn.demo.util;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;

public class StorageUtil {
    /**
     * 使用谷歌的布隆过滤器，也可以使用redis的
     */
    public static BloomFilter<String> bloom = BloomFilter.create(Funnels.stringFunnel(Charset.forName("utf-8")), 1000, 0.000001);
}
