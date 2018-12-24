public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // two pointers
        int result = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int area = Math.min(height[i], height[j]) * (j - i);
//            System.out.println(area);
            result = Math.max(result, area);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(height));
    }
}
