class AVL {
    static class Node{
        Node left, right;
        int data, height;
        Node(int i) {
            this.data=i;
        }
    }
    static Node root = null;
    // Insertion 
    static Node insert(Node curr, int data){
        if(curr==null){
            Node t1 = new Node(data);
            t1.height=0;
            t1.left=null;
            t1.right=null;
            return t1;
        }
        if(data<curr.data){
            curr.left=insert(curr.left, data);
        } else if(data>curr.data){
            curr.right=insert(curr.right, data);
        }
        curr.height=NodeHeight(curr);
        if(BalanceFactor(curr)==2 && BalanceFactor(curr.left)==1){
            return LLRotation(curr);
        } else if(BalanceFactor(curr)==2 && BalanceFactor(curr.left)==-1){
            return LRRotation(curr);
        } else if(BalanceFactor(curr)==-2 && BalanceFactor(curr.right)==-1){
            return RRRotation(curr);
        } else if(BalanceFactor(curr)==-2 && BalanceFactor(curr.right)==1){
            return RLRotation(curr);
        }
        return curr;
    }
    //Heights 
    static int NodeHeight(Node curr){
        int hl, hr;
        hl = (curr!=null && curr.left!=null) ? curr.left.height : 0;
        hr = (curr!=null && curr.right!=null) ? curr.right.height : 0;
        return hl > hr ? hl : hr;
    }
    static int BalanceFactor(Node curr){
        int hl, hr;
        hl = (curr!=null && curr.left!=null) ? curr.left.height : 0;
        hr = (curr!=null && curr.right!=null) ? curr.right.height : 0;
        return hl-hr;
    }
    static int Height(Node curr){
        int x,y;
        if(curr==null)
            return 0;
        x=Height(curr.left);
        y=Height(curr.right);
        return x>y ? x+1 : y+1;
    }
    //Rotations
    static Node LLRotation(Node curr){
        Node t1 = curr.left;
        Node t2 = t1.right;
        t1.right = curr;
        curr.left = t2; 
        curr.height=NodeHeight(curr);
        t1.height=NodeHeight(t1);
        if(root==curr)
            root=t1;
        return t1;
    }
    static Node RRRotation(Node curr){
        Node t1 = curr.right;
        Node t2 = t1.left;
        t1.left = curr;
        curr.right = t2; 
        curr.height=NodeHeight(curr);
        t1.height=NodeHeight(t1);
        if(root==curr)
            root=t1;
        return t1;
    }
    static Node LRRotation(Node curr){
        Node t1 = curr.left;
        Node t2 = t1.right;
        t1.right = t2.left;
        curr.left = t2.right;
        t2.left = t1;
        t2.right = curr;
        curr.height=NodeHeight(curr);
        t1.height=NodeHeight(t1);
        t2.height=NodeHeight(t2);
        if(root==curr)
            root=t2;
        return t2;
    }
    static Node RLRotation(Node curr){
        Node t1 = curr.right;
        Node t2 = t1.left;
        t1.left = t2.right;
        curr.right = t2.left;
        t2.right = t1;
        t2.left = curr;
        curr.height=NodeHeight(curr);
        t1.height=NodeHeight(t1);
        t2.height=NodeHeight(t2);
        if(root==curr)
            root=t2;
        return t2;
    }
    // Traversals
    static void inorder(Node curr){
        if(curr!=null){
            inorder(curr.left);
            System.out.print(curr.data+" ");
            inorder(curr.right);
        }
    }
    static void preorder(Node curr){
        if(curr!=null){
            System.out.print(curr.data+" ");
            preorder(curr.left);
            preorder(curr.right);
        }
    }
    static void postorder(Node curr){
        if(curr!=null){
            postorder(curr.left);
            postorder(curr.right);
            System.out.print(curr.data+" ");
        }
    }
    public static void main(String[] args) {
        root = insert(root, 10);
        insert(root, 20);
        insert(root, 30);
        System.out.println(Height(root));
    }
}