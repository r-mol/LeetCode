import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int []nums1 = {1,3};
        int []nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> finalArr = new ArrayList<>();
        for (int j : nums1) {
            finalArr.add(j);
        }
        for (int j : nums2) {
            finalArr.add(j);
        }

        Collections.sort(finalArr);

        if (finalArr.size() % 2 == 0) {
            return (double) (finalArr.get(finalArr.size() / 2-1) + finalArr.get(finalArr.size() / 2)) / 2;
        } else {
            return (double) finalArr.get((finalArr.size() - 1) / 2);
        }
    }
}
