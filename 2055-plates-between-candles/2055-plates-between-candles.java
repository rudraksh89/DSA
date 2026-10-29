
import java.util.*;

class Solution {

    int lowerbound(List<Integer> list, int x) {
        int l = 0;
        int r = list.size() - 1;
        int ans = list.size();

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) >= x) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }

    int upperbound(List<Integer> list, int x) {
        int l = 0;
        int r = list.size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] pre = new int[n];
        int[] ans = new int[queries.length];

        pre[0] = (s.charAt(0) == '*') ? 1 : 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '*')
                pre[i] = pre[i - 1] + 1;
            else
                pre[i] = pre[i - 1];
        }

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|')
                list.add(i);
        }

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int left = lowerbound(list, l);
            int right = upperbound(list, r);

            if (left < list.size() && right >= 0 && left < right) {
                ans[i] = pre[list.get(right)] - pre[list.get(left)];
            } else {
                ans[i] = 0;
            }
        }

        return ans;
    }
}
