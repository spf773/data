package com.container.hashmap;

import java.util.HashMap;
import java.util.Map;

public class MapTest {

    public static void main(String[] args){
        HashMap<String,Object> map1 = new HashMap<>();
        Map<String,Object> map2 = new HashMap<>();
        int i = 4;
        int b = 1;
        char a = 'i';
        System.out.println(i ^ b);
        System.out.println("li".hashCode());
        System.out.println(a - 1);
    }
}
