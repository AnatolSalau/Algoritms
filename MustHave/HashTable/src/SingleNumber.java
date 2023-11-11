import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class SingleNumber {
      /**
             Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

             You must implement a solution with a linear runtime complexity and use only constant extra space.

             Example 1:
             Input: nums = [2,2,1]
             Output: 1

             Example 2:
             Input: nums = [4,1,2,1,2]
             Output: 4

             Example 3:
             Input: nums = [1]
             Output: 1
       */

      public static void main(String[] args) {
            int[] nums1 = {2,2,1};
            SingleNumber singleNumber = new SingleNumber();
            System.out.println(singleNumber.getUnRepeatableEl(nums1));
            int[] nums2 = {4,1,2,1,2};
            System.out.println(singleNumber.getUnRepeatableEl(nums2));
      }

      int getUnRepeatableEl(int... arr) {
            HashMap<Integer, Integer> result = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                  Integer number = arr[i];
                  if (result.containsKey(number)) {
                        Integer quantity = result.get(number);
                        quantity++;
                        result.put(number,quantity);
                  } else {
                        result.put(number,1);
                  }
            }
            Set<Map.Entry<Integer, Integer>> entries = result.entrySet();
            for (Map.Entry<Integer, Integer> entry : entries) {
                  Integer value = entry.getValue();
                  if (value <2) {
                        Integer key = entry.getKey();
                        return key;
                  }
            }
            return -99;
      }

}
