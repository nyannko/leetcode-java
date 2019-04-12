import java.util.Arrays;

public class Candy {
    public static int candy(int[] ratings) {
        int length = ratings.length;
        int[] candy = new int[length];
        Arrays.fill(candy, 1);

        for (int i = 1; i < length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }

        for (int i = length - 2; i >= 0; i--) {
            // if (ratings[i] > ratings[i + 1] && candy[i] <= candy[i + 1]) {
            //     candy[i] = candy[i + 1] + 1;
            // }
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i], candy[i + 1] + 1);
//                candy[i] = candy[i + 1] + 1;
            }
        }
        System.out.println(Arrays.toString(candy));

        int sum = 0;
        for (int n : candy) {
            sum += n;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[]{1,2,3,1,2,3}));
        //[3, 2, 1, 2, 3, 4, 5]
    }
}
