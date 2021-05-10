/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


/**
 *
 * @author milan
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("HelloWorld");
        Node<String> a = new Node<>("Alice");
        Node<String> b = new Node<>("Bob");
        Node<String> c = new Node<>("Charles");
        Node<String> d = new Node<>("Denis");
        Node<String> e = new Node<>("Elsa");
        Node<String> f = new Node<>("Figo");
        Node<String> g = new Node<>("Gabriel");
        Node<String> h = new Node<>("Hugo");
        Node<String> i = new Node<>("Irina");
        
        a.setLeftChild(b);
        a.setRightChild(c);
        breadthFirst(a);
        System.out.println("\n\n");
        
        c.setLeftChild(d);
        c.setRightChild(e);
        
        breadthFirst(a);
                System.out.println("\n\n");

        b.setLeftChild(f);
        breadthFirst(a);
        System.out.print("\n\n");
        inOrder(a);
        
    }
    
    public static <T> void inOrder(Node<T> root){
        if(root==null){
            return;
        }
        
        Set<Node<T>> visitedNodes = new HashSet<>();
        Stack<Node<T>> stack =  new Stack<>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
        
            Node<T> top = stack.pop();
            
            if(top.getLeftChild()==null && top.getRightChild()==null){
                System.out.print(top +" --> ");
            }else if(visitedNodes.contains(top)){
                System.out.print(top+" --> ");
            }else{
                visitedNodes.add(top);
                
                if(top.getRightChild()!=null){
                    stack.push(top.getRightChild());
                }
                
                stack.push(top);
                
                if(top.getLeftChild()!=null){
                    stack.push(top.getLeftChild());
                }
            
            }
            
        }
        
    
    }
    
    public static <T> void breadthFirst(Node<T> root){
        if(root==null)
            return;
    
        Queue<Pair<Node<T>,Integer>> queue =  new LinkedList<>();
        int level =0;
        queue.add(new Pair<>(root,level));
        
        while(!queue.isEmpty()){
            Pair<Node<T>,Integer> pair  = queue.remove();
            
            System.out.print(pair +" --> ");
            level =  pair.getValue() +1;
            
            Node<T> leftChild = pair.getKey().getLeftChild();
            if(leftChild!=null)
                queue.add(new Pair<>(leftChild,level));
            Node<T> rightChild = pair.getKey().getRightChild();
            if(rightChild!=null)
                queue.add(new Pair<>(rightChild,level));
        
        }
        
    }
    
}
