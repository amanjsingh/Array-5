// TC - O(1) => Limited number of tax brackets
// SC - O(1)

public class CalculateTax {
    class Solution {
        public double calculateTax(int[][] brackets, int income) {
            int prevBracketEnd = 0;
            double totalTax = 0;
            double outstanding = income;
            for (int[] currBracket : brackets) {
                double taxable = Math.min(currBracket[0] - prevBracketEnd, outstanding);
                double currTax = taxable * currBracket[1] / 100;
                totalTax += currTax;
                outstanding -= taxable;
                prevBracketEnd = currBracket[0];
            }

            return totalTax;
        }
    }
}