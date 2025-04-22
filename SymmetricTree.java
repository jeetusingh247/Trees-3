// for palindromic check to work we have to add null
// if we put same element together we need to check only the adjacent element
// we don't add the root, directly add root.left and root.right

// Time Complexity : O(n)
// Space Complexity : O(n)

class Solution {
    boolean flag;
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {

        if(left == null && right == null) return true;
        if(left == null || right == null) {
            return false;
        }

        if(left.val != right.val) {
            return false;
        }

        if(helper(left.left, right.right) == false) return false;

        return helper(left.right, right.left);
    }
}