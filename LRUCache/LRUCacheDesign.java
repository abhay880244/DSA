package LRUCache;

import java.util.ArrayList;
import java.util.HashMap;

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
			return "LRUCache [maxCacheSize=" + maxCacheSize + ", list=" + list + ", map=" + map + "]";
		}


		private int maxCacheSize;
		private ArrayList<Entry> list;
		private HashMap<Integer,Entry> map = new HashMap<Integer,Entry>();

		public LRUCache(int size){
			this.maxCacheSize = size;
			list = new ArrayList<Entry>(size);
		}
		
		
		void put(int key , int value) {
		
			if(map.containsKey(key)) {
				
				Entry foundEntry = map.get(key);
				
				if(list.size() == maxCacheSize) {
					Entry lruEntry = list.get(maxCacheSize - 1);
					list.remove(lruEntry);
					map.remove(lruEntry.key);
					list.add(0, foundEntry);	
				}
				else {
					list.remove(foundEntry);
					list.add(0, foundEntry);	
				}
			}
			else {
				
				if(list.size() == maxCacheSize) {
					Entry lruEntry = list.get(maxCacheSize - 1);
					list.remove(lruEntry);
					map.remove(lruEntry.key);		
				}
				Entry newEntry = new Entry(key,value);
				list.add(0, newEntry);
				map.put(key, newEntry);	
			}
			
			
		}
	
		
		int get(int key) {
			if(map.containsKey(key)) {
				Entry existingEntry = map.get(key);
				list.remove(existingEntry);
				list.add(0, existingEntry);
				return existingEntry.value;
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
