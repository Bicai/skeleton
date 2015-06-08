/**
 * CalculatorUI 
 */
public class CalculatorUI {

	public static void main(String[] args) {
		String s;
		Calculator tester = new Calculator();
		while (true) {
			int a;
			int b;
			int result;
			s = StdIn.readString();
			char[] form = s.toCharArray();
			String input1;
			String input2;
			System.out.println(s[0]);
			System.out.println(s[2]);
			System.out.println(s[1]);
			// if (form[0] == '-') {
			// 	input1 = Character.toString(form[1]);
			// 	a = -(Integer.parseInt(input1));
			// 	if (form[5] == '-')
			// 		{input2 = Character.toString(form[6]);
			// 		b =  -(Integer.parseInt(input2));}
			// 	else
			// 		{input2 = Character.toString(form[5]);
			// 		b = (Integer.parseInt(input2));}
			// 	if (form[3] == '+')  {
			// 		result = tester.add(a, b);
			// 		StdOut.println(result);
			// 	}
			// 	else {
			// 		result = tester.multiply(a, b);
			// 		StdOut.println(result);
			// 	}
			// }
			// else {
			// 	input1 = Character.toString(form[0]);
			// 	a = Integer.parseInt(input1);
			// 	if (form[4] == '-')
			// 		{input2 = Character.toString(form[5]);
			// 		b =  -(Integer.parseInt(input2));}
			// 	else
			// 		{input2 = Character.toString(form[4]);
			// 		b = (Integer.parseInt(input2));}
			// 	if (form[2] == '+')  {
			// 		result = tester.add(a, b);
			// 		StdOut.println(result);
			// 	}
			// 	else {
			// 		result = tester.multiply(a, b);
			// 		StdOut.println(result);
			// 	}
			// }		
		}
	}
}