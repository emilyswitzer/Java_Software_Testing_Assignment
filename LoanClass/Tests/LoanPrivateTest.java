import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoanPrivateTest {

    /**
     * Accessing a private member
     * Test of amount member, of class Loan.
     */

    @Test
    public void testAmountMember() throws Exception {
        System.out.println("testAmountMember");
        Loan target = new Loan(5000, 5);

        Class secretClass = target.getClass();

        /*Retrieve the field amount */
        Field f = secretClass.getDeclaredField("loanAmount");

        /* make sure the field is accessible. */
        f.setAccessible(true);

        /* get the value of the field */
        System.out.println("The value in f (loanAmount) is " + f.get(target));

        double result = f.getDouble(target);

        assertEquals(5000, result);
    }


    /**
     * Accessing a private member
     * Test of setAmount method, of class Loan.
     */

    @Test
    public void testsetAmountMethod() throws Exception {
        System.out.println("setAmountMethod");
        /* Set up a new Loan */
        Loan target = new Loan(5001, 3);

        /* get the setAmount method details */
        Method method = Loan.class.getDeclaredMethod("setAmount", double.class);

        /* make the method assessible */
        method.setAccessible(true);

        /* invoke the method setAmount with the value 5001 */
        method.invoke(target, 5001);

        /*access the field loanAmount and check its value is set to 5001*/
        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("loanAmount");

        f.setAccessible(true);

        double result = f.getDouble(target);
        System.out.println("The value in f (loanAmount) is " + f.get(target));
        assertEquals(5001, result);
    }

    /**
     * Accessing a private member
     * Test of setPeriod method, of class Loan.
     */

    @Test
    public void testsetPeriodMethod() throws Exception {
        System.out.println("setPeriodMethod");
        /* Set up a new Loan */
        Loan target = new Loan(5001, 3);

        /* get the setPeriod method details */
        Method method = Loan.class.getDeclaredMethod("setPeriod", int.class);

        /* make the method accessible */
        method.setAccessible(true);

        /* invoke the method setPeriod with the value 3 */
        method.invoke(target, 3);


        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("numberOfPayments");

        f.setAccessible(true);

        int result = f.getInt(target);
        System.out.println("The value in f (numberOfPayments) is " + f.get(target));
        assertEquals(36, result);
    }

    /**
     * Accessing a private member
     * Test of setRate method, of class Loan.
     */


    @Test
    public void testsetRateMethod() throws Exception {
        System.out.println("setRateMethod");
        /* Set up a new Loan */
        Loan target = new Loan(5001, 3);

        /* get the setRate method details */
        Method method = Loan.class.getDeclaredMethod("setRate", int.class);

        /* make the method accessible */
        method.setAccessible(true);

        /* invoke the method setRate with the value 3 */
        method.invoke(target, 3);

        Class secretClass = target.getClass();

        Field f = secretClass.getDeclaredField("annualRate");

        f.setAccessible(true);

        double result = f.getDouble(target);
        System.out.println("The value in f (annualRate) is " + f.get(target));
        assertEquals(8.0, result);
    }


}




