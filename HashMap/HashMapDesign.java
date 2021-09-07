package HashMap;

import java.util.Arrays;
import java.util.LinkedList;

public class HashMapDesign {
	
	
	public static void main(String[] args) {
		
		HashMap hashMap = new HashMap(10);
		
		hashMap.put(1,2);
		hashMap.put(2,3);
		hashMap.put(3,4);
		hashMap.put(4,5);
		hashMap.put(5,6);
		hashMap.put(1,100);
		hashMap.put(11,101);
		
		System.out.println(hashMap);
		
		
	}
	
	
	static public class HashMap{
		@Override
		public String toString() {
			return "HashMap [hashMap=" + Arrays.toString(hashMap) + "]";
		}

		LinkedList<Entry>[] hashMap;

		public HashMap(int size) {
			this.hashMap = new LinkedList[size];
		}
		
		public void put(int key ,int value){
			int bucket = getBucket(key);
			LinkedList<Entry> entries = hashMap[bucket];
			if(entries == null) {
				hashMap[bucket] = new LinkedList();
				hashMap[bucket].add(new Entry(key,value));
			}
			else {
				for(Entry entry : entries) {
					if(entry.key == key) {
						entry.value = value;
						return;
					}
				}
				entries.add(new Entry(key,value));
			}
			
		}
		
		private int getBucket(int key) {
			return key % hashMap.length;
			
		}

		public int get(int key){
			int bucket = getBucket(key);
			LinkedList<Entry> entries = hashMap[bucket];
			for(Entry entry : entries) {
				if(entry.key == key) {
					return entry.value;
				}
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
