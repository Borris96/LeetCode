class Solution {
    public String longestPalindrome(String s) {
    // 中心扩散    
      if (s == null || s.length()<1)
        {
            return "";
        }
        int start = 0, end =0;
        for (int i = 0; i < s.length(); i++)
        {
            // 回文串是偶数的情况
            int len1 = expandAroundCenter(s, i, i);
            // 回文串是奇数的情况
            int len2 = expandAroundCenter(s, i, i+1);
            int  len = Math.max(len1, len2);
            // 根据返回的长度，找到左右边界
            if (len > (end - start))
            {
                start = i - (len-1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end+1);
    }
    
    /**
    从中心扩散，获取回文串的长度
     */
    private int expandAroundCenter(String s, int left, int right)
    {
        int L = left, R = right;
        // expand through the initial center in both directions
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R))
        {
            L--;
            R++;
        }
        return R - L - 1;
    }


// 动态规划
    // isPalindrome[i][j]
    // isPalindrome[i][i] = true;
    // isPalindrome[i][j] = charAt(i) == charAt(j);
    // isPalindrome[i + 1][j - 1] && charAt(i) == charAt(j)
    // j - i + 1
        String longest = "";
        if (s == null || s.length() == 0) {
            return longest;
        }
        
        int length = s.length();
        boolean[][] isPalindrome = new boolean[length][length];
        
        for (int i = 0; i < length; i++) {
            isPalindrome[i][i] = true;
        }
        
        longest = s.substring(0,1);
        for (int i = length - 1; i >= 0; i--) {
            for (int j = i; j < length; j++) {
                isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || isPalindrome[i + 1][j - 1]);
                if (isPalindrome[i][j]) {
                    if (j - i + 1 > longest.length()) {
                        longest = s.substring(i, j + 1);
                    }
                }
            }
        }
    
}
