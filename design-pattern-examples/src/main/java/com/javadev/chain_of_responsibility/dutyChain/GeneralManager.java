package com.javadev.chain_of_responsibility.dutyChain;

import java.text.SimpleDateFormat;
import java.util.Date;

//总经理
public class GeneralManager extends Manager{
    public GeneralManager(String name){super(name);}

    public void handleApplicationRequest(String content,double limit){
        if(content.equals("加薪")){
            System.out.println(getHanldeObject() + "已经加薪申请。处理时间" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
        }
    }

    @Override
    public String getHanldeObject() {
        return "总经理";
    }
}