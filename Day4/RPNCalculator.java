package ssa;

import java.util.*;


//This program will simulate the operation of a RPN Calculator

public class RPNCalculator {

	
	public RPNCalculator() {
	}

	public void calcExpression() {
		int answer = 0;
		
		//*****************PLEASE INSERT TEST CODE BELOW*******************************//
		//char[] rpnExpression = new char[] { '1', '2', '+' };
		char[] rpnExpression = new char[] {'8', '2', '/', '9', '*', '1', '-', '7', '/'};
     
		//Stack object defined
		Stack<Integer> stack = new Stack<Integer>();

		
		//Evaluating the contents of the rpnExpression to 'push' to stack if numeric, and 'pop' from stack and perform calculations
		for (int i = 0; i < rpnExpression.length; i++) {
			int val = Character.getNumericValue(rpnExpression[i]);
			if (val != -1) {
				stack.push(val);
				//System.out.println(val);
			} 
			else 
			{
				//The following code will determine what action to take depending on the operator
				int firstPop = (int) stack.pop();
				int secPop = (int) stack.pop();
				//System.out.println(rpnExpression[i]);
				switch (rpnExpression[i]) {
				case '+':
					answer = firstPop + secPop;
					stack.push(answer);
					break;
				case '-':
					answer = secPop - firstPop;
					stack.push(answer);
					break;
				case '*':
					answer = firstPop * secPop;
					stack.push(answer);
					break;
				case '/':
					answer = secPop / firstPop;
					stack.push(answer);
					break;

				}

			}

		}

		answer = stack.pop();
		//System.out.println(answer);

		System.out.printf("Calculating ");
		for (int i = 0; i < rpnExpression.length; i++) {
			System.out.printf(" %c ", rpnExpression[i]);
				
		}
		System.out.print(":: Answer = " + answer);
	}
	

	public static void main(String[] args) {
		
        //Instance of the RPNCalculator class created to access class methods
		RPNCalculator calc = new RPNCalculator();

		calc.calcExpression();

	}
}