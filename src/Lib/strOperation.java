package Lib;

import Lib.strOperation.Node;

public class strOperation {


		class Node
		{
			int data;
			String character;
			Node next = null;	
			
			Node(int data)
			{
				this.data = data;
			}
			Node(String character)
			{
				this.character = character;
			}
		}
		
		Node first = null;
		
		public void insertFirstd(int data)
		{
			Node node = new Node(data);
			node.next = first;
			first = node;
		}

		public void insertFirstc(String character)
		{
			Node node = new Node(character);
			node.next = first;
			first = node;
		}
	

}
