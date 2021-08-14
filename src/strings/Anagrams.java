package strings;

public class Anagrams {
    public static void main(String[] args) {
        String str1 = "listen",
            str2 = "silent";

        System.out.println(anagrams(str1, str2));
    }

    static boolean anagrams(String str1, String str2) {
        if(str1.length() != str2.length()) return false;

        int[] map1 = new int[256],
            map2 = new int[256];

        for(int i = 0; i < str1.length(); i++)
            map1[str1.charAt(i)]++;

        for(int i = 0; i < str2.length(); i++)
            map2[str2.charAt(i)]++;

        boolean result = true;

        for(int i = 0; i < 256; i++)
            result = result && map1[i] == map2[i];

        return result;
    }
}
