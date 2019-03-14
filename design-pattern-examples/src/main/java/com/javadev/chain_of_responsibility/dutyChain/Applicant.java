package com.javadev.chain_of_responsibility.dutyChain;

//申请人
public class Applicant{
    private String name;
    private String content;
    private Manager manager;

    public Applicant(String name){this.name = name;}

    public Applicant(String name,Manager manager){this(name);this.manager = manager;}

    public void setName(String name){this.name = name;}
    public String getName(){return name;}
    public void setContent(String content){this.content = content;}
    public String getContent(){return content;}
    public void setManager(Manager manager){this.manager = manager;}
    public Manager getManager(){return manager;}

    public void submitApplicationRequest(String content,double limit){
        manager.handleApplicationRequest(content,limit);
    }

}