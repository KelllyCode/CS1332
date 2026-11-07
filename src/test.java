
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
	
	/**
     * 計算數組中遞增子序列的總數（包含空序列）
     * 時間複雜度: O(n^2)
     * 空間複雜度: O(n)
     */
    public static long countIncreasingSubsequences(int[] A) {
        int n = A.length;
        if (n == 0) return 1; // 只有空序列

        // dp[i] 表示以 A[i] 結尾的非空遞增子序列的數量
        long[] dp = new long[n];
        
              
        // 初始狀態：每個元素本身都算一個長度為 1 的子序列
        Arrays.fill(dp, 1);

        long totalNonEmpty = 0;

        // 狀態轉移
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i]) {
                    dp[i] += dp[j];
                }
            }
            totalNonEmpty += dp[i];
            
        }

        // 總數 = 所有非空子序列數量 + 1 (空序列)
        return totalNonEmpty + 1;
    }
    
    /**
     * 加分挑戰：印出所有遞增子序列（使用 DFS 回溯法）
     */
    public static void printAllIncreasingSubsequences(int[] A) {
        System.out.println("--- 所有遞增子序列 ---");
        List<Integer> current = new ArrayList<>();
        // 印出空序列
        System.out.println("[]"); 
        generateSubsequences(A, 0, current);
        System.out.println("----------------------");
    }
    
    private static void generateSubsequences(int[] A, int index, List<Integer> current) {
        for (int i = index; i < A.length; i++) {
            // 如果當前列表為空，或者當前元素大於列表的最後一個元素，則可以加入
            if (current.isEmpty() || A[i] > current.get(current.size() - 1)) {
                current.add(A[i]);
                System.out.println(current); // 印出當前找到的遞增子序列
                
                // 遞迴尋找下一個元素
                generateSubsequences(A, i + 1, current);
                
                // 回溯（移除最後一個元素）
                current.remove(current.size() - 1);
            }
        }
    }


	public static void main(String[] args) {
		int[] A = {1, 7, 3, 5};
        
        // 1. 計算數量
        long totalCount = countIncreasingSubsequences(A);
        System.out.println("數組 " + Arrays.toString(A) + " 的遞增子序列總數為: " + totalCount);
        
        // 2. 印出所有子序列
        printAllIncreasingSubsequences(A);
	}

}
