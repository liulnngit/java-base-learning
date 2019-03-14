package com.javadev.singleton;
/**
 * ”双检锁”(Double-Checked Lock)尽量将”加锁”推迟,只在需要时”加锁”
 * 	volatile保证原子操作,happens-before:”什么什么一定在什么什么之前运行”,也就是保证顺序性. 
 *		现在的CPU有乱序执行的能力(也就是指令会乱序或并行运行,可以不按我们写代码的顺序执行内存的存取过程),并且多个CPU之间的缓存也不保证实时同步,
 *	只有上面的happens-before所规定的情况下才保证顺序性.
 *		JVM能够根据CPU的特性(CPU的多级缓存系统、多核处理器等)适当的重新排序机器指令,使机器指令更符合CPU的执行特点，最大限度的发挥机器的性能.
 *		如果没有volatile修饰符则可能出现一个线程t1的B操作和另一线程t2的C操作之间对instance的读写没有happens-before，可能会造成的现象
 *	是t1的B操作还没有完全构造成功，但t2的C已经看到instance为非空，这样t2就直接返回了未完全构造的instance的引用，t2想对instance进行操作就会出问题.
 *
 *	volatile功能：
 *		1、避免编译器将变量缓存在寄存器中
 *		2、避免编译器调整代码顺序
 *	优化器在用到这个变量时必须每次都小心地重新读取这个变量的值，而不是使用保存在寄存器里的备份。
 */
public class DoubleCheckedLockingSingleton {
	
	private volatile static DoubleCheckedLockingSingleton singleton;
	
	private DoubleCheckedLockingSingleton(){}
	
	public static DoubleCheckedLockingSingleton getInstance(){
		if(singleton ==null){
			synchronized (DoubleCheckedLockingSingleton.class) {
				if(singleton == null){
					singleton = new DoubleCheckedLockingSingleton();
				}
			}
		}
		return singleton;
	}
	
	
}
