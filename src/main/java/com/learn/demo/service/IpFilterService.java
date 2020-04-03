package com.learn.demo.service;

public interface IpFilterService {
    boolean addWhiteIpAddress(String ip);
    boolean isWhiteIpAddress(String ip);
}
