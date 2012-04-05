package com.bhatt.ds.sort.bst;

public class Node {
	
	int data;
	Node left;
	Node right;
	
	public Node(int val){
		this.data = val;
	}
	
	public Node(Node node, int val){
		if(data>node.data){
			left.insert(node);
		}else if(data<node.data){
			right.insert(node);
		}
	}
	
	
	public void insert(Node node){
		
	}

}
