
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;


public class LoanSpecificationTest {

    private int expected;
    private int amount;
    private int period;

    /**
     * Testing valid loan with valid boundaries and partitions
     */

    @ParameterizedTest
    @CsvSource({"500.00, 1, 10.0", "10000.00, 5,  5.0", "5000, 3, 10.0", "5001, 4, 5.0", "600 , 4 ,6.0", "6000, 2, 8.0"})
    void testLoanValid(double amount, int period, double expected) {
        Loan loan = new Loan(amount, period);
        assertEquals(expected, loan.getRate());
    }


    /**
     * Testing invalid loan(below the range) with the invalid boundary and partition for LoanAmount
     */


    @ParameterizedTest
    @CsvSource({"499.00", "499.99", " 0", "-1.0"})
    void testLoanAmountTooLow(double amount){

        assertThrows(IllegalArgumentException.class , () -> {

            Loan loan = new Loan ( amount , 4 );
            assertEquals(expected, loan.getAmount());


    });

    }


    /**
     * Testing invalid loan(above the range) with the invalid boundary and partition for LoanAmount
     */




    @ParameterizedTest
    @CsvSource({"10000000", "10001", "10000.01", "99999"})
    void testLoanAmountTooHigh(double amount){

        assertThrows(IllegalArgumentException.class , () -> {

            Loan loan = new Loan ( amount , 4 );
            assertEquals(expected, loan.getAmount());


        });

    }
    /**
     * Testing invalid loan with the invalid partition for LoanAmount
     * This test fails because the entry for loanAmount was not a number



    @ParameterizedTest
    @CsvSource({"F", "null", "?", "A"})
    void testLoanAmountNotANumber(double amount){

        assertThrows(IllegalArgumentException.class , () -> {

            Loan loan = new Loan ( amount , 4 );
            assertEquals(expected, loan.getAmount());


        });

    }

    **/

    /**
     * Testing invalid loan with the invalid boundary and partition for Period(above the range)
     */

    @ParameterizedTest
    @CsvSource({"500.00, 7, 10.0", "10000.00, 6,  5.0"})
    void testLoanPeriodTooHigh(double amount, int period, double expected) {

        assertThrows(IllegalArgumentException.class, () -> {

            Loan loan = new Loan(amount, period);
            assertEquals(expected, loan.getRate());
        });
    }


    /**
     * Testing invalid loan with the invalid boundary and partition for Period(below the range)
     */
    @ParameterizedTest
    @CsvSource({"500.00, 0, 10.0", "10000.00, -1,  5.0"})
    void testLoanPeriodTooLow(double amount, int period, double expected) {

        assertThrows(IllegalArgumentException.class , () -> {

        Loan loan = new Loan(amount, period);
        assertEquals(expected, loan.getRate());
    });


    }
    /**
     * Testing invalid loan with the invalid partition for Period
     * This test fails because the entry for period was not a number

    @ParameterizedTest
    @CsvSource({"500.00, ?, ", "10000.00, F,  ","5000.00, null, "})
    void testLoanPeriodNotANumber(double amount, int period, double expected) {

        assertThrows(IllegalArgumentException.class , () -> {

            Loan loan = new Loan(amount, period);
            assertEquals(expected, loan.getRate());
        });


    }
**/
    /**
     * Testing invalid loan with a null LoanAmount
     */

    @Test
    void testLoanAmountNotNull(){

        assertThrows(IllegalArgumentException.class , () -> {

            Loan loan = new Loan ( amount , 4 );
            assertNotNull(loan);


        });

    }


}


