package com.javadev.adapter.clean_model;

/**
 * 在这个例子中，外籍球员与本土球员完成的共同目标是打篮球
 * 让这两个接口能够协同工作就可以使用“适配器”来进行接口的适配，这样两个完全不相关的接口就能共同完成一个目标了，这也是适配器存在的意义
 */
public class Client {
	
	public static void main(String[] args){

        Player nativeNBAPlayer = new NativeNBAPlayer("Kobe");
        Player foreignNBAPlayer = new ForeignNBAPlayer("姚明");

        nativeNBAPlayer.attack();
        Translator translator = new Translator("翻译管官",foreignNBAPlayer);
        translator.translatorAttack();
    }
}
