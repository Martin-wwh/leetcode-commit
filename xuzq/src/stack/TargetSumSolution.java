package stack;

public class TargetSumSolution {

    int count = 0;

    public int findTargetSumWays(int[] nums, int S) {

        dfs(nums, 0, S, 0);
        return count;
    }

    public void dfs(int[] nums, int i, int s, int result){
        if ( i == nums.length ){

            if (result == s){
                count++;
            }
            return;
        }
        int num = nums[i];

        dfs(nums, i+1, s, result+num);
        dfs(nums, i+1, s, result-num);

    }


    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        new TargetSumSolution().findTargetSumWays(nums,3);
    }
}
