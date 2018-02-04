package sort;

public class RemoveDuplicatesInSortedArray {
    /**
     * required: return n is the length of non-duplicates and also the nums
     * should be in-place removed duplicates
     * 
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 2)
            return n;
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[count - 1]) {
                nums[count++] = nums[i];
            }
        }
        printNums(nums, count);
        return count;
    }

    private static void printNums(int[] nums, int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 4, 4, 5, 6, 6, 6, 7, 7, 8 };
        System.out.println("{ 1, 2, 3, 4, 4, 4, 5, 6, 6, 6, 7, 7, 8 } after removing duplicates should be in length: "
                + removeDuplicates(nums));

    }

}
