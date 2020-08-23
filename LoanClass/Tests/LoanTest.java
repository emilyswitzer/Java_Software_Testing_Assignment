import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LoanTest{

    Loan loan = new Loan(5000,2);

    @Test
    public void testCreateADefaultLoan() {
        Loan l1 = new Loan();

    }


    @Test
    public void constructorTest(){



        assertEquals(5000, loan.getAmount());
        assertEquals(2, loan.getPeriod());
        assertEquals(10.0, loan.getRate());
    }
    @Test
    public void getAmountTest(){



        assertEquals(5000, loan.getAmount());
    }

    @Test
    public void getPeriodTest(){


        assertEquals(2, loan.getPeriod());

    }

    @Test
    public void getRateTenTest(){

        Loan loan = new Loan(500,1);
      assertEquals(10.0, loan.getRate());

    }
    @Test
    public void getRateEightTest(){

        Loan loan = new Loan(5001,1);
        assertEquals(8.0, loan.getRate());

    }
    @Test
    public void getRateSixTest(){

        Loan loan = new Loan(5000,4);
        assertEquals(6.0, loan.getRate());

    }
    @Test
    public void getRateFiveTest(){

        Loan loan = new Loan(8000,4);
        assertEquals(5.0, loan.getRate());

    }
    @Test
    public void getRateFailTest(){
        assertThrows(IllegalArgumentException.class, () -> { Loan loan = new Loan(0,0); } );
    }


    @Test
    void getMonthlyPaymentTest() {

        assertEquals(230.72463168758318,loan.getMonthlyPayment());



        }

    @Test
    void getTotalPayment() {
        assertEquals(5537.391160501997,loan.getTotalPayment());

    }

}