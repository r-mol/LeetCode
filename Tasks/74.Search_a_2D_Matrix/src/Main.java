public class Main {
    public static void main(String[] args) {
        int [][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        int target = 3;
        System.out.println(searchMatrix(matrix,target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            if (ints[ints.length - 1] >= target) {
                for (int j = ints.length - 1; j >= 0; j--) {
                    if (ints[j] == target) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
