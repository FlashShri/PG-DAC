import java.util.Arrays;

public class RearrangeNegativeAndPositive {
    public static void rearrange(int[] arr) {
        int left = 0; // Initialize a pointer at the beginning of the array.
        int right = arr.length - 1; // Initialize a pointer at the end of the array.

        while (left <= right) {
            if (arr[left] < 0 && arr[right] < 0) {
                // If both elements at left and right are negative, move the left pointer to the right.
                left++;
            } else if (arr[left] > 0 && arr[right] > 0) {
                // If both elements at left and right are positive, move the right pointer to the left.
                right--;
            } else if (arr[left] < 0 && arr[right] > 0) {
                // If the element at left is negative and the element at right is positive, swap them.
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            } else {
                // If the element at left is positive and the element at right is negative, move both pointers.
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {-12, 11, -13, -5, 6, -7, 5, -3, -6};
        System.out.println("Input Array: " + Arrays.toString(arr));

        rearrange(arr);

        System.out.println("Output Array: " + Arrays.toString(arr));
    }
}
