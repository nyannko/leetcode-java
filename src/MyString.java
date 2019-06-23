public class MyString {

    private final byte[] values;

    public MyString(byte[] bytes) {
        values = bytes;
    }

    public byte[] toArray() {
        return this.values;
    }

    public void getContent() {
        for (byte b : values) {
            System.out.print(b);
        }
    }
}

class FuckMyString extends MyString {

    private final byte[] someValues;

    public FuckMyString(byte[] bytes) {
        super(bytes);
        someValues = bytes;
    }

    public static void main(String[] args) {
        FuckMyString dummy = new FuckMyString(new byte[]{'a', 'b', 'c'});
        MyString string = dummy;
        dummy.getContent(); // 979899
        // change the byte array that both pointer "values" and "someValues" pointed to
        dummy.someValues[0] = 'b';
        dummy.getContent(); // 989899
        System.out.println();
        // Finally we change the value in MyString
        string.getContent(); // 989899

              String str = "abc";

      char data[] = {'a', 'b', 'c'};
      String str1 = new String(data);
        System.out.println(str1.intern() == str);
    }
}
