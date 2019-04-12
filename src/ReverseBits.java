public class ReverseBits {
    public long reverseBits(long n) {
        long res = 0;
        for (int i = 0; i < 32; i++) {
            res = res * 2;
            if ((n & 1) == 1) res++;
//            n >>= 1;
            System.out.println(n);
            n /= 2;
        }
        return res;
    }

    public int reverseBits2(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = res * 2;
            if ((n & 1) == 1) res++;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        String bs = "11111111111111111111111111111101";
//        long num = Integer.parseUnsignedInt(bs, 2);
        long num = Long.parseLong(bs, 2);
        System.out.println(num);
//        System.out.println(Integer.toUnsignedString(num));

        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(num));
    }
}
