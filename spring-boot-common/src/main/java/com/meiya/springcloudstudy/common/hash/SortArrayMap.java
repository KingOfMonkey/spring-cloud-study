package com.meiya.springcloudstudy.common.hash;

import com.meiya.springcloudstudy.common.utils.CRC32Util;

import java.util.*;

public class SortArrayMap {

    private Node[] buckets;

    private static final int DEFAULT_SIZE = 10;

    private int size = 0;

    public SortArrayMap() {
        this.buckets = new Node[DEFAULT_SIZE];
    }

    public void add(Integer key, String value){
        this.checkSize(size + 1);
        Node node = new Node(key, value);
        buckets[size++] = node;
    }

    private void checkSize(int size){
        if(size >= buckets.length){
            int oldLen = buckets.length;
            int newLen = oldLen + (oldLen >> 1);
            buckets = Arrays.copyOf(buckets, newLen);
        }
    }

    public void sort(){
        Arrays.sort(buckets, 0, size, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.getKey() > o2.getKey()){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
    }

    public String firstNodeValue(Integer key){
        if(size == 0){
            return null;
        }

        for (Node bucket : buckets){
            if(bucket == null){
                continue;
            }
            if(bucket.getKey() >= key){
                return bucket.getValue();
            }
        }
        return buckets[0].getValue();
    }

}
