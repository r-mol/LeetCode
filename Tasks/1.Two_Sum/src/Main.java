import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int num1 = 0; num1 < nums.length; num1++) {
            for (int num2 = num1 + 1; num2 < nums.length; num2++) {
                if (target - nums[num1] == nums[num2]) {
                    arr[0] = num1;
                    arr[1] = num2;
                    return arr;
                }
            }
        }
        return arr;
    }
}
