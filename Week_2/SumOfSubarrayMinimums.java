import java.util.Stack;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] a) {
        int n = a.length, mod = 1000000007;
        Stack<Integer> st = new Stack<>();
        int[] left = new int[n], right = new int[n];
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && a[st.peek()] > a[i])
                st.pop();
            if (st.isEmpty())
                left[i] = i + 1;
            else
                left[i] = i - st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && a[st.peek()] >= a[i])
                st.pop();
            if (st.isEmpty())
                right[i] = n - i;
            else
                right[i] = st.peek() - i;
            st.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (long) a[i] * left[i] * right[i];
            sum %= mod;
        }
        return (int) sum;
    }
}