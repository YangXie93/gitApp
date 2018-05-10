package app.excercise.algebra;

/**
*@author Yang Xie
*@version 0.1
*
*/

public abstract class BasisFraction implements app.excercise.algebra.Fractional{

  protected abstract void setND ( long numerator , long denominator );

  // get numerator
  public abstract long getN ();
  // get denominator
  public abstract long getD ();

  // add operand to object
  public void add ( Fractional operand ){
      long n = this.getN() *operand.getD() + this.getD() *operand.getN();
      long d = this.getD() *operand.getD();
      this.setND(n,d);
  }

  // subtract operand from object
  public void sub ( Fractional operand ){
      this.add(operand.negation());
  }

  // multiply object by operand
  public void mul ( Fractional operand ){
      this.setND(this.getN()*operand.getD(),this.getD() *operand.getD());
  }

  // divide object by operand
  public void div ( Fractional operand ){
      this.mul(operand.reciprocal());
  }
  // new additive inverse object
  public abstract Fractional negation ();
  // new multiplicative inverse object
  public abstract Fractional reciprocal ();
}
