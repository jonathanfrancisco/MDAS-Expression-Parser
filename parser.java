import java.util.ArrayList; 
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Expression {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		String expressionInput = input.nextLine();
		
		// THIS IS THE INPUT
//		String expressionInput =  "1000+0010";
		
		// gets the values seperated by the operators and stores in it in a list 
		List<String> expressionValues =  new ArrayList(Arrays.asList(expressionInput.split("[x+-/]")));
		
		// converts the expression values into integer		
		for(int i = 0;i<expressionValues.size();i++) {
			expressionValues.set(i, Integer.toString(Integer.parseInt(expressionValues.get(i),2)));
		}
		
		// gets the operators in the expression and stores in it in a list
		List<String> expressionOperators = new ArrayList();
		for(int i = 0;i<expressionInput.length();i++) {
			String op = String.valueOf(expressionInput.charAt(i));
			if(op.equals("+") || op.equals("-") || op.equals("x") || op.equals("/")) 
				expressionOperators.add(op);
		}
		

		// THE COMPLETED EXPRESSION YIKES >____<
		// adds up the expressionValues and expressionOperators in one single list
		// with the operators in-between
		List<String> expression = new ArrayList<String>();
		for(int i = 0;i<expressionValues.size();i++) {
			
			expression.add(expressionValues.get(i));
		
			if(i < expressionValues.size()-1)
				expression.add(expressionOperators.get(i));
			 
		}
		
		
		
	while(expression.contains("+") || expression.contains("-") || expression.contains("x") || expression.contains("/") ) {
		
		// MULTIPLICATION
		for(int i = 0;i<expression.size();i++) {
			
			if(expression.get(i).equals("x")) {
				
				// get the both side of this operator in the expression
				// and divide the two to get the quotient
		
				int leftSide = Integer.parseInt(expression.get(i-1));
				int rightSide = Integer.parseInt(expression.get(i+1));
				int product = leftSide * rightSide;
				
				// removes both side of the operator
				// and replaces the operator with new quotient
				expression.remove(i+1);
				expression.set(i, Integer.toString(product));
				expression.remove(i-1);
				
			}
			
		}

		
		// DIVISION
		for(int i = 0;i<expression.size();i++) {
			
			if(expression.get(i).equals("/")) {
				
				// get the both side of this operator in the expression
				// and divide the two to get the quotient
		
				int leftSide = Integer.parseInt(expression.get(i-1));
				int rightSide = Integer.parseInt(expression.get(i+1));
				int quotient = leftSide / rightSide;
				
				// removes both side of the operator
				// and replaces the operator with new quotient
				expression.remove(i+1);
				expression.set(i, Integer.toString(quotient));
				expression.remove(i-1);
				
			}
			
		}
		
	// ADDITION
		
		
		
		for(int i = 0;i<expression.size();i++) {
			
			if(expression.get(i).equals("+")) {
				
				// get the both side of this operator in the expression
				// and divide the two to get the quotient
		
				int leftSide = Integer.parseInt(expression.get(i-1));
				int rightSide = Integer.parseInt(expression.get(i+1));
				int sum = leftSide + rightSide;
				
				// removes both side of the operator
				// and replaces the operator with new quotient
				expression.remove(i+1);
				expression.set(i, Integer.toString(sum));
				expression.remove(i-1);
			}
			
		}
			
		
	
			
		
		// SUBTRACT
	
			
		for(int i = 0;i<expression.size();i++) {
			
			if(expression.get(i).equals("-")) {
				
				// get the both side of this operator in the expression
				// and divide the two to get the quotient
		
				int leftSide = Integer.parseInt(expression.get(i-1));
				int rightSide = Integer.parseInt(expression.get(i+1));
				int diff = leftSide - rightSide;
				
				// removes both side of the operator
				// and replaces the operator with new quotient
				expression.remove(i+1);
				expression.set(i, Integer.toString(diff));
				expression.remove(i-1);
				
			}
			
		}
		
	}
	
	
	int answer = Integer.parseInt(expression.get(0));
	System.out.println("The answer is "+Integer.toBinaryString(answer));
		
	}

}
