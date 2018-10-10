/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*Time complexity : O(h*2^h)
We need to fill the resres array of size hx2^h - 1
Here, h refers to the height of the given tree.
Space complexity : O(h*2^h) 
res array of size hx2^h - 1 is used.
*/
public class Solution {
    class Params {
        Params(TreeNode n, int ii, int ll, int rr) {
            root = n;
            i = ii;
            l = ll;
            r = rr;
        }
        TreeNode root;
        int i, l, r;
    }
    public List < List < String >> printTree(TreeNode root) {
        int height = getHeight(root);
        System.out.println(height);
        String[][] res = new String[height][(int)(Math.pow(2, height)) - 1];
        for (String[] arr: res)
            Arrays.fill(arr, "");
        List < List < String >> ans = new ArrayList < > ();
        fill(res, root, 0, 0, res[0].length);
        for (String[] arr: res)
            ans.add(Arrays.asList(arr));
        return ans;
    }
    public void fill(String[][] res, TreeNode root, int i, int l, int r) {
        Queue < Params > queue = new LinkedList();
        queue.add(new Params(root, 0, 0, res[0].length));
        while (!queue.isEmpty()) {
            Params p = queue.remove();
            res[p.i][(p.l + p.r) / 2] = "" + p.root.val;
            if (p.root.left != null)
                queue.add(new Params(p.root.left, p.i + 1, p.l, (p.l + p.r) / 2));
            if (p.root.right != null)
                queue.add(new Params(p.root.right, p.i + 1, (p.l + p.r + 1) / 2, p.r));
        }
    }
    public int getHeight(TreeNode root) {
        Queue < TreeNode > queue = new LinkedList();
        queue.add(root);
        int height = 0;
        while (!queue.isEmpty()) {
            height++;
            Queue < TreeNode > temp = new LinkedList();
            while (!queue.isEmpty()) {
                TreeNode node = queue.remove();
                if (node.left != null)
                    temp.add(node.left);
                if (node.right != null)
                    temp.add(node.right);
            }
            queue = temp;
        }
        return height;
    }
}