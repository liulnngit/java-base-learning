package com.javadev.chain_of_responsibility.dutyChain;

import java.text.SimpleDateFormat;
import java.util.Date;

//总监
public class Majordomo extends Manager{
    public Majordomo(String name){super(name);}

    public void handleApplicationRequest(String content,double limit){
        if(content.equals("加薪") && Math.floor(limit) < 100){
            System.out.println(getHanldeObject() + "已经加薪申请。处理时间" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        }else if(content.equals("加薪") && Math.floor(limit) > 100){
            superior.handleApplicationRequest(content,limit);
        }
    }

    public String getHanldeObject(){
        return "总监";
    }
}