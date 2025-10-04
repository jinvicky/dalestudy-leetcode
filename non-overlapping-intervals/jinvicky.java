import java.util.Arrays;

/**
 * [연계 추천 문제]
 * #300 Longest Increasing Subsequence (DP)
 * #646 Maximum Length of Pair Chain (DP/그리디) -> LIS 기본 공식에 그리디 사전 정렬만 얹었다.
 */
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 1) return 0;
        // 빨리 끝나는 순으로 오름차순 정렬
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int total = intervals.length;

        /**
         * 왜 count가 1에서부터 시작할까?
         * 우리가 for문을 0이 아닌 1부터 시작하고 lastEndTime을 intervals[0][1]로 초기화 했다는 것 자체가
         * 첫 번째 구간을 선택했다는 의미다.
         * 앞서 Arrays.sort()로 오름차순 정렬을 했기 때문에 첫번째 구간은 최적의 선택일 확률이 높아서 우선 선택하고 진행하는 것이다.
         */
        int count = 1;
        int lastEndTime = intervals[0][1];

        /**
         * for문 i 포인터를 조작하는 것보다 명확한 로직 설정을 해야 한다. (개인 생각)
         */
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= lastEndTime) {
                count++;
                lastEndTime = intervals[i][1];
            }
        }
        return total - count;
    }
}
