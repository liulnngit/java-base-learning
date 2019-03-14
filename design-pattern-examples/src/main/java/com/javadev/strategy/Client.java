package com.javadev.strategy;

/**
 * 行为型模式：策略模式
 * @author ll-t150
 * 所谓行为型，就是其主要使用在方法有很大灵活性的情况。
 * 工厂模式主要是对象创建的优化，减少程序中new对象的次数
 * 	比如要比较两个对象的大小，可以使用默认的comparable接口，也可以实现自定义的比较规则，实现Compartor接口
 * 定义：定义了算法家族，把这些不同的算法封装起来，让他们可以之前可以相互替换。
 * 
 * 在java提倡的依赖倒转原则：意思是面向抽象编程，而不是面向细节编程，延伸来讲就是,对外暴露的细节越少越好，
 * 因为对外暴露的细节越少，因需求变更而修改的代码越少。
 * 
 * 
 */
public class Client {
	
	public static void main(String[] args) {
		Strategy strategyA = new StrategyA();
		Context a = new Context(strategyA);
		a.getStrategyAlgorithm();
		
		Strategy strategyB = new StrategyB();
		Context b = new Context(strategyB);
		b.getStrategyAlgorithm();
	}
}
