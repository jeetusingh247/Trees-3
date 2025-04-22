// we have to give different refrences to have correct result
// in soln we are creating new reference everytime
// backtracking is optimal to solve 

// Time : O(n)
// Space : O(h) + O(h)

import java.util.*;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        this.result = new ArrayList<>();
        helper(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void helper(TreeNode root, int targetSum, int currSum, List<Integer> path){
        // base case

        if(root == null) return;

        // ACTION
        currSum += root.val;
        path.add(root.val);

        if(root.left == null && root.right == null) {
            if(currSum == targetSum) {
                // System.out.println(path);
                result.add(new ArrayList<>(path));
                // System.out.println(result);
            }
        }

        // RECURSE
        helper(root.left, targetSum, currSum, path);
        helper(root.right, targetSum, currSum, path);

        // BACKTRACKING
        path.remove(path.size()-1);
    }
}