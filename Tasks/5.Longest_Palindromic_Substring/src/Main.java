public class Main {
    public static void main(String[] args) {
        String s = "xaabacxcabaaxcabaax";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        int size = s.length();
        int[][] dp = new int[size][size];
        int max = 0;
        int begin = 0;
        int end = 0;
        for (int z = 0; z < size; z++) {
            int i = 0, j = z;
            while (i < size && j < size) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (j - i == 1) {
                    if (s.charAt(j) == s.charAt(i)) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    if (s.charAt(j) == s.charAt(i) && dp[i + 1][j - 1] == 1) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                }
                if (dp[i][j] == 1) {
                    if (max < j - i) {
                        max = j - i;
                        begin = i;
                        end = j;
                    }
                }
                i++;
                j++;
            }
        }
        return s.substring(begin, end + 1);
    }
}
