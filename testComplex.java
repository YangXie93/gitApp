public class testComplex{
	public static void main(String[] args){
		int n = StdIn.readInt()
		Complex[] testC = new Complex[n];
		for(int i = 0;i < n;i++){
			testC[i].setReal = i;
			testC[i].setImaginary = i;
		}
		Double real1 = StdIn.readDouble();
		Double real2 = StdIn.readDouble();
		Double imaginary1 = StdIn.readDouble();
		Double imaginary2 = StdIn.readDouble();
		Complex num1 = new Complex(real1,imaginary1);
		Complex num2 = new Complex(real2,imaginary2);

	}

	public static void testToString(Complex num){
		System.out.println(num);
	}

	public static void testHaschCode(Complex[] testC){
		boolean res = true;
		for(int i = 0;i < testC.length -2;i++){
			if(testC[i].hashCode() == testC[i +1].hashCode()){
				res = false;
			}
		}
		System.out.println("The hash is distinctive: "+res);
	}

	public static void testAddition(Complex num1, Complex num2,Complex num3){
		System.out.println("Instance method(add) :\nfirst plus second: " num1.add(num2) +"\n second plus third: " +num2.add(num3)+"\nthird and first: "+num1.add(num3));
		System.out.println("Class method(add) :\nfirst plus second: " +Complex.add(num1,num2)+"\n second plus third: "+Complex.add(num2,num3)+"\nfirst and third: "+Complex.add(num1,num3));
	}

	public static void testMultiplication(Complex num1, Complex num2, Comple num3){
		System.out.println("Instance method(mult):\nfirst and second"+ num1.mult(num2)+"\nsecond and thrid: "+num2.mult(num3)+"\nfirst and third: "+num1.mult(num3))
		system.out.println()
	}
}
