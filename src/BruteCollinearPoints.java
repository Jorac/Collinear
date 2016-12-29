
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.In;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import sun.security.util.Length;

/**
 * examines 4 points at a time and checks whether they all lie on the same line
 * segment, returning all such line segments. To check whether the 4 points p,
 * q, r, and s are collinear, check whether the three slopes between p and q,
 * between p and r, and between p and s are all equal.
 *
 */
public class BruteCollinearPoints {

    private LineSegment[] segs;
    private int numberOfLines = 0;
    private int idx = 1;

    private void permutations(int k, Point[] arr) {
        ArrayList<Point> combin = new ArrayList<>();
        Arrays.sort(arr);
        makeCombinations(0, k, arr, combin);
    }

    /**
     * compute all combinations of k-tuples in arr
     *
     * @param first
     * @param k
     * @param arr
     */
    private void makeCombinations(int first, int k, Point[] arr, ArrayList<Point> comb) {
        if (k == 0) {
            execute(comb);
            return;
        }
        for (int i = first; i <= arr.length - k; i++) {
            comb.add(arr[i]);
            makeCombinations(i + 1, k - 1, arr, comb);
            comb.remove(comb.size() - 1);
        }
    }

    private void execute(ArrayList<Point> comb) {
        StdOut.println(idx + ": tuple = {" + comb.get(0) + ", " + comb.get(1) + ", " + comb.get(2) + ", " + comb.get(3) + "} size of comb = " + comb.size());
        StdOut.println(idx++ + ": slopeTo = {" + comb.get(0).slopeTo(comb.get(1)) + ", " + comb.get(1).slopeTo(comb.get(2)) + ", " + comb.get(2).slopeTo(comb.get(3)) + "}");
        if (comb.get(0).slopeTo(comb.get(1)) == comb.get(1).slopeTo(comb.get(2)) && comb.get(1).slopeTo(comb.get(2)) == comb.get(2).slopeTo(comb.get(3))) {
            segs[numberOfLines] = new LineSegment(comb.get(0), comb.get(3));
            numberOfLines++;
        }
    }

    /**
     * finds all line segments containing 4 points
     *
     * @param points
     */
    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new java.lang.NullPointerException();
        }
        if (points.length < 4) {
            return;
        }
        segs = new LineSegment[points.length];
        permutations(4, points);
    }

    /**
     * the number of line segments
     *
     * @return
     */
    public int numberOfSegments() {
        return numberOfLines;
    }

    /**
     * should include each line segment containing 4 points exactly once. If 4
     * points appear on a line segment in the order p→q→r→s, then you should
     * include either the line segment p→s or s→p (but not both) and you should
     * not include subsegments such as p→r or q→r. For simplicity, we will not
     * supply any input to BruteCollinearPoints that has 5 or more collinear
     * points.
     *
     * @return
     */
    public LineSegment[] segments() {
        LineSegment[] arr = new LineSegment[numberOfLines];
        for(int i = 0; i<numberOfLines; i++){
            arr[i] = segs[i];
        }
        return arr;
    }

    public static void main(String[] args) {

        StdOut.println(args.length);
        // read the n points from a file
        In in = new In(args[0]);
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        StdOut.println("size of lineSegs = " + collinear.segments().length);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
