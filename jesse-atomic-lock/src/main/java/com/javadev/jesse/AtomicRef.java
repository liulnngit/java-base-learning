package com.javadev.jesse;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author jesse
 * @date 2018/6/24 17:31
 * 原子操作引用类
 */
public class AtomicRef {

    static AtomicReference<User> userAtomicReference = new AtomicReference<User>();

    public static void main(String[] args) {
        User user = new User("Mark",25);
        userAtomicReference.set(user);
        User updateUser = new User("Mick",26);
        userAtomicReference.compareAndSet(user,updateUser);
        System.out.println(userAtomicReference.get().getName());
        System.out.println(userAtomicReference.get().getOld());
    }

    static class User{
        private String name;
        private int old;

        public User(String name,int old){
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }

        public int getOld() {
            return old;
        }
    }
}
