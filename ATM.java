package com.thread.abdul;
import java.util.Scanner;

public class ATM {
	
synchronized public void checkBalance(String name) {
	System.out.println(name + " has a checkbalance of amount");
	try {
		Thread.sleep(1000);
	}catch(Exception e)
	{}
}

synchronized public void withdraw(String name,int amount) {
	System.out.println(name + " wants to withdraw a amount of "+ amount+ "dollars");
	try {
		Thread.sleep(1000);
	}catch(Exception e)
	{}
}
	public static void main(String[] args) {
	
	ATM obj  = new ATM();
	Scanner sc = new Scanner(System.in);
	System.out.println("enter your name");
	String name = sc.nextLine();
	System.out.println("Enter an amount to withdraw");
	int amount = sc.nextInt();
	sc.nextLine();
	System.out.println("enter your name");
	String name2 = sc.nextLine();
	System.out.println("Enter an amount to withdraw");
	int amount2 = sc.nextInt();
	
	//obj.checkBalance(name);
	//obj.withdraw(name,amount);

	customer c = new customer(obj,name,amount); 
	customer c2 = new customer(obj,name2,amount2); 
	c.start();
	c2.start();
	}

}
class customer extends Thread{
	ATM obj;
	String name;
	int amount;
	customer(ATM obj,String name,int amount){
		this.obj=obj;
		this.name=name;
		this.amount=amount;
	}
	public void useAtm() {
		obj.checkBalance(name);
		obj.withdraw(name, amount);
	}
	public void run() {
		useAtm();
	}
}
