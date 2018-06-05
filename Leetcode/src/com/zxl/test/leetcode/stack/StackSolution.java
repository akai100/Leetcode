package com.zxl.test.leetcode.stack;

import java.util.Stack;

public class StackSolution {

	public int evalPRN(String[] tokens)
	{
		Stack stack = new Stack();
		for(int i = 0; i < tokens.length; i++)
		{
			if (tokens[i].equals("+"))
			{
				Integer a = (Integer) stack.pop();
				Integer b = (Integer) stack.pop();
				int c = a.intValue() + b.intValue();
				stack.push(new Integer(c));
			}else if (tokens[i].equals("-"))
			{
				Integer a = (Integer) stack.pop();
				Integer b = (Integer) stack.pop();
				int c = a.intValue() - b.intValue();
				stack.push(new Integer(c));
			}
			else if (tokens[i].equals("*"))
			{
				Integer a = (Integer) stack.pop();
				Integer b = (Integer) stack.pop();
				int c = a.intValue() * b.intValue();
				stack.push(new Integer(c));
			}
			else if (tokens[i].equals("/"))
			{
				Integer a = (Integer) stack.pop();
				Integer b = (Integer) stack.pop();
				int c = a.intValue() / b.intValue();
				stack.push(new Integer(c));
			}
			else{
				stack.push(Integer.valueOf(tokens[i]));
			}
		}
		return ((Integer) stack.pop()).intValue();
	}
}
