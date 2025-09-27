import java.util.*;

public class RandomUpperBound {
    public static int upperBound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                left = mid + 1;  // keep going right
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Random rand = new Random();

        // Generate random array of size 10 with values 1–10
        int[] nums = new int[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rand.nextInt(10) + 1;
        }

        Arrays.sort(nums); // sorted ascending
        System.out.println("Array: " + Arrays.toString(nums));

        // Pick a random target from 1–10
        int target = rand.nextInt(10) + 1;
        System.out.println("Target: " + target);

        // Find last occurrence
        int index = upperBound(nums, target);
        System.out.println("Last index of " + target + " = " + index);
    }
}
