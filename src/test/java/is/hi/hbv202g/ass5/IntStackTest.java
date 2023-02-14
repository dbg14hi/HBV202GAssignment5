package is.hi.hbv202g.ass5;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntStackTest {
    private IntStack stack;

    @Before
    public void createStackTest() {
        stack = new IntStack();
    }

    @Test
    public void testNewStackIsNotFull() {
        assertFalse(stack.isFull());
    }

    @Test
    public void testFullStackIsFull() {
        int max = stack.getCapacity();

        for (int i = 0; i < max; i++) {
            stack.push(i);
        }

        assertTrue(stack.isFull());
    }

    @Test
    public void testAlmostFullStack() {
        int max = stack.getCapacity();

        for (int i = 0; i < max - 1; i++) {
            stack.push(i);
        }

        assertFalse(stack.isFull());
    }

    @Test
    public void testPopReturnsPushedValue() {
        int b = 10;
        stack.push(b);

        int c = stack.pop();

        assertEquals(b, c);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPopEmptyStack() {
        stack.pop();
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void testPushOnFullStack() {
        int max = stack.getCapacity();

        for (int i = 0; i < max; i++) {
            stack.push(i);
        }

        stack.push(1);
    }

    @Test
    public void testIsEmptyOnEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        stack.push(1);

        assertFalse(stack.isEmpty());
    }
}
