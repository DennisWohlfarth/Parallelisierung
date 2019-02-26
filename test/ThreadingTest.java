import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ThreadingTest {
    @Test
    void test()
    {
        Threading thread = new Threading(1);
        assertTrue(thread.checkPrime(thread.reverse(14)));
        assertTrue(thread.checkPrime(thread.reverse((int)Math.pow(14, 2))));
    }

}