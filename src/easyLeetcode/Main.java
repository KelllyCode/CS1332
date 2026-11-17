import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	//LC1
    	/*
    	leetcode1Solution solution = new leetcode1Solution();
    	int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("test: " + Arrays.toString(result1));
        */
    	
    	//LC392
    	leetcode392Solution solution = new leetcode392Solution();
    	String s = "abc";
    	String t = "ahbgdc";
    	boolean result = solution.isSubsequence(s,t);
    	System.out.println("Output: " + result);
    	
        //LC491
        /*
        leetcode461Solution solution = new leetcode461Solution();
    	int[] testInput = {4, 6, 7, 7};
    	List<List<Integer>> result = solution.findSubsequences(testInput);
        System.out.println("Input: [4, 6, 7, 7]");
        System.out.println("Output: " + result);
        */
        
    }
}