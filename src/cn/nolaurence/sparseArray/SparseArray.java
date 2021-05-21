/**
 * SparseArray
 * User: nolau
 * Date: 2021/5/21
 * Time: 18:36
 */
package cn.nolaurence.sparseArray;

public class SparseArray {
    public static void main(String[] args) {
        // 创建一个原始的二维数组 11*11
        // 0表示没有，1表示黑，2表示蓝
        int chessArr1[] [] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][4] = 2;

        System.out.println("Original 2 dim array");
        for (int[] row : chessArr1) {
            for (int data: row) {
                System.out.format("%d\t", data);
            }
            System.out.println();
        }

        // traditional array to sparse array
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0)
                    sum++;
            }
        }

        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        // 遍历二维数组，将非0的值存放到
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        System.out.println();
        System.out.println("Sparse Array:");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.format("%d\t%d\t%d\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
    }
}
