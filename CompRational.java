package app.excercise.algebra;

public class CompRational extends Rational implements Comparable{

    public CompRational(long N,long D){
        super(N,D);
    }

    public int compareTo(Object ob){
        Rational operand = (Rational) ob;
        if(operand.getD() *this.getN() != this.getD() *operand.getN()){
            if(operand.getD() *this.getN() < this.getD() *operand.getN()){
                return -1;
            }
            else{
                return 1;
            }
        }
        else{
            return 0;
        }
    }
}
