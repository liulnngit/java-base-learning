package com.javadev.chain_of_responsibility;

/**
 * 行为型模式：责任链模式
 * @author ll-t150
 * 所谓责任链就是把责任处理对象连成一条链，这样当一个处理对象不能及时处理的时候就会交由下一个对象处理，直到被处理为止。
 * 	就像我们找人签字盖章的时候，当一个对象不能处理的时候他会告诉你你应该下一个部门进行盖章，而如果下一个部门仍然不能处理就会继续告诉你下一个应该去的部门，直到把章盖好。
 * 	这个例子不一定恰当，但是反映了责任传递这么一个过程。责任传递是责任链模式的核心
 * 责任链模式使得多个处理对象有机会处理请求，从而避免请求发送者和请求处理者之间的耦合，把这些对象连成一条链，并把这请求沿着这链进行传递，直到完成请求处理。
 * 
 * 请求发送者并不需要哪一个对象处理这个请求，因为总有一个请求接收者进行处理。在责任链模式中，
 * 由于请求的处理对象要形成一条链，所以每一个处理对象都要保存下一个处理对象的引用
 */
public class Client {
	
	public static void main(String[] args) {
		Handler h1 = new ConcreteHandle1();
		Handler h2 = new ConcreteHandle2();
		Handler h3 = new ConcreteHandle3();
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);
		
		int[] requests = new int[]{2,5,12,7,28,23,15};
		for (int i = 0; i < requests.length; i++) {
			h1.handleRequest(requests[i]);
		}
	}
}
