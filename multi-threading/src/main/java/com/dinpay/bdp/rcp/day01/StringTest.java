package com.dinpay.bdp.rcp.day01;

/**
 * ==在比较基本类型时比较的是值，在比较对象时比较的是两个对象的地址值。
 * 
 */
public class StringTest {
    
    public static void main(String[] args) {
        String a ="a"+"b"+1;
        String b ="ab1";
        System.out.println(a==b);//true
        System.out.println(a.equals(b));
        
    }
}
