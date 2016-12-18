import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class PointTest {

    @Test
    public void testSlopeTo() {
        System.out.println("PointTest:testSlopeTo()");
        Point one = new Point(2, 3);
        Point two = new Point(2, 3);
        Point three = new Point(2, 5);
        Point four = new Point(1, 3);
        Point five = new Point(4, 6);
        
        assertEquals("Slope equals, expect Neg_Inf", one.slopeTo(two), Double.NEGATIVE_INFINITY, 0.001);
        assertEquals("Slope differ only by Y, expect Pos_Inf", one.slopeTo(three), Double.POSITIVE_INFINITY, 0.001);
        assertEquals("Slope differ only by X, expect +0.0", one.slopeTo(four), +0.0, 0.001);
        assertEquals("Slope differ, expect ", one.slopeTo(five), 1, 0.001);
        System.out.println("slope = " + one.slopeTo(five));
    }

    @Test
    public void testCompareTo() {
        System.out.println("PointTest:testCompareTo()");
        Point one = new Point(2, 3);
        Point two = new Point(3, 3);
        Point three = new Point(2, 5);
        
        assertEquals(one.compareTo(two), -1);
        assertEquals(one.compareTo(three), -1);
        assertEquals(two.compareTo(one), 1);
        assertEquals(two.compareTo(two), 0);
        assertEquals(three.compareTo(two), 1);
    }

}
