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
    public int widthOfBinaryTree(TreeNode root) {
        int maxWidth =0;
        if(root==null) return maxWidth;

        Queue<Pair> queue = new LinkedList<>();

        queue.offer(new Pair(root,0));
        while(!queue.isEmpty()){
            int size = queue.size();
            int startAt = queue.peek().index;
            int index=0;
            for(int i=0;i<size;i++){
                Pair p = queue.poll();
                TreeNode curr = p.node;
                index = p.index;
                if(curr.left!=null) queue.add(new Pair(curr.left,2*index+1));
                if(curr.right!=null) queue.add(new Pair(curr.right,2*index+2));

            }
            maxWidth = Math.max(maxWidth,index-startAt+1);
        }
        return maxWidth;
        
    }
    static class Pair{
        TreeNode node;
        int index;
        public Pair(TreeNode n,int i){
            this.node = n;
            this.index = i;
        }
    }
}