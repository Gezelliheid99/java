package com.pjj.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class MD5UtilTest {

    @Test
    public void getMD5() {
        String pas = MD5Util.getMD5("admin");
        System.out.println(pas);
    }
}