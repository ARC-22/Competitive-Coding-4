// Time Complexity : O(n)
// Space Complexity : O(n) // worst case for skew tree
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//recursively calculate height. if left and right difference is greater than 1 return false. 
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }
        
        int res = balanced(root);
        if(res == -1){
            return false;
        }
        else{
            return true;
        }
    }
    private int balanced(TreeNode root){
        //base
        if(root == null){
            return 0;
        }

        //logic
        int lHeight = balanced(root.left);
        if(lHeight == -1)
            return -1;

        int rHeight = balanced(root.right);
        if(rHeight == -1)
            return -1;

        if( Math.abs(lHeight - rHeight) > 1)
            return -1;

       return 1 + Math.max(lHeight, rHeight);
    }
}