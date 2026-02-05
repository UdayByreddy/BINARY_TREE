/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        Map<TreeNode,TreeNode> map = new HashMap<>();
        mapTheRootNode(root,map);
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> set = new HashSet<>();
        queue.offer(target);
        set.add(target);
        int curr=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            if(curr++==k) break;
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                if(temp.left!=null && !set.contains(temp.left)){
                    queue.offer(temp.left);
                    set.add(temp.left);
                }
                if(temp.right!=null && !set.contains(temp.right)){
                    queue.offer(temp.right);
                    set.add(temp.right);
                }
                if(map.containsKey(temp) && !set.contains(map.get(temp))){
                    set.add(map.get(temp));
                    queue.offer(map.get(temp));
                }
            }
        }
        while(!queue.isEmpty()){
            ans.add(queue.poll().val);
        }
        return ans;
        
    }
    public void mapTheRootNode(TreeNode root,Map<TreeNode,TreeNode> map){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size= queue.size();
            for(int i=0;i<size;i++){
                TreeNode temp = queue.poll();
                if(temp.left!=null){
                    map.put(temp.left,temp);
                    queue.offer(temp.left);
                }
                if(temp.right!=null){
                    map.put(temp.right,temp);
                    queue.offer(temp.right);
                }
            }
        }
    }

}