package com.javadev.adapter.clean_model;

//外籍球员
public class ForeignNBAPlayer extends Player{
    public ForeignNBAPlayer(){}
    public ForeignNBAPlayer(String name){super(name);}
    public void attack(){
        System.out.println("我是中国球星，我在攻击！");
    }
}