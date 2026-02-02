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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        rightSide(root,ans,0);
        return ans;
    }
    public void rightSide(TreeNode root,List<Integer> ans,int curr){
        if(root==null) return ;
        if(ans.size()==curr){
            ans.add(root.val);
        }
        rightSide(root.right,ans,curr+1);
        rightSide(root.left,ans,curr+1);
    }
}