package com.dsq.proxy;

import java.lang.reflect.Method;

public class $Proxy1 implements HelloWorld
{
	InvocationHandler h;

	public $Proxy1(InvocationHandler h)
	{
		this.h = h;
	}

	public void print()
	{
		try
		{
			Method md = com.dsq.proxy.HelloWorld.class.getMethod("print");
			h.invoke(this, md);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}