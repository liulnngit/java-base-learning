package com.javadev.chain_of_responsibility.dutyChain;

//部门经理
public class DepartmentManager extends Manager{
    public DepartmentManager(String name){super(name);}

    public void handleApplicationRequest(String content,double limit){
        if(content.equals("加薪")){
            superior.handleApplicationRequest(content,limit);
        }
    }

    public String getHanldeObject(){
        return "部门经理";
    }
}