package utils;

//This code is contributed by Amit Das(amit_das)

//https://www.geeksforgeeks.org/introduction-to-merkle-tree/
import java.util.ArrayList;

public class MerkleTreeHashing {
    private final int maximum = 10; //maximum capacity of Hash tree

    private int size = 0;

    private static class Node {
        private int key;
        private int value;
        private Node leftNode;
        private Node rightNode;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getLeftNode() {
            return leftNode;
        }

        public void setLeftNode(Node leftNode) {
            this.leftNode = leftNode;
        }

        public Node getRightNode() {
            return rightNode;
        }

        public void setRightNode(Node rightNode) {
            this.rightNode = rightNode;
        }
    }

    private static class BST{
        Node head;

        public Node getHead() {
            return head;
        }

        public void setHead(Node head) {
            this.head = head;
        }
    }

    int hashCode(int key){
        return (key % maximum);
    }

    void add(int key, int value){
        int index = hashCode(key);

        /* extracting Binary Tree at the given index */
        Node tree = arr.get(index).head;

        /* creating an item to insert in the hashTree */
        Node new_item = new Node();
        new_item.key = key;
        new_item.value = value;
        new_item.leftNode = null;
        new_item.rightNode = null;

        if (tree == null){
            /* absence of Binary Tree at a given index of Hash Tree */
            System.out.println("Inserting "+key+" and "+value);

            arr.get(key).head = new_item;
            size++;
        }

        else {

    /* a Binary Tree is present at given index
       of Hash Tree */
            Node temp = find(tree,key);
            if (temp==null){
                /*
                 * Key not found in existing Binary Tree
                 * Adding the key in existing Binary Tree
                 */
                System.out.println("Inserting "+key+" and "+value);
                insert_element(tree,new_item);
                size++;
            }

            else {
                /*
                 * Key already present in existing Binary Tree
                 * Updating the value of already existing key
                 */
                temp.value = value;
            }
        }
    }

    /*
     * this function finds the given key in the Binary Tree
     * returns the node containing the key
     * returns NULL in case key is not present
     */
    Node find(Node tree, int key){
        if (tree == null){
            return null;
        }
        if (tree.key == key){
            return tree;
        }
        else if (key < tree.key){
            return find(tree.leftNode,key);
        }
        else{
            return find(tree.rightNode, key);
        }
    }



    ArrayList<BST> arr = new ArrayList<>();


/* this function inserts the newly created node
   in the existing Binary Tree */

    void insert_element(Node tree, Node item){
        if (item.key < tree.key){
            if (tree.leftNode == null){
                tree.leftNode = item;
            }else{
                insert_element(tree.leftNode,item);
            }
        }else if (item.key > tree.key){
            if (tree.rightNode == null){
                tree.rightNode = item;
            }else {
                insert_element(tree.rightNode, item);
            }
        }
    }

    /* displays the content of hash Tree */
    void display(){
        int i=0;
        for (i=0;i<maximum;i++){
            Node tree = arr.get(i).head;
            if (tree == null){
                System.out.println("Array "+i+" has no elements");
            }else {
                System.out.println("Array "+i + " has elements");
                display_tree(tree);
            }
        }
    }

    /* displays content of binary tree of
particular index */
    void display_tree(Node tree){
        if (tree == null){
            return ;
        }

        System.out.println(tree.key +" and "+tree.value);

        if (tree.leftNode != null){
            display_tree(tree.leftNode);
        }

        if (tree.rightNode != null){
            display_tree(tree.rightNode);
        }
    }

    void init(){
        for (int i=0;i<maximum;i++){
            arr.get(i).head = null;
        }
    }

    /* returns the size of hash Tree */
    int size_of_hash_tree(){
        return size;
    }

    void del(int key){
        int index = hashCode(key);

        Node tree = arr.get(index).head;

        if (tree == null){
            System.out.println(key+" Key not present");
        }else {
            Node temp = find(tree, key);
            if (temp ==null){
                System.out.println(key + " is not present");
            }else {
                tree = remove_element(tree,key);
                System.out.println(key+" Key has been removed from the hash tree");
            }
        }
    }

    Node remove_element(Node tree, int key){
        if (tree == null){
            return null;
        }
        if (key < tree.key){
            tree.leftNode = remove_element(tree.leftNode,key);
            return tree;
        }
        else if (key > tree.key){
            tree.rightNode = remove_element(tree.rightNode,key);
            return tree;
        }
        else {
            //reached the node
            if (tree.leftNode == null && tree.rightNode == null){
                size--;
                return null;
            }
            else if (tree.leftNode != null && tree.rightNode == null){
                size--;
                return tree.leftNode;
            }
            else if (tree.leftNode == null){
                size--;
                return tree.rightNode;
            }
            else {
                Node left_one = tree.leftNode;

                while (left_one.rightNode != null){
                    left_one = left_one.rightNode;
                }

                tree.key =left_one.key;
                tree.value = left_one.value;
                tree.leftNode = remove_element(tree.leftNode,tree.key);
                return tree;
            }
        }
    }

}
