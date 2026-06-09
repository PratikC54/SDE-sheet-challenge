package Day_5;

import java.util.Arrays;

public class MajorityElementI {
    public static int majority(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majority(nums));
    }
}
