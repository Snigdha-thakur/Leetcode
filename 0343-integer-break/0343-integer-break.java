class Solution {
    public int integerBreak(int n) {
        if (n < 4) return n -1;
        int res = 4;
        for(int i = 4; i < n; i++) res += res/(2 + res % 2);
        return res;
    }
}