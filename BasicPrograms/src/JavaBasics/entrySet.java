package JavaBasics;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class entrySet {
	
	public static void main(String[] args) {
		
		HashMap<String, String> hm = new HashMap<String, String>();
		
		hm.put("abc", "def");
		
		Set<Entry<String, String>> keyvalue = hm.entrySet();
		
		System.out.println(keyvalue);
	}

}
//Returns a Set view of the mappings contained in this map.
//The set is backed by the map, so changes to the map are reflected in the set, and vice-versa. 
//If the map is modified while an iteration over the set is in progress (except through the iterator's own remove operation, or through the setValue operation on a map entry returned by the iterator) the results of the iteration are undefined. 
//The set supports element removal, which removes the corresponding mapping from the map, via the Iterator.remove, Set.remove, removeAll, retainAll and clear operations. It does not support the add or addAll operations.
//Specified by: entrySet() in Map, Overrides: entrySet() in AbstractMap
//Returns:a set view of the mappings contained in this map

//Conclusion: entrySet() is used to get key and value at a same time in one method