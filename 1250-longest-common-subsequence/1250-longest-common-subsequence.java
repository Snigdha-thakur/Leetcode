// //Recursion approach
// class Solution {
//     int f(int ind1, int ind2, String s1, String s2)
//     {
//         if(ind1<0 || ind2<0) return 0;
//         if(s1.charAt(ind1)==s2.charAt(ind2))
//         return (1+f(ind1-1,ind2-1,s1,s2));
//         return Math.max(f(ind1-1,ind2, s1, s2), f(ind1,ind2-1,s1,s2));
//     }
//     public int longestCommonSubsequence(String text1, String text2) {
//         return f(text1.length()-1, text2.length()-1, text1, text2);
//     }
// }

//Memorization
class Solution {
    int f(int ind1, int ind2, String s1, String s2,int dp[][])
    {
        if(ind1<0 || ind2<0) return 0;
        if(dp[ind1][ind2]!=-1) return dp[ind1][ind2];
        if(s1.charAt(ind1)==s2.charAt(ind2))
        return (1+f(ind1-1,ind2-1,s1,s2,dp));
        return dp[ind1][ind2]=Math.max(f(ind1-1,ind2, s1, s2,dp), f(ind1,ind2-1,s1,s2,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()][text2.length()];
        for(int row[]: dp)
        Arrays.fill(row,-1);
        return f(text1.length()-1, text2.length()-1, text1, text2,dp);
    }
}

// //Tabulation

// class Solution {

//     public int longestCommonSubsequence(String text1, String text2) {
//          int[][] dp = new int[text1.length() + 1][text2.length() + 1];
//         for (int i = text1.length() - 1; i >= 0; i--) {
//             for (int j = text2.length() - 1; j >= 0; j--) {
//                 if (text1.charAt(i) == text2.charAt(j)) {
//                     dp[i][j] = 1 + dp[i + 1][j + 1];
//                 } else {
//                     dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
//                 }
//             }
//         }
//         return dp[0][0];
//     }
// }