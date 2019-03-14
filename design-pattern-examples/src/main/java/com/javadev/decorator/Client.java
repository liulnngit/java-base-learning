package com.javadev.decorator;

/**
 * 结构者模式：装饰模式,看看JDK的BIO库就知道，
 * 对于API的调用者而言，装饰模式并不好用
 * @author ll-t150
 *	它可以动态地为对象添加额外的职能。
 *		有一个组件类，有一个具体的组件类，这个具体的组件类就是要被装饰的对象，还有一个装饰者类，其继承了组件类，对于组件类来说不需要知道这个装饰者类对象的存在，
 *	因为装饰者对象真正发挥作用的对象是具体的组件类。
 *		要注意的是，组件类和装饰者类都是抽象类，为什么这么设计呢？这点其实很好理解，因为对于每一个具体的组件来说，可能装饰的花样不同，
 *	则具体的实现也就不同，把装饰者类设计成抽象类就可以把具体的装饰过程交给子类装饰者了，
 *		从而提高软件的灵活性。这同时也体现了依赖倒转原则，实现不应该依赖于细节而应该依赖于抽象。 
 *
 */
public class Client {
	
	public static void main(String[] args) {
		ConcreteComponent c = new ConcreteComponent();
		ConcreteDecoratorA da = new ConcreteDecoratorA(c);
		ConcreteDecoratorB db = new ConcreteDecoratorB(da);
		db.operation();
	}
	
}
