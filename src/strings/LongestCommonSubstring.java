package strings;

public class LongestCommonSubstring {
    public static void main(String[] args) {

        String str1 = "qwertyabcdxyzab",
                str2 = "xyzabcd";

        String result = "xyzab";
        int output = lcs(str1, str2, 0, 0, 0);

        System.out.println(output == result.length() ? "Right" : "Wrong");
        System.out.println(output);

    }

    static int lcs(String str1, String str2, int i, int j, int count) {
        if(i == str1.length() || j == str2.length()) {
            return count;
        }

        if(str1.charAt(i) == str2.charAt(j)) {
            count = lcs(str1, str2, i + 1, j + 1, count + 1);
        }

        count = Math.max(
                count,
                Math.max(
                        lcs(str1, str2, i + 1, j, 0),
                        lcs(str1, str2, i, j + 1, 0)
                )
        );

        return count;
    }
}
