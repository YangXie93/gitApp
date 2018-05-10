package app.excercise.algebra;

public class Rational extends BasisFraction{

    public Rational(){
        ;
    }

    private long N;
    private long D;

    public Rational(long N, long D){
        this.N = N;
        this.D = D;
    }

    public long getN(){
        return N;
    }

    public long getD(){
        return D;
    }

    protected void setND(long numerator,long denominator){
        if(denominator < 0){
            numerator *= -1;
            denominator *= -1;
        }
        long divi = euklidModern(numerator,denominator);
        N = numerator/divi;
        D = denominator/divi;
    }

    public static long euklidModern(long y,long x){
        long r;
        while ( y != 0) {
            r = x % y;
            x = y;
            y = r;
        }
        return x;
    }

    public Rational clone(){
        Rational clone = new Rational(N,D);
        return clone;
    }

    public Fractional negation(){
        Rational neg = this.clone();
        neg.setND(-N,D);
        return neg;
    }

    public Fractional reciprocal(){
        Rational rec = this.clone();
        rec.setND(D,N);
        return rec;
    }

    public String toString(){
        return N + "/" +D;
    }

    public boolean equals(Rational operand){
        return N == operand.getN() && D == operand.getD();
    }

    public int hashCode(){
        return  (int)(N *7 + D *5);
    }
}
