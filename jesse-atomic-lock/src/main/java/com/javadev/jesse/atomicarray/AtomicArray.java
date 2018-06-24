package com.javadev.jesse.atomicarray;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * 原子操作数组类型
 * 数组通过构造方法传入，类会将数组复制一份，原数组不会发生变化
 */
public class AtomicArray {
    static int[] value = new int[]{1,2};
    static AtomicIntegerArray ai = new AtomicIntegerArray(value);

    public static void main(String[] args) {
        ai.getAndSet(0,3);
        System.out.println(ai.get(0));
        System.out.println(value[0]);
    }

}
