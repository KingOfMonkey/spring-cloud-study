package com.meiya.springcloudstudy.common.utils;

import java.util.zip.CRC32;

public class CRC32Util {

    public static long getCRC32(String str){
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes());
        return crc32.getValue();
    }
}
