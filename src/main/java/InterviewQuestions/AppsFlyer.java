package InterviewQuestions;

import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

example 1
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

example 2
Input: nums = [24,17,-9,10,-8]
Output: [[17,-9,-8]]

example 3
Input: nums = [-1, 0, 1, 2, -1, -4, -2, -3, 3, 0, 4]
Output: [[-3, -1, 4], [-2, -1, 3], [-1, -1, 2], [-4, 1, 3], [-3, 1, 2], [-4, 0, 4], [-3, 0, 3], [-2, 0, 2], [-1, 0, 1]]
*/

class AppsFlyer {

    public Set<Triple> findThree(int[] nums){
        Set<Triple> result = new HashSet<>();
        for (int i=0; i<nums.length - 2; i++){
            Set<Triple> tList = findTwo(nums, 0 - nums[i], i+1);
            if (tList != null){
                for (Triple t : tList) {
                    t.setThird(nums[i]);
                    result.add(t);
                }
            }
        }
        return result;
    }

    private Set<Triple> findTwo(int nums[], int sum, int indexToIgnore){
        Set<Integer> set = new HashSet<>();
        Set<Triple> resultForTwo = new HashSet<>();
        for (int i=indexToIgnore; i<nums.length; i++){
            if (set.contains(sum - nums[i])) {
                Triple t = new Triple(sum - nums[i], nums[i]);
                resultForTwo.add(t);
            }
            set.add(nums[i]);
        }
        return resultForTwo;
    }


    public static void main(String[] args) {
        AppsFlyer s = new AppsFlyer();
        Set<Triple> result = s.findThree(new int[]{-1,0,1,2,-1,-4});
        for (Triple t : result){
            System.out.println(t);
        }

    }

    class Triple {
        Set<Integer> tripleSet = new HashSet<>();
        int i;
        int j;
        int k;

        public Triple(int i, int j) { // findTwo
            this.i = i;
            this.j = j;
            tripleSet.add(i);
            tripleSet.add(j);
        }

        public Triple(int i, int j, int k) {
            this.i = i;
            this.j = j;
            this.k = k;
        }

        public void setThird(int k){
            this.k = k;
            tripleSet.add(k);
        }

        @Override
        public String toString() {
            return i + " " + j + " " + k + " ";
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Triple t = (Triple) o;
            return tripleSet.contains(t.i) &&
                    tripleSet.contains(t.j) &&
                    tripleSet.contains(t.k);
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, k);
        }
    }
}
