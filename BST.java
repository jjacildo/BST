// The BST class that represents binary search trees
// Your name here

import java.util.*;

public class BST 
{
    // instance variables
    private BSTNode m_root;
    private int m_size;
    
    // constructor
    public BST()
    {
        m_root = null;
        m_size = 0;
    }
    
    // add a value into the tree
    public void add(int v)
    {
        // TODO: implement this method using a non-recursive solution
        BSTNode newNode = new BSTNode(v);
        //check if tree is empty, if it is empty add value as root of tree.
        if(m_root == null){
            m_root = newNode;
            m_size++;
        }
        else{
            BSTNode parent = m_root;
            BSTNode child = m_root;
            //loop that will traverse through the tree
            while (child != null){
               parent = child;
               
               if (v < child.getInfo())
                  child = child.getLeft();
               else if (v > child.getInfo())
                  child = child.getRight();
               else
                  break;
            }
            //adds value into the BST
            if (v < parent.getInfo()){
               parent.setLeft(newNode);
               m_size++;
            }
            else if (v > parent.getInfo()){
               parent.setRight(newNode);
               m_size++;
            }
            else
               return;
            
               
        }
    }
    
    // print the tree content using in-order traveral
    public void inOrder()
    {    
        // TODO: implement this method using a non-recursive solution
        //check if tree is empty
        if(m_root == null)
            System.out.println("The tree is empty");
        else{
            Stack<BSTNode> mystack = new Stack<BSTNode>(); //create a stack to preserve order and enable to traverse the tree from left to root to right
            
            BSTNode crawler = m_root; //create a node that will traverse the tree, initialize it to the root of the tree
            
            while(!mystack.empty() || crawler != null){
               if(crawler != null){
                  mystack.push(crawler);//push current node into the stack
                  crawler = crawler.getLeft();
               }
               else{
                  BSTNode newNode = mystack.pop(); //create a new node for the last node pushed into the stack 
                  System.out.print(newNode.getInfo() + " ");
                  crawler = newNode.getRight();
               }            
            }              
        }
    }
    
    // get the size of the tree
    public int size()
    {
        return m_size;
    }
    
    // empty the tree
    public void clear()
    {
        m_root = null;
        m_size = 0;
    }
}
