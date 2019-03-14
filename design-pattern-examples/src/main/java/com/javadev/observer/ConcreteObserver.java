package com.javadev.observer;

/**
 * 具体观察者
 */
public class ConcreteObserver implements  Observer {

    private ConcreteSubject subject;

    private String name;

    public ConcreteObserver(ConcreteSubject subject, String name) {
        this.subject = subject;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ConcreteSubject getSubject() {
        return subject;
    }

    public void setSubject(ConcreteSubject subject) {
        this.subject = subject;
    }

    public void update(){
        System.out.println("update invoked!");
        System.out.println(subject.getSubjectState());
    }
}
