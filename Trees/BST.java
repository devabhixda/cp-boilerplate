class BST {
    static class Node{
        Node left, right;
        int data;
        Node(int i) {
            this.data=i;
        }
    }
    static Node root = null;
    // Insert 
    static Node insert(Node curr, int data){
        if(curr==null){
            Node temp = new Node(data);
            temp.left=null;
            temp.right=null;
            return temp;
        }
        if(data<curr.data){
            curr.left=insert(curr.left, data);
        } else if(data>curr.data){
            curr.right=insert(curr.right, data);
        }
        return curr;
    }
    // Search
    static Node search(Node curr, int data){            
        if(curr!=null) {
            if(data==curr.data)
                return curr;
            if(data<curr.data)
                return search(curr.left, data);
            if(data>curr.data)
                return search(curr.right, data);
        }
        return null;
    }
    //Deletion 
    static Node delete(Node curr, int data){
        if(curr==null)
            return null;
        if(curr.left==null && curr.right==null){
            if(curr==root)
                root=null;
            return null;
        }
        if(data<curr.data)
            curr.left = delete(curr.left, data);
        else if(data>curr.data)
            curr.right = delete(curr.right, data);
        else {
            if(Height(curr.left)>Height(curr.right)) {
                Node q = inPre(curr.left);
                curr.data = q.data;
                curr.left = delete(curr.left, q.data);
            } else {
                Node q = inSuc(curr.right);
                curr.data = q.data;
                curr.right = delete(curr.right, q.data);
            }
        }
        return curr;
    }
    static int Height(Node curr){
        int x,y;
        if(curr==null)
            return 0;
        x=Height(curr.left);
        y=Height(curr.right);
        return x>y ? x+1 : y+1;
    }
    static Node inPre(Node curr){
        while(curr!=null && curr.right!=null)
            curr=curr.right;
        return curr;
    }
    static Node inSuc(Node curr){
        while(curr!=null && curr.left!=null)
            curr=curr.left;
        return curr;
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
    public static void main(String args[]){

    }
}