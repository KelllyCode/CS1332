import java.util.ArrayList;
	import java.util.HashSet;
	import java.util.List;
	

class leetcode461Solution {
    private List<List<Integer>> ans;
    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return ans;
    }
    private void dfs(int[] nums, int start, List<Integer> path) {
        // 只要長度大於等於 2，就立刻存起來！
        if (path.size() >= 2) {
            ans.add(new ArrayList<>(path));
        }

        // 用於記錄當前這一層（橫向遍歷）已經使用過的數字
        HashSet<Integer> used = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            // 去重：如果當前數字在這一層已經用過，則跳過
            if (used.contains(nums[i])) {
                continue;
            }

            // 非遞減條件：path 為空，那任何數字都可以作為子序列的開頭，如果 path 已經有數字，當前準備加入的數字 nums[i] 必須大於或等於 path 的最後一個數字，確保序列是「非遞減」的
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                used.add(nums[i]);              // 標記為已使用
                path.add(nums[i]);              // 做出選擇
                dfs(nums, i + 1, path);         // 遞迴下一層，去挑選下一個更後面的數字。
                path.remove(path.size() - 1);   // 回溯，撤銷選擇
            }
        }
    }

}


