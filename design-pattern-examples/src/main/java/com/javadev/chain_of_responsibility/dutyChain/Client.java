package com.javadev.chain_of_responsibility.dutyChain;

/**
 * 行为型模式：责任链模式
 * 
 * 例子：
 * 	假设小张需要申请加薪，于是他首先向部门经理申请，部门经理觉得这个他做不了主于是又汇报给总监，总监觉得他也做不了主，
 *  于是就汇报给总经理，总经理觉得小张的表现很不错，遂同意小张的加薪申请。
 *
 * 通过设置上下级关系使得申请可以被逐级交给下一个处理对象进行处理，这也是责任链模式最吸引人的地方。
 * 当然模式总会有不足，比如，如果当申请提交到总经理那里的时候，总经理没有进行及时处理就会造成申请人的持续等待
 *
 *总结：
 *	1、发送者不需要知道接收者的具体信息，只要交给一个接收者就可以了。降低了客户与系统的耦合程度
 *	2、对于每一个具体的处理对象来讲，它只需要保存其下一个处理对象的引用就可以了，这样就使得处理对象之间的耦合度降低
 *	3、责任链的结构是在客户端定义的，这就使得可以随时增加或者修改责任链的结构，增强了指派责任的灵活性
 *	4、如果请求到达责任链的末端仍然没有处理就会造成客户端的等待
 *
 */
public class Client {
	public static void main(String[] args){

        Applicant xiaozhang = new Applicant("小张");
        Manager departmentManager = new DepartmentManager("经理");
        Manager majordomo = new Majordomo("总监");
        Manager genralManager = new GeneralManager("总经理");

        departmentManager.setSuperior(majordomo);
        majordomo.setSuperior(genralManager);

        xiaozhang.setManager(departmentManager);
        xiaozhang.submitApplicationRequest("加薪", 400);

    }
}
