import list.EquationList;

public class Calculator {
    // YOU MAY WISH TO ADD SOME FIELDS
    public EquationList savedEquations = new EquationList("s",999,null);
    public int size = 0;
    /**
     * TASK 2: ADDING WITH BIT OPERATIONS
     * add() is a method which computes the sum of two integers x and y using 
     * only bitwise operators.
     * @param x is an integer which is one of two addends
     * @param y is an integer which is the other of the two addends
     * @return the sum of x and y
     **/
    public int add(int x, int y) {
        //recurrsive
        if (y==0) 
            return x;
        else
            return add(x^y, (x&y) << 1);
        //iteration
        // Iterate till there is no carry  
    // while (y != 0)
    // {
    //     // carry now contains common set bits of x and y
    //     int carry = x & y;  
 
    //     // Sum of bits of x and y where at least one of the bits is not set
    //     x = x ^ y; 
 
    //     // Carry is shifted by one so that adding it to x gives the required sum
    //     y = carry << 1;
    // }
    // return x;

    }

    /**
     * TASK 3: MULTIPLYING WITH BIT OPERATIONS
     * multiply() is a method which computes the product of two integers x and 
     * y using only bitwise operators.
     * @param x is an integer which is one of the two numbers to multiply
     * @param y is an integer which is the other of the two numbers to multiply
     * @return the product of x and y
     * source: http://stackoverflow.com/questions/4895173/bitwise-multiply-and-add-in-java
     **/
    public int multiply(int x, int y) {
        int a = x;
        int b = y;
        int result = 0;
        while (b != 0) // Iterate the loop till b==0
        {
            if ((b & 01) != 0) // Logical ANDing of the value of b with 01
            {
                result =  add(result, a); // Update the result with the new value of a.
            }
            a <<= 1;              // Left shifting the value contained in 'a' by 1.
            b >>= 1;             // Right shifting the value contained in 'b' by 1.
        }
        return result;
    } 

    /**
     * TASK 5A: CALCULATOR HISTORY - IMPLEMENTING THE HISTORY DATA STRUCTURE
     * saveEquation() updates calculator history by storing the equation and 
     * the corresponding result.
     * Note: You only need to save equations, not other commands.  See spec for 
     * details.
     * @param equation is a String representation of the equation, ex. "1 + 2"
     * @param result is an integer corresponding to the result of the equation
     **/
    public void saveEquation(String equation, int result) {
        EquationList oldFront = savedEquations;
        savedEquations = new EquationList(equation, result, oldFront);
        size = size + 1;
        // while (p.next != null) {
        //     p = p.next;
        // }
        // p.next = new EquationList(equation, result, null);
    }
    /**
     * TASK 5B: CALCULATOR HISTORY - PRINT HISTORY HELPER METHODS
     * printAllHistory() prints each equation (and its corresponding result), 
     * most recent equation first with one equation per line.  Please print in 
     * the following format:
     * Ex   "1 + 2 = 3"
     **/
    public void printAllHistory() {
        printHistory(size);
    }

    /**
     * TASK 5B: CALCULATOR HISTORY - PRINT HISTORY HELPER METHODS
     * printHistory() prints each equation (and its corresponding result), 
     * most recent equation first with one equation per line.  A maximum of n 
     * equations should be printed out.  Please print in the following format:
     * Ex   "1 + 2 = 3"
     **/
    public void printHistory(int n) {
        EquationList p = savedEquations;
        if (n == 0) {
            System.out.println("No equations");
        }
        for (int i = 0; i < n ; i++ ) {
            System.out.println(p.equation+" = "+p.result);
            p = p.next;
        }
    }    

    /**
     * TASK 6: CLEAR AND UNDO
     * undoEquation() removes the most recent equation we saved to our history.
    **/
    public void undoEquation() {
        savedEquations = savedEquations.next;
        size = size - 1;
    }

    /**
     * TASK 6: CLEAR AND UNDO
     * clearHistory() removes all entries in our history.
     **/
    public void clearHistory() {
        savedEquations = new EquationList("s",999,null);
        size = 0;
    }

    /**
     * TASK 7: ADVANCED CALCULATOR HISTORY COMMANDS
     * cumulativeSum() computes the sum over the result of each equation in our 
     * history.
     * @return the sum of all of the results in history
     **/
    public int cumulativeSum() {
        int sum = 0;
        EquationList p = savedEquations;
        if (size == 0 ) {
            return sum;
        }
        else {
            for (int i = 0; i < size ; i++ ) {
                sum += p.result;
                p = p.next;
            }
            return sum;
        }   
    }

    /**
     * TASK 7: ADVANCED CALCULATOR HISTORY COMMANDS
     * cumulativeProduct() computes the product over the result of each equation 
     * in history.
     * @return the product of all of the results in history
     **/
    public int cumulativeProduct() {
        int product = 1;
        EquationList p = savedEquations;
        if (size == 0 ) {
            return product;
        }
        else {
            for (int i = 0; i < size ; i++ ) {
                product = product * p.result;
                p = p.next;
            }
            return product;
        }
    }
}