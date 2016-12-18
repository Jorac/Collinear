
/**
 * examines 4 points at a time and checks whether they all lie on the same line
 * segment, returning all such line segments. To check whether the 4 points p,
 * q, r, and s are collinear, check whether the three slopes between p and q,
 * between p and r, and between p and s are all equal.
 *
 */
public class BruteCollinearPoints {

    Point[] pts;
    LineSegment[] segs;
    
    /**
     * finds all line segments containing 4 points
     * 
     * @param points
     */
    public BruteCollinearPoints(Point[] points) {
        if(points == null){
            throw new java.lang.NullPointerException();
        }
        pts = points.clone();
    }

    /**
     * the number of line segments
     * @return
     */
    public int numberOfSegments(){
        return segs.length;
    }

    /**
     * should include each line segment containing 4 points exactly once. 
     * If 4 points appear on a line segment in the order p→q→r→s, 
     * then you should include either the line segment p→s or s→p (but not both)
     * and you should not include subsegments such as p→r or q→r. 
     * For simplicity, we will not supply any input to BruteCollinearPoints 
     * that has 5 or more collinear points.
     * @return
     */
    public LineSegment[] segments(){
        return segs;        
    }
}
