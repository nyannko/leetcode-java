import java.util.HashMap;
import java.util.Map;

public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        int row = points.length;
        Map<Double, Integer> map = new HashMap<>();
        for (int i = 0; i < row; i++) {
            map.clear();
            for (int j = 0; j < row; j++) {
                if (i != j) { // if not the same node, cal distance
                    double distance = dis(i, j, points);
                    map.put(distance, map.getOrDefault(distance, 0) + 1);
                }
            }

            for (int count : map.values()) {
                if (count >= 2) {
                    res += count * (count - 1);
                }
            }
        }
        return res;
    }

    public double dis(int i, int j, int[][] points) {
        return Math.pow(points[i][0] - points[j][0], 2) + Math.pow(points[i][1] - points[j][1], 2);
    }
}
