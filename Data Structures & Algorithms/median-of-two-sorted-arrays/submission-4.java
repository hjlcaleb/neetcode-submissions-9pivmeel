class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;
        
        int total = nums1.length + nums2.length;
        int half = total / 2;

        if (b.length < a.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        int l = 0;
        int r = a.length - 1;
        while (true) {
            int i = Math.floorDiv(l + r, 2);
            int j = half - i - 2;

            int aLeft = (i >= 0) ? a[i] : Integer.MIN_VALUE;
            int aRight = (i + 1 < a.length) ? a[i + 1] : Integer.MAX_VALUE;
            int bLeft = (j >= 0) ? b[j] : Integer.MIN_VALUE;
            int bRight = (j + 1 < b.length) ? b[j + 1] : Integer.MAX_VALUE;

            // partition is correct
            if (aLeft <= bRight && bLeft <= aRight) {
                if (total % 2 == 1) {
                    return Math.min(aRight, bRight);
                } else {
                    return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
                }
            } else if (aLeft > bRight) {
                r = i - 1;
            } else if (bLeft > aRight) {
                l = i + 1;
            }
        }


    }
}
