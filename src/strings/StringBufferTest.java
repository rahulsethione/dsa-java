package strings;

public class StringBufferTest {
    public static void main(String[] args) {
        String str = "racecar";

        StringBuffer stringBuffer = new StringBuffer(str);

        stringBuffer.setCharAt(3, 'E');

        System.out.println(stringBuffer.toString());
    }
}
