class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length;
        int n2 = b.length;
        int total = n1 + n2;
        int mid = total / 2;

        int i = 0, j = 0, count = 0;
        int prev = 0, curr = 0;

        while (count <= mid) {
            prev = curr;

            if (i < n1 && (j >= n2 || a[i] <= b[j])) {
                curr = a[i];
                i++;
            } else {
                curr = b[j];
                j++;
            }

            count++;
        }

        if (total % 2 == 0) {
            return (prev + curr) / 2.0;
        } else {
            return curr;
        }
    }
}