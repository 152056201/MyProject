package cn.yh.test;

import cn.yh.Utils.MD5;

public class MD5Test {
    public static void main(String[] args) {
        MD5 getMD5 = new MD5();
        System.out.println(getMD5.GetMD5Code("user123"));
    }
}
