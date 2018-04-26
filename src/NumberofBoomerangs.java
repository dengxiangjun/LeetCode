import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/number-of-boomerangs/description/
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k)
 * such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * <p>
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <p>
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * Output:
 * 2
 * <p>
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * Created by deng on 2018/4/26.
 */
public class NumberofBoomerangs {

    public static void main(String[] args) {
        int[][] a = {{0, 0}, {1, 0}, {-1, 0},{0,1},{0,-1}};
        int res = numberOfBoomerangs(a);
        System.out.println(res);
    }

    public static int numberOfBoomerangs(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int res = 0;

        for (int i = 0; i < points.length; i++) {
            int[] point1 = points[i];
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j++) {
                if (i== j) continue;
                int[] points2 = points[j];
                int distance = getDistance(point1[0], point1[1], points2[0], points2[1]);
                map.put(distance, map.containsKey(distance) ? map.get(distance) + 1 : 1);
            }
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int val = entry.getValue();
                if (val > 1) res += val * (val - 1);
            }
        }
        return res;
    }

    public static int getDistance(int x1, int y1, int x2, int y2) {
        return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
    }
}
