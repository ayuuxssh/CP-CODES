package ayush.Graph;
import java.util.*;
//DFS TRAVERSAL OF TREES
public class DFS {
    //Root left rightt
    public void preorder ()
    {
        preorder(root);
    }
    private void preorder(Node node)
    {
        if(node == null)
        {
            return;
        }
        System.out.println(node.value);
        preorder(node.left);
        preorder(node.right);
    }
    //Left Root right
    public void inorder()
    {
        inorder(root);
    }
    private void inorder(Node node)
    {
        if(node == null)
        {
            return;
        }
        inorder(node.left);
        System.out.println(node.value);
        inorder(node.right);
    }
    Left right root
    public void postorder()
    {
        postorder(root);
    }
    private void postorder(Node node)
    {
        if(node == null)
        {
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.value);
    }
}
//BFS TRAVERSAL
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root==null)
            {
                return result;
            }
            Queue <TreeNode> queue= new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty())
            {
                int level = queue.size();
                List<Integer> ans = new ArrayList<>(level);
                for(int i =0;i<level;i++)
                {
                    TreeNode current  = queue.poll();
                    ans.add(current.val);
                    if(current.left!=null)
                    {
                        queue.offer(current.left);
                    }
                    if(current.right!=null)
                    {
                        queue.offer(current.right);
                    }
                }
                result.add(ans);
            }
            return result;
        }
    public static void main(String[] args) {

    }
}
