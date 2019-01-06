public class TrappingRainWater {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1;
        int lMax = 0, rMax=0;
        int maxValue = 0;
        while (i <= j) {
            lMax = Math.max(lMax, height[i]);
            rMax = Math.max(rMax, height[j]);
            if (lMax < rMax) { // decided by the lower side
                maxValue += lMax - height[i];
                i++;
            } else{
                maxValue += rMax - height[j];
                j--;
            }
        }
        return maxValue;
    }

    public static void main(String[] args) {
       TrappingRainWater r = new TrappingRainWater();
        System.out.println(r.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
