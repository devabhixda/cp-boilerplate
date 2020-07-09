import java.util.*;
class Tree{
    static class Node{
        Node left, right;
        int data;
        Node(int i) {
            this.data=i;
            this.left=null;
            this.right=null;
        }
    }
    static void preorder(Node curr){
        if(curr!=null){
            System.out.print(curr.data+" ");
            preorder(curr.left);
            preorder(curr.right);
        }
    }
    static void inorder(Node curr){
        if(curr!=null){
            inorder(curr.left);
            System.out.print(curr.data+" ");
            inorder(curr.right);
        }
    }
    static void levelorder(Node curr){
        Queue<Node> q = new LinkedList<>();
        System.out.print(curr.data+" ");
        q.add(curr);
        while(!q.isEmpty()){
            Node next = q.poll();
            if(next.left!=null){
                System.out.print(next.left.data+" ");
                q.add(next.left);
            }
            if(next.right!=null){
                System.out.print(next.right.data+" ");
                q.add(next.right);
            }
        }
    }
    static int count(Node curr){
        int x,y;
        if(curr!=null){
            x=count(curr.left);
            y=count(curr.right);
            if(x>y)
                return x+1;
            else
                return y+1;
        }
        return 0;
    }
    static int countLeaf(Node curr){
        int x,y;
        if(curr!=null){
            x=countLeaf(curr.left);
            y=countLeaf(curr.right);
            if(curr.left==null && curr.right==null)
                return x+y+1;
            else
                return x+y;
        }
        return 0;
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter root");
        int i = scan.nextInt();
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(i);
        q.add(root);
        while(!q.isEmpty()){
            Node curr = q.poll();
            System.out.println("Enter left child of "+curr.data);
            int x = scan.nextInt();
            if(x!=-1) {
                Node t = new Node(x);
                curr.left = t;
                q.add(t);
            }
            System.out.println("Enter right child of "+curr.data);
            int y = scan.nextInt();
            if(y!=-1) {
                Node t = new Node(y);
                curr.right = t;
                q.add(t);
            }
        }
        System.out.print("Preorder traversal-> ");
        preorder(root);
        System.out.println();
        System.out.print("Inorder traversal-> ");
        inorder(root);
        System.out.println();
        System.out.print("Level order traversal-> ");
        levelorder(root);
        System.out.println();
        System.out.println(count(root));
        scan.close();
    }
}