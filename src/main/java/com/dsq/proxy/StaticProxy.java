package com.dsq.proxy;

public class StaticProxy implements HelloWorld
{
	HelloWorld interfaces;

	public StaticProxy(HelloWorld interfaces)
	{
		this.interfaces = interfaces;
	}

	public void print()
	{
		System.out.println("Before Hello World!");
		interfaces.print();
		System.out.println("After Hello World!");
	}
}