package com.dinpay.bdp.rcp.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author ll
* @date 2018年4月19日 下午2:54:34
* 字符串流中不重复的字符。例如字符串ababc，第一个不重复的字符串是c
 */
public class FirstNoRepeatChar {
    
    //定义数据结构
    //用来存放字符和出现的次数
    public static Map<Character,Integer> map = new HashMap<Character,Integer>();
    //存放字符流中的字符
    public static List<Character> list = new ArrayList<Character>(); 
    
    /**
     * map中不包含相应的字符，则将字符放到map中，并添加到list中
     * 若map中包含相应的字符，则将map中出现的次数加1，移除list中的字符
     */
    public  List<Character> checkChar(Character c){
        if(!map.containsKey(c)){
            map.put(c, 1);
            list.add(c);
        }else{
            map.put(c, Integer.valueOf(String.valueOf(map.get(c)))+1);
            if(list.contains(c)){
                list.remove(c);
            }
        }
        return list;
    }
    
    public char printResult(){
        if(list.isEmpty()){
            return '#';
        }
        return list.get(0);
           
    }
    
    public static void main(String[] args) {
        FirstNoRepeatChar fnr = new FirstNoRepeatChar();
        String str ="google";
        char[] cs = str.toCharArray();
        for (char c : cs) {
            fnr.checkChar(c);
        }
        System.err.println(fnr.printResult());
    }
    
    
}
