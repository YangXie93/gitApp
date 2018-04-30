public class Complex{
	/** Eine Klasse zur Umsetzung komplexer Zahlen in Java:
	*
	* @author Yang Xie
	* @version 0.1
	*/

// ########################## Klassen-/ Instanzvariablen #######################################################

	/**
	*Klassenvariable I
	*/
	private static Complex I = new Complex(0,1);
	/**
	*Klassenvariable ZERO
	*/
	private static Complex ZERO = new Complex(0,0);
	/**
	*Klassenvariable ONE
	*/
	private static Complex ONE = new Complex(1,0);

	/**
	*Instanzvariable real
	*Die Variable beschreibt den Realteil
	*/
	private double real;
	/**
	*Instanzvariable imaginary
	*Die Variable beschreibt den Imaginärteil
	*/
	private double imaginary;

// ######################## Konstruktoren #########################################################################

	/**
	*Klassenkonstruktor
	*@param real double Wert der den Real teil der Zahl ausmacht
	*@param imaginary double Wert der den Imaginärteil der Zahl ausmacht
	*/
	public Complex(double real, double imaginary){
		this.real = real;
		this.imaginary = imaginary;
	}

	/**
	*"Copy"-Konstruktor der ein Complex Objekt mit den selben Parametern erzeugt, wie die des übergebenen
	*@param num Complex Objekt das zu kopieren ist
	*/
	public Complex(Complex num){
		this(num.getReal(),num.getImaginary());
	}

// ################################## Methoden ##########################################################################

	/**
	*Eine getter Methode für @see real
	*@return Real Wert der Instanz
	*/
	public double getReal(){
		return real;
	}

	/**
	*Eine getter Methode für @see imaginary
	*@return imaginär Wert der Instanz
	*/
	public double getImaginary(){
		return imaginary;
	}

	/**
	*Eine Setter Methode für @see real
	*@param real double Wert der zum Realteil der in dieser Instanz repräsentierten komplexen Zahl wird
	*/
	public void setReal(double real){
		this.real = real;
	}

	/**
	*Eine setter Methode für @see imaginary
	*@param imaginary double Wert der zum Imaginärteil der in dieser Instanz repräsentierten komplexen Zahl wird
	*/
	public void setImaginary(double imaginary){
		this.imaginary = imaginary;
	}

	/**
	*Eine to String Methode
	*@return "(real + imaginary i)"
	*/
	public String toString(){
		String result = "";
		result += "("+this.real +" + " +this.imaginary+"i"+")";
		return result;
	}

	/**
	*Eine Methode zum Vergleichen von Complex-Objekten
	*@param num Complex Objekt
	*@return boolean Wert der eine Aussage über die Gleichheit von @see real und @see imaginary zweier Objekte enthält
	*/
	public boolean equals(Complex num){
		if(num == null){
			return false;
		}
		return (this.real == num.getReal() && this.imaginary == num.getImaginary());
	}

	/**
	*Eine Instanzmethode zum Zusammenaddieren zweier Complex Objekte
	*@param num Complex Objekt
	*@return Die nun veränderte Instanz aus der die Methode ausgeführt wurde
	*/
	public Complex add(Complex num){
		this.real += num.getReal();
		this.imaginary += num.getImaginary();
		return this;
	}

	/**
	*Eine Instanzmethode zum Multiplizieren zweier Complex Objekte
	*@param num Complex Objekt
	*@return Die nun veränderte Instanz aus der die Methode ausgeführt wurde
	*/
	public Complex mult(Complex num){
		double re = this.real*num.getReal() -(this.imaginary *num.getImaginary());
		double im = this.imaginary *num.getReal() + (this.real *num.getImaginary());
		this.real = re;
		this.imaginary = im;
		return this;
	}

	/**
	*Eine Klassenmethode zum Addieren zweier Complex Objekte
	*@param num1 Complex Objekt
	*@param num2 Complex Objekt
	*@return Ein Complex Objekt in dem das Ergebnis der Rechnung gespeichert ist.
	*/
	public static Complex add(Complex num1,Complex num2){
		Complex result = new Complex(0,0);
		double real = num1.getReal() + num2.getReal();
		result.setReal(real);
		double imaginary  = num1.getImaginary() + num2.getImaginary();
		result.setImaginary(imaginary);
		return result;
	}

	/**
	*Eine Klassenmethode zum Multiplizieren zweier Complex Objekte
	*@param num1 Complex Objekt
 	*@param num2 Complex Objekt
	*@return Ein Complex Objekt in dem das Ergebnis der Rechnung gespeichert ist.
	*/
	public static Complex mult(Complex num1, Complex num2){
		Complex result = new Complex(0,0);
		double real = num1.getReal() *num2.getReal() -(num1.getImaginary() *num2.getImaginary());
		double imaginary = num1.getImaginary() *num2.getReal() +(num1.getReal() *num2.getImaginary());
		result.setReal(real);
		result.setImaginary(imaginary);
		return result;
	}

	/**
	*Eine Instanzmethode die den Betrag der komplexen Zahl berechnet
	*@return double Betrag
	*/
	public double abs(){
		return (Math.sqrt((real *real) +(imaginary *imaginary)));
	}

	/**
	*Eine Klassenmethode die den Betrag einer übergebenen komplexen Zahl berechnet
	*@param num komplexe Zahl deren Betrag zu errechnen ist
	*@return double Betrag
	*/
	public static double abs(Complex num){
		return (Math.sqrt((num.getReal() *num.getReal()) +(num.getImaginary() *num.getImaginary())));
	}

	/**
	*
	*/
	public int hashCode(){
		String str = "" +real +imaginary;
		str.replaceAll(".","0");
		str.replaceAll("-","0");
		return Integer.parseInt(str);
	}

	/**
	*Eine Instanzmethode zur Erstellung eines Complex Objekt
	*@return Complex Objekt mit den selben Parametern wie die der Instanz aus der die Methode aufgerufen wird.
	*/
	protected Complex clone(){
		Complex clone = new Complex(real,imaginary);
		return clone;
	}
}
