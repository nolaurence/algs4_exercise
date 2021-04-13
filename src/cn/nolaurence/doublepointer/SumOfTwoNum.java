package cn.nolaurence.doublepointer;

public class SumOfTwoNum {
    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        int left = 0, right = numbers.length - 1;
        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                result[0] = left+1;
                result[1] = right+1;
                break;
            }
            if (sum > target) right--;
            if (sum < target) left++;
        }
        return result;
    }

    public int[] twoSumOfficial(int[] numbers, int target) {
        if (numbers == null) return null;
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                return new int[]{i + 1, j + 1};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers={2, 7, 11, 15};
        int target = 9;
        int[] result = SumOfTwoNum.twoSum(numbers, target);
        System.out.format("%d, %d", result[0], result[1]);
    }
}
