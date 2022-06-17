class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < firstList.length && j < secondList.length) {
            int[] a = firstList[i];
            int[] b = secondList[j];
            if (!(a[1] < b[0] || a[0] > b[1])) {
                res.add(new int[] { Math.max(a[0], b[0]), Math.min(a[1], b[1]) });
            }

            if (a[1] < b[1]) {
                i++;
            } else {
                j++;
            }
        }

        int[][] resArr = new int[res.size()][2];
        for (i = 0; i < resArr.length; ++i) {
            int[] interval = res.get(i);
            resArr[i][0] = interval[0];
            resArr[i][1] = interval[1];
        }
        return resArr;
    }
}
