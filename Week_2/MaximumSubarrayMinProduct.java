import java.util.Stack;
class Solution {
    public int maxSumMinProduct(int[] a) {
        int n = a.length;
        long mod = 1000000007;

        long[] prefix = new long[n];
        prefix[0] = a[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + a[i];
        }

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                left[i] = 0;
            } else {
                left[i] = st.peek() + 1;
            }
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] >= a[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                right[i] = n - 1;
            } else {
                right[i] = st.peek() - 1;
            }
            st.push(i);
        }

        long answer = 0;

        for (int i = 0; i < n; i++) {
            long sum;
            if (left[i] == 0) {
                sum = prefix[right[i]];
            } else {
                sum = prefix[right[i]] - prefix[left[i] - 1];
            }

            long product = sum * a[i];
            if (product > answer) {
                answer = product;
            }
        }

        return (int) (answer % mod);
    }
}