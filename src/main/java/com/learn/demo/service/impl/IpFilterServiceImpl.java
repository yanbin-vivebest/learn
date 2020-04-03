package com.learn.demo.service.impl;

import com.learn.demo.service.IpFilterService;
import com.learn.demo.util.StorageUtil;
import org.springframework.stereotype.Service;

@Service
public class IpFilterServiceImpl implements IpFilterService {

    @Override
    public boolean addWhiteIpAddress(String ip) {
        return StorageUtil.bloom.put(ip);
    }

    @Override
    public boolean isWhiteIpAddress(String ip) {
        return StorageUtil.bloom.mightContain(ip);
    }
}
