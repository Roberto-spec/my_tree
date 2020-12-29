package university;

public class Tree {

    private static class Node {
        int key;
        Object inf;
        Node left;
        Node right;

        /*  public Node(int key)
          {
              this.key=key;
          }
          */
        public Node(int key, Object inf) {
            this.key = key;
            this.inf = inf;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", inf=" + inf +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public void simmectric_check(){

        simmectric(getRoot());
    }
    public void simmectric(Node node){
        if(node.left!=null){
            simmectric(node.left);
        }

        System.out.println(node.key);

        if(node.right!=null){
            simmectric(node.right);
        }

    }
    public void pryamo_check(){

        pryamo(getRoot());
    }
    public void pryamo(Node node){
        System.out.println(node.key);
        if(node.left!=null){
            pryamo(node.left);
        }

        if(node.right!=null){
            pryamo(node.right);
        }

    }
    public void obratno_check(){

        obratno(getRoot());
    }
    public void obratno(Node node){

        if(node.left!=null){
            obratno(node.left);
        }

        if(node.right!=null){
            obratno(node.right);
        }
        System.out.println(node.key);

    }



    public void add(int key, Object inf) {
        if (root == null) {
            root = new Node(key, inf);
        } else {
            Node parent = findNode(root, key);
            if (key < parent.key) {
                parent.left = new Node(key, inf);
            } else {
                parent.right = new Node(key, inf);
            }
        }
    }
    public void delete(int key) {
        root = deleteRecursive(root, key);
    }
    private Node deleteRecursive(Node current, int key) {
        if (current == null) {
            return null;
        }

        if (key == current.key) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child
            if (current.right == null) {
                return current.left;
            }

            if (current.left == null) {
                return current.right;
            }

            // Case 3: 2 children
            int smallestValue = findSmallestValue(current.right);
            current.key = smallestValue;
            current.right = deleteRecursive(current.right, smallestValue);
            return current;
        }
        if (key < current.key) {
            current.left = deleteRecursive(current.left, key);
            return current;
        }

        current.right = deleteRecursive(current.right, key);
        return current;
    }
    private int findSmallestValue(Node root) {
        return root.left == null ? root.key : findSmallestValue(root.left);
    }
    public Node findNode(Node current, int key) {
        if (key < current.key) {
            if (current.left == null) {
                return current;
            } else {
                return findNode(current.left, key);
            }
        } else {
            if (current.right == null) {
                return current;
            } else {
                return findNode(current.right, key);
            }
        }
    }
    public Node find(Node current, int key) {
        if (current!=null && key < current.key) {

                return find(current.left, key);
            }
        else {
            if(current!=null && key>current.key)
            {
                return find(current.right,key);
            }
            else
            {
                return  current;
            }
        }

    }

    public boolean checkKey(int key)
    {
        Node tmp=find(root,key);
        return tmp!=null;
    }
}
