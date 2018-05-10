import app.excercise.algebra.Rational;
import app.excercise.algebra.CompRational;

public class RationalTesting{
    public static Rational rat1;
    public static Rational rat2;

    public static CompRational corat1;
    public static CompRational corat2;

    public static void main(String[] args){
        rat1 = new Rational(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
        rat2 = new Rational(Integer.parseInt(args[2]),Integer.parseInt(args[3]));

        corat1 = new CompRational(Integer.parseInt(args[4]),Integer.parseInt(args[5]));
        corat2 = new CompRational(Integer.parseInt(args[4]),Integer.parseInt(args[3]));

        testArith();
        testHashEquals();
    }

    public static void testArith(){
        Rational a = rat1.clone();
        Rational b = rat2.clone();
        Rational c = rat1.clone();
        Rational d = rat2.clone();

        System.out.print("Addition:\n"+a +" + "+b +" = ");
        a.add(b);
        System.out.println(a);
        System.out.print(c +" + "+d +" = ");
        c.add(d);
        System.out.println(c);

        System.out.print("Subtraktion:\n"+d+" - "+c+" = ");
        d.sub(c);
        System.out.println(d);
        System.out.print(a+" - "+b+" = ");
        a.sub(b);
        System.out.println(a);
        System.out.print("Multiplikation:\n"+a+ " * "+b +" = ");
        a.mul(b);
        System.out.println(a);
        System.out.print(c +" * "+d +" = ");
        c.mul(d);
        System.out.println(c);

        System.out.print("Division:\n"+d+" / "+c+" = ");
        d.div(c);
        System.out.println(d);
        System.out.print(a+" / "+b+" = ");
        a.div(b);
        System.out.println(a);

        System.out.println();
    }

    public static void testHashEquals(){
        System.out.println("hashCode:\n"+rat1 +": "+rat1.hashCode());
        System.out.println(rat2+": "+rat2.hashCode());

        System.out.println("Equals:\n"+rat1+" == "+rat2+": "+rat1.equals(rat2));
        System.out.println(corat1+" == "+corat2+": "+corat1.equals(corat2));

        System.out.println("CompareTo:\n"+corat1+", "+corat2+": "+corat1.compareTo(corat2));
        System.out.println(corat2+", "+corat1+": "+corat2.compareTo(corat1));
        System.out.println();
    }
}
