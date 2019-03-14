package com.javadev.decorator.read_model;

/**
 * 根据设计模式中单一职责原则，类中的方法越来越多肯定不是一件好事，使用装饰者模式可以很好解决这个问题。
 * 装饰者模式把一要新增加的字段、方法和逻辑从原有的类中移除，并创建一个新的类，成为装饰者类。
 * 当系统需要这个方法的时候，就可以根据需要灵活地选用装饰者了。这样就把核心功能与装饰功能分开了，从而可以有效去除重复的逻辑代码。
 *
 */
public class Client {
	
	//test case 
    public static void main(String[] args){

        Boy boy = new Boy("xiaofan");
        Girl girl = new Girl("rhway");

        Finery tshirt = new TShirt();
        Finery jeans = new Jeans();
        tshirt.decorateComponent(boy);
        jeans.decorateComponent(tshirt);
        jeans.show();

        System.out.println("**********");

        Finery skirt = new Skirt();
        Finery hat = new Hat();
        Finery highheeledshoes = new HighHeeledShoes();
        skirt.decorateComponent(girl);
        hat.decorateComponent(skirt);
        highheeledshoes.decorateComponent(hat);
        highheeledshoes.show();
    }
}
