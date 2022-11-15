package com.thread.abdul;
class Data{
	int value;
	boolean flag = true;
	synchronized public void set(int value) {
		while(flag!=true) 
			try {
				wait();
			}catch(Exception e) {}
				
		this.value=value;
		flag=false;
		notify();	
	}
 synchronized public int get() {
	 int x =0;
		while(flag!=true) 
			try {
				wait();
			}catch(Exception e) {}

		x=value;
		flag = true;
		notify();
		return x;
	}
}
class producer extends Thread{
	Data d;
	producer(Data d){
		this.d=d;
	}
	public void run() {
		int count =1;
		while(count<=10) {
		d.set(count);
		System.out.println("Producer "+count);
		count++;
		}
	}
}
class consumer extends Thread{
	Data d;
	consumer(Data d){
		this.d=d;
	}
	public void run() {
		int value;
		int i=0;
		while(i<10) {
		value=d.get();
		System.out.println("consumer "+ value);
		i++;
		}
	}
}
public class InterProcess {

	public static void main(String[] args) {
		Data d = new Data();
		producer p = new producer(d);
		consumer c = new consumer(d);
		p.start();
		c.start();
		

	}

}
