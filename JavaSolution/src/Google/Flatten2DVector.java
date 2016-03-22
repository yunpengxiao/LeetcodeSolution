package Google;

/**
 * Created by xyunpeng on 3/21/16.
 */
public class Flatten2DVector {
    Iterator<List<Integer>> i;
    Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public int next() {
        hasNext();
        return j.next();
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext()) {
            j = i.next().iterator();
        }
        return j != null && j.hasNext();
    }
}
