import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    public static void rotate(int[][] matrix) {
        int[][] newMatrix = new int[matrix.length][matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[j][Math.abs(matrix.length - i - 1)] = matrix[i][j];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(newMatrix[i], 0, matrix[i], 0, matrix.length);
        }
    }
}
