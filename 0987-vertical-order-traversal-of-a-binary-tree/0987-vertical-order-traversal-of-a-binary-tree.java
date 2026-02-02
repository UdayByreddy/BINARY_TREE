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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(root,0,0));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            TreeNode temp = p.node;
            int x = p.vertical;
            int y = p.level;
            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y,new PriorityQueue<Integer>());
            map.get(x).get(y).offer(temp.val);
            if(temp.left!=null){
                queue.offer(new Pair(temp.left,x-1,y+1));
            }
            if(temp.right!=null){
                queue.offer(new Pair(temp.right,x+1,y+1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> pq: map.values()){
            List<Integer> arr = new ArrayList<>();
            for(PriorityQueue<Integer> p : pq.values()){
                while(!p.isEmpty())
                  arr.add(p.poll());
            }
            ans.add(arr);
        }
        return ans;
    }
    static class Pair{
        TreeNode node;
        int vertical;
        int level;

        public Pair(TreeNode n,int v, int l){
            this.node =n;
            this.vertical = v;
            this.level = l;
        }
    }
}