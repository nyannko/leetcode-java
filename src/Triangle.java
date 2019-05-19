import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static int minimumTotal1(List<List<Integer>> triangle) {
        int arr[] = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                arr[j] = Math.min(arr[j], arr[j + 1]) + triangle.get(i).get(j);
                System.out.println(Arrays.toString(arr));
            }
        }
        return arr[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = Arrays.asList(2);
        res.add(sub);
        sub = Arrays.asList(3, 4);
        res.add(sub);
        sub = Arrays.asList(6, 5, 7);
        res.add(sub);
        sub = Arrays.asList(4, 1, 8, 3);
        res.add(sub);
        Triangle.minimumTotal1(res);
    }
}
