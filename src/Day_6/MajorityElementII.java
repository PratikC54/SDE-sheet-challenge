package Day_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> answer = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        int min = (nums.length/3)+1;

        for (int num : nums) {
            int value = map.getOrDefault(num, 0);
            map.put(num, value+1);
            if (map.get(num) == min) answer.add(num);
        }

        return answer;
    }
      void main() {
        int[] nums = {1,2};
          System.out.println(majorityElement(nums));

    }
}
