package com.gzk.utils;

import org.junit.Test;

import java.util.UUID;

public class IDUtils {

    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }

    @Test
    public void ss(){
        System.out.println(IDUtils.getId());
    }




}
