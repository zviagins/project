package InterviewQuestions;

import java.util.HashMap;
import java.util.Map;

public class Sunbit {

    public static int[] findTarget(int[] nums, int target, int ignoreFromIndex){
        Map<Integer, Integer> numsMap = new HashMap<>();
        for (int i=ignoreFromIndex+1; i<nums.length; i++){
            int num = nums[i];
            if (numsMap.containsKey(target - num))
                return new int[]{i, numsMap.get(target - num)};
            numsMap.put(num, i);
        }
        return new int[]{};
    }

    public static void main(String[] args){
        int[] result = findTarget3(new int[]{1,2,3,4,5,6,7,8}, 14);
        if (result.length > 0)
            System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }

    public static int[] findTarget3(int[] nums, int target){
        int[] result = new int[3];
        for (int i = 0; i< nums.length; i++){
            int[] subResult = findTarget(nums, target - nums[i], i);
            if (subResult.length > 0){
                result[0] = subResult[0];
                result[1] = subResult[1];
                result[2] = i;
            }
        }
        return result;
    }
}
