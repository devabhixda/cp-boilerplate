public class BinaryTree{
    private TreeNode root;
    
    private class TreeNode{
        private int data;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int data){
            this.data=data;
        }
    }

    public void createBinaryTree(){
        TreeNode first = new TreeNode(1);
        TreeNode second = new TreeNode(2);
        TreeNode third = new TreeNode(3);
        TreeNode fourth = new TreeNode(4);
        TreeNode fifth = new TreeNode(5);
        TreeNode sixth = new TreeNode(6);
        TreeNode seventh = new TreeNode(7);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
        preOrder(root);
        System.out.println();
        inOrder(root);
        System.out.println();
        postOrder(root);
        System.out.println();
    }

    public void inOrder(TreeNode root) {
        if(root==null)
            return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);      
    }

    public void preOrder(TreeNode root) {
        if(root==null)
            return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);      
    }

    public void postOrder(TreeNode root) {
        if(root==null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");      
    }
    public static void main(String args[]) {
        BinaryTree bt = new BinaryTree();
        bt.createBinaryTree();
        //bt.preOrder(root);
    }
}