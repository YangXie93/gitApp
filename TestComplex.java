public class TestComplex{
	public static void main(String[] args){
		System.out.println("Die Länge des Test Arrays");
		int n = StdIn.readInt();
		if(n < 3){
			n = 3;
		}
		Complex[] testC = new Complex[n];
		for(int i = 0;i < n;i++){
			testC[i] = new Complex(i,i);
		}
		System.out.println("Zuerst die drei real Teile dann die Drei Imaginärteile");
		double real1 = StdIn.readDouble();
		double real2 = StdIn.readDouble();
		double real3 = StdIn.readDouble();
		System.out.println();
		double imaginary1 = StdIn.readDouble();
		double imaginary2 = StdIn.readDouble();
		double imaginary3 = StdIn.readDouble();
		Complex num1 = new Complex(real1,imaginary1);
		Complex num2 = new Complex(real2,imaginary2);
		Complex num3 = new Complex(real3,imaginary3);

		// ToString test wird 3 mal ausgeführt

		for(int i = 0;i < 3;i++){
			testToString(testC[i]);
			System.out.println();
			testAbs(testC[i]);
		}
		System.out.println();
		testHaschCode(testC);
		System.out.println();
		testAddition(num1.clone(),num2.clone(),num3.clone());
		System.out.println();
		testMultiplication(num1.clone(),num2.clone(),num3.clone());
		System.out.println();
		testCopyClone(num1,num2,num3);
		System.out.println();
		testEquals(num1,num2,num3);
	}

	public static void testToString(Complex num){
		System.out.println(num);
	}

	/*Test der Hashmethode.
	Es wird ein Array aus Complex Objekten übergeben und der Hascode aller Objekte auf
	Gleichheit überprüft*/

	public static void testHaschCode(Complex[] testC){
		boolean res = true;
		for(int i = 0;i < testC.length -2;i++){
			if(testC[i].hashCode() == testC[i +1].hashCode()){
				res = false;
			}
			if(testC[i].equals(testC[i].clone()) && testC[i].hashCode() != testC[i].clone().hashCode()){   // Es wird der equals Wert eines Objektes mit seinem Klon überprüft und der Hascode des Objektes mit dem eines weitern Klones
				res = false;
			}
		}
		System.out.println("The hash is distinctive: "+res);

	}

	/*Test der Additionsfunktionen.
	Es werden 3 Complex Objekte übergeben und dann in 3 zweier paaren zuerst die Instanzmethode
	und dann die Klassenmethode angewandt und die Ergebnisse gedruckt*/

	public static void testAddition(Complex num1, Complex num2,Complex num3){
		System.out.println("Class method(add) :\nfirst plus second: " +Complex.add(num1,num2)+"\nsecond plus third: "+Complex.add(num2,num3)+"\nfirst and third: "+Complex.add(num1,num3));
		System.out.println();
		System.out.println("Instance method(add) :\nfirst plus second: "+ num1.add(num2) +"\nsecond plus third: " +num2.add(num3));
		System.out.println("third and first: "+num1.add(num3));
	}

	/*Test der Multiplikationsfunktionen. Hier werden 3 Complex Objekte übergeben, dann werden drei zweier kombinationen
	einmal mit der Instanzmethode durchgeführt und gedruckt und danach mit der Klassenmethode*/

	public static void testMultiplication(Complex num1, Complex num2, Complex num3){
		System.out.println("Class method(mult):\nfirst and second"+ Complex.mult(num1,num2)+"\nsecond and third: "+Complex.mult(num2,num3)+"\nfirst and third: "+Complex.mult(num1,num3));
		System.out.println();
		System.out.println("Instance method(mult):\nfirst and second"+ num1.mult(num2)+"\nsecond and thrid: "+num2.mult(num3));
		System.out.println("first and third: "+num1.mult(num3));
	}

	/*Testen der Absolut Funktionen. Die Zahl wird in die selbe Zeile Gedruckt wie ihr Betrag
	Dies wird einmal mit der Instanz Funktion und einmal mit der Klassen Funktion gemacht.*/

	public static void testAbs(Complex num){
		System.out.println("(instance)the absolute of "+num+" is "+num.abs());
		System.out.println("(class) the absolute of "+num+" is "+Complex.abs(num));
	}

	/* Testen der Clone Funktion und des Copy Konstruktors durch erstellen von Kopien
	und durch anwenden der Funktion.
	Die Zahlen werden Zeilen weise Gedruckt, wobei sie den Klonen/Kopien Gegenübergestellt sind*/

	public static void testCopyClone(Complex num1,Complex num2,Complex num3){
		System.out.println("(clone) \none: "+num1+":(c) "+num1.clone()+"\ntwo: "+num2+":(c) "+num2.clone()+"\nthree: "+num3+":(c) "+num3.clone());
		Complex copy1 = new Complex(num1);
		Complex copy2 = new Complex(num2);
		Complex copy3 = new Complex(num3);
		System.out.println();
		System.out.println("(copy)\n one:"+num1+":(c) "+copy1+"\ntwo: "+num2+":(c)"+copy2+"\nthree: "+num3+":(c) "+copy3);
	}

	public static void testEquals(Complex num1,Complex num2,Complex num3){
		// Test auf Reflexivität durch Durchlaufen eines Wahrheitsgitters
		boolean bool = false;
		if(num1.equals(num1)){
			if(num2.equals(num2)){
				if(num3.equals(num3)){
					bool = true;
				}
			}
		}
		System.out.println("reflexive = "+bool);

		// Test auf Konsistenz durch 100 maliges wiederholen des selben Vergleiches
		bool = true;
	 	boolean test = num1.equals(num2);
		for(int i = 0;i < 100;i++){
			if(num1.equals(num2) != test){
				bool = false;
			}
		}
		System.out.println("consistent = "+bool);

		// Test auf Symmetrie durch den Vergleich zweier umgedrehter Wahrheits gleichungen
		bool = true;
		if(num2.equals(num1) != num1.equals(num2)){
			bool = false;
		}
		System.out.println("symmetric = "+bool);

		// Test auf Transitivität durch durchlaufen eines Wahrheitsgitters(nur möglich wenn alle Gleich sind)
		if(num1.equals(num2)){
			if(num2.equals(num3)){
				System.out.println("transitive = "+num1.equals(num3));
			}
		}
	}
}
