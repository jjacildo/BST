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
