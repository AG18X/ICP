class Solution {
    public int strStr(String h, String n) {
        int m = h.length(), l = n.length();
        for (int i = 0; i <= m - l; i++) {
            int j = 0;
            while (j < l && h.charAt(i + j) == n.charAt(j))
                j++;
            if (j == l)
                return i;
        }
        return -1;
    }
}