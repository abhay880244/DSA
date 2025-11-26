package LRUCache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import LRUCache.LRUCacheDesign.LRUCache.Entry;

public class LRUCacheDesign {
	

	public static void main(String[] args) {
		
		
		LRUCache lruCache = new LRUCache(3);
		lruCache.put(1, 2);
		lruCache.put(2, 3);
		lruCache.put(5, 6);
		lruCache.put(7, 8);
		lruCache.put(9, 10);
		System.out.println("lruCache.get(1000) = "+lruCache.get(1000));
		lruCache.put(11, 12);
		System.out.println("lruCache.get(7) = "+lruCache.get(7));
		System.out.println(lruCache);
	}
	public static class LRUCache{
		
	


		@Override
		public String toString() {
			return "LRUCache [maxCacheSize=" + maxCacheSize + ", currentSize=" + currentSize + ", list=" + list
					+ ", map=" + map + "]";
		}


		private int maxCacheSize;
		int currentSize = 0;
		private DoublyLinkedList list;
		private HashMap<Integer,Node> map = new HashMap<Integer,Node>();

		public LRUCache(int size){
			this.maxCacheSize = size;
			list = new DoublyLinkedList();
		}
		
		
		void put(int key , int value) {
		
			if(map.containsKey(key)) {
				
				Node foundNode = map.get(key);
				foundNode.entry.value = value;
				list.remove(foundNode);
				list.addNodeAtFront(foundNode);
			}
			else {
				
				if(currentSize == maxCacheSize) {
					removeLeastRecentlyUsedEntry(list);	
				}
				else {
					currentSize++;
				}
				Entry newEntry = new Entry(key,value);
				Node newNode = new Node(newEntry,null, null);
				list.addNodeAtFront(newNode);
				map.put(newNode.entry.key, newNode);	
				
				
			}
			
			
		}

		private void removeLeastRecentlyUsedEntry(DoublyLinkedList list) {
			Node lruNode = list.removeLastNode();
			map.remove(lruNode.entry.key);			
		}


		int get(int key) {
			if(map.containsKey(key)) {
				Node existingNode = map.get(key);
				list.remove(existingNode);
				list.addNodeAtFront(existingNode);
				return existingNode.entry.value;
			}
			return -1;
		}
		
		
		public class Entry{
			@Override
			public String toString() {
				return "Entry [key=" + key + ", value=" + value + "]";
			}
			public Entry(int key, int value) {
				this.key = key;
				this.value = value;
			}
			int key;
			int value;
		}
	}

}

class Node{
	Node next;
	Node prev;
	Entry entry;
	
	Node(Entry entry, Node next, Node prev){
		this.entry = entry;
		this.next = next;
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "Node [entry=" + entry + "]";
	}
	
	
}

class DoublyLinkedList{
	Node head;
	Node tail;
	public DoublyLinkedList(){
		head = new Node(null,null,null);
	 	tail = new Node(null,null,null);
		head.next = tail;
		tail.prev = head;
	}
	

	void addNodeAtFront(Node newNode) {
		Node firstNode = head.next;
		firstNode.prev = newNode;
		newNode.next = firstNode;
		newNode.prev = head;
		head.next = newNode;
	}
	
	void remove(Node node) {
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	
	Node removeLastNode() {
		Node lastNode = tail.prev;
		remove(lastNode);
		return lastNode;
	}


	@Override
	public String toString() {
		String nodes = "";
		Node temp = head.next;
		while(temp!= null) {
			if(temp.entry != null) {
				nodes += temp.entry.toString();
			}
			temp= temp.next;
		}
		return nodes;
	}
	
	
	
	
}
