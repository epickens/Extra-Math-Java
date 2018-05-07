public class CmplxNum {
    private double a;
    private double b;

    public CmplxNum(double aCoe, double bCoe) {
        a = aCoe;
        b = bCoe;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    //add CmplxNum c to this complex number
    //return the sum
    public CmplxNum add(CmplxNum c) {
        double newA = this.getA() + c.getA();
        double newB = this.getB() + c.getB();
        return new CmplxNum(newA, newB);
    }

    //subtract CmplxNum c from this complex number
    //return the difference
    public CmplxNum subtract(CmplxNum c) {
        double newA = this.getA() - c.getA();
        double newB = this.getB() - c.getB();
        return new CmplxNum(newA, newB);
    }

    //create a conjugate by creating a new
    //Cmplx number using -1 * the complex coefficient
    //return the conjugate
    public CmplxNum getConjugate() {
        double newB = (-1) * this.getB();
        return new CmplxNum(this.getA(), newB);
    }

    //foil (a + bi)(c + di) and replace i^2 with -1
    //then combine like terms to get the resultant
    //(j + ki)
    //return the product of two complex numbers
    public CmplxNum multiply(CmplxNum c) {
        double newA = (this.getA() * c.getA()) - (this.getB() * c.getB());
        double newB = (this.getA() * c.getB()) + (this.getB() * c.getA());
        return new CmplxNum(newA, newB);
    }

    //use the multiply and conjugate methods to find this/c
    //multiply both c and this by the conjugate of c
    //this results in (this*cBar)/(c*cBar)
    //where (c*cBar) is a real number
    //divide the coefficients of (this*cBar) by (c*cBar)
    //return a new complex number using these values
    public CmplxNum divide(CmplxNum c) {
        double denom = c.multiply(c.getConjugate()).getA();
        double newA = this.multiply(c.getConjugate()).getA() / denom;
        double newB = this.multiply(c.getConjugate()).getB() / denom;
        return new CmplxNum(newA, newB);
    }

    //compute e^(a+bi)
    //convert to (e^(a))cos(b) + i(e^(a))sin(b)
    //compute the new coefficients
    //return new CmplxNum
    public CmplxNum exponentiate() {
        double expCoefficient = Math.exp(this.getA());
        double newA = expCoefficient * Math.cos(this.getB());
        double newB = expCoefficient * Math.sin(this.getB());
        return new CmplxNum(newA, newB);
    }
}
