public class Main {
    public static void main(String[] args) {
        int [] nums1 = {2,4,5,8,10};
        int [] nums2 = {4,6,8,9};
        System.out.println(maxSum(nums1,nums2));
    }

    public static int maxSum(int[] nums1, int[] nums2) {
        final int kMod = (int) 1e9 + 7;
        long result = 0;
        long sum1 = 0;
        long sum2 = 0;
        int i = 0;
        int j = 0;

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                sum1 += nums1[i++];
            } else if (nums1[i] > nums2[j]) {
                sum2 += nums2[j++];
            } else {
                result += Math.max(sum1, sum2) + nums1[i];
                sum1 = 0;
                sum2 = 0;
                ++i;
                ++j;
            }
        }

        while (i < nums1.length) {
            sum1 += nums1[i++];
        }

        while (j < nums2.length) {
            sum2 += nums2[j++];
        }

        return (int) ((result + Math.max(sum1, sum2))% kMod);
    }
}
