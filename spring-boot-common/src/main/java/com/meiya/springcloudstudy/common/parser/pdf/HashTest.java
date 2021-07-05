package com.meiya.springcloudstudy.common.parser.pdf;

import com.meiya.springcloudstudy.common.utils.CRC32Util;

import java.util.UUID;

public class HashTest {

    public static void main(String[] args) {
//        String csno = UUID.randomUUID().toString();
        String csno = "11222222222222222222222222222222222222222222222222222222222217.27.241.254:9920";
        int size = 2^32;
        System.out.println(CRC32Util.getCRC32(csno) % size);
    }



}
