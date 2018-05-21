public class ContinuedFractions {
    //approximate a number using Continued Fractions

    public static double contFrac(double num, int depth) {
        //calculate int part
        int intPart = (int) Math.floor(num);

        //apparently java converts 1 / 0 to "infinity" (a max value int)
        //so I don't need to worry about 1 / 0 occurring because it
        //just zeros out the rest of the approximation
        //I'm sure this mess up the approximation a little bit
        //but it hasn't significantly impacted any of my test cases

        //calculate reciprocal part
        double recipFrac = 1 / (num - intPart);
        //if depth is one stop the recursion and return only
        //the integer part
        if (depth == 1) {
            return intPart * 1.0;
        } else {    // otherwise return the integer part plus the next step
            return intPart + 1 / (contFrac(recipFrac, depth - 1));
        }
    }

}
