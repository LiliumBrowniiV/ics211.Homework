package edu.ics211.h10;
import java.util.*;
public class GenTest {
	public static void main(String[] args) {
		System.out.println(convertPostFix("4*(6+8)*7*(6*(9+9))"));
	}
	 public static String convertPostFix(String arg) {
			return parseExp(new HW10StringIterator(arg));
		}		
		public static String parseExp(HW10StringIterator si) {
			StringBuilder result = new StringBuilder();
			if(!si.hasNext()) {
				return result.toString();
			}  
			char ch = si.next();
			//System.out.println("check char " + ch);
			if(Character.isDigit(ch) || Character.isAlphabetic(ch) || Character.compare(ch, '(') == 0) {
				si.backUp();
				result.append(parseTerm(si));
				return result.append(parseExp(si)).toString();
			} else if (Character.compare(ch, ')') == 0) {
				return result.toString();
			}  else {
				String term = parseTerm(si);
				result.append(term + ch + " ");
				return result.append(parseExp(si)).toString();
			}
			}
			
			public static String parseTerm(HW10StringIterator si) {
				  StringBuilder result = new StringBuilder();
				  if (! si.hasNext()) { 
					  //error, print and throw an exception 
					  si.backUp();
					  System.out.println(si.next());
					  throw new NoSuchElementException("(parseTerm) error no next element");
				  }
				  // the first thing we expect is an operand
				  // we immediately add it to the output postfix expression
				  result.append(parseFactor(si));
				  boolean done = false;
				  do {
				    // for a legal expression, after the operand we may see an operator,
				    // a closing parenthesis, or the end of the string
				    if (! si.hasNext()) {
				      break; // end of the string, we are done, exit the loop
				    }
				    char operator = si.next();
				    switch (operator) {
				      case '*': break;
				      case '/': break;
				      case '%': break;
				      // if we find an operator that is not part of the factor,
				      // we back it up so that operator can be processed by the method
				      // that called us
				      case '+': si.backUp(); done = true; break;
				      case '-': si.backUp(); done = true; break;
				      case ')': si.backUp(); done = true; break;
				      default:  
				    	  // error, print and throw an exception
				    	  System.out.println(operator);
				    	  throw new NoSuchElementException("get unexpected operand / operator");
				    }
				    if (! done) {
				      // now we read the second operand and add it to the result
				    	if(Character.compare(operator,')') == 0) {
				    		result.append(parseFactor(si) + " ") ;	
				    	} else {
				    		result.append(parseFactor(si) + operator + " ") ;	 
				    	}
				      // now add the operator
				    }
				  } while (! done);
				  return result.toString();
			}	
			public static String parseFactor(HW10StringIterator si) {
				StringBuilder Factor = new StringBuilder();
				if(!si.hasNext()) {
					throw new NoSuchElementException("(parseFator) error no next element");
				}
				char ch = si.next();
				if(Character.isDigit(ch) || Character.isAlphabetic(ch)) {
					Factor.append(ch + " ");
				}
				
				if(Character.compare(ch,'(') == 0) {
					Factor.append(parseParen(si));
				}
				return Factor.toString();
			}
			public static String parseParen(HW10StringIterator si) {
				StringBuilder Paren = new StringBuilder();
				Paren.append(parseExp(si));
				return Paren.toString();
			}	
}

