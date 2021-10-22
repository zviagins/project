package LeetCode;

import java.util.*;
import java.util.stream.Collectors;

class Solution {

    static Set<Integer> goodDigits = new HashSet<>(Arrays.asList(2,5,6,9));

    public int rotatedDigits(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++){
            if (goodInteger(i)){
                sum++;
            }
        }
        return sum;
    }

    public boolean goodInteger(int n){
        while (n > 0) {
            if (!goodDigits.contains(n % 10))
                return false;
            n = n / 10;
        }
        return true;
    }

    public boolean canJump(int[] nums) {
        int[] canDoIt = new int[nums.length]; //0 - can not do it from that index. 1 - didn't check. 2 - can do it!
        for (int i=0; i< nums.length; i++){
            canDoIt[i] = 1;
        }
        return canJump(nums, 0, canDoIt);
    }

    private boolean canJump(int[] nums, int index, int[] canDoIt){
        if (index >= nums.length - 1 || canDoIt[index] == 2) {
            return true;
        }
        if (nums[index] == 0 || canDoIt[index] == 0) {
            return false;
        }
        int i = 1;
        while (i <= nums[index] && canDoIt[index] == 1){
            if (canJump(nums, index + i, canDoIt)) {
                canDoIt[index] = 2;
                return true;
            }
            i++;
        }
        canDoIt[index] = 0;
        return false;
    }


     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = addTwoNumbers(l1, l2, 0);
        return head;
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int cary) {
        if (l1 == null && l2 == null){
            if (cary > 0) {
                return new ListNode(1);
            }
            else {
                return null;
            }
        }
        ListNode sum = new ListNode();
        if (l1 == null){
            int newSum = l2.val + cary;
            int newCary = 0;
            if (newSum > 9) {
                newCary = 1;
                newSum = newSum % 10;
            }
            sum.val = newSum;
            sum.next = addTwoNumbers(l1, l2.next, newCary);
            return sum;
        }
        if (l2 == null){
            int newSum = l1.val + cary;
            int newCary = 0;
            if (newSum > 9) {
                newCary = 1;
                newSum = newSum % 10;
            }
            sum.val = newSum;
            sum.next = addTwoNumbers(l1.next, l2, newCary);
            return sum;
        }
        int newSum = l1.val + l2.val + cary;
        int newCary = 0;
        if (newSum > 9){
            newCary = 1;
            newSum = newSum % 10;
        }
        sum.val = newSum;
        sum.next = addTwoNumbers(l1.next, l2.next, newCary);
        return sum;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public int minDeletions(String s) {
        int retVal = 0;
        Map<Character, Integer> charCount = new HashMap<>();
        List<Character> charList = s.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        for (Character c : charList){
            if (!charCount.containsKey(c))
                charCount.put(c,0);
            charCount.put(c, charCount.get(c) + 1);
        }
        Set<Integer> indexes = new HashSet<>();
        for(Map.Entry<Character, Integer> entry : charCount.entrySet()){
            Integer tmp = entry.getValue();
            while (indexes.contains(tmp) && tmp > 0) {
                tmp--;
                retVal++;
            }
            if (tmp > 0)
                indexes.add(tmp);
        }
        return retVal;
    }

    public int solution(int[] A) {
        int tryOdd = 0;
        int tryEven = 0;
        for (int i = 0; i<A.length; i++ ){
            if (i % 2 == 0) {
                if (A[i] != 0){
                    tryOdd++;
                }
                else {
                    tryEven++;
                }
            }
            else {
                if (A[i] != 1){
                    tryOdd++;
                }
                else {
                    tryEven++;
                }
            }
        }
        return Math.min(tryEven, tryOdd);
    }

    public int solution(String S, int[] C) {
        int cost = 0;
        char[] chars = S.toCharArray();
        for (int i = 0; i<C.length-1; i++){
            if (chars[i] == chars[i+1]){
                cost = cost + Math.min(C[i], C[i+1]);
            }
        }
        return cost;
    }

    public int solution(String S) {
        int steps = 0, start = 0;
        boolean substractOne = false;
        char[] chars = S.toCharArray();
        while (start < chars.length){
            if (chars[start] == '1')
                break;
            start++;
        }
        for (int i = start; i< chars.length; i++){
            if (chars[i] == '0') {
                steps = steps + 1;
            }
            else {
                steps = steps + 2;
                substractOne = true;
            }
        }
        if (substractOne) {
            steps = steps - 1; // when the result is one needed just one last step, hence substract 1
        }
        return steps;
    }

    public static void  main(String[] args){
        System.out.println("Hello .. ");
        Solution s = new Solution();

        /*int[] grid = {23,2,9,7,8,6};
        int[] result = s.sortArrayByParityII(grid);
        for (int i =0; i<result.length; i++){
            System.out.println(result[i]);
        }
        System.out.println(s.rotatedDigits(857));
        }

        int[] nums = {2,3,1,1,4};
        System.out.println(s.canJump(nums));

        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode result = s.addTwoNumbers(l1, l2);
        while (result != null){
            System.out.print(result.val);
            result = result.next;
        }
        System.out.print(s.minDeletions("abcdefg"));
        */

        //System.out.print(s.solution(new int[]{1,1,0,1,1}));
        //System.out.print(s.solution("ababa", new int[]{3,4,5,6,7}));
        System.out.println(s.solution("1111010101111"));
    }
}