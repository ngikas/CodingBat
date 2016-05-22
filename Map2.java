import java.util.*;

public class Map2 {

	public Map<String, Boolean> wordMultiple(String[] strings) {
  		Map<String, Boolean> map = new HashMap<String, Boolean>();
  		for (String str : strings) {
  			if (map.get(str) != null) {
  				map.put(str, true);
  			} else {
  				map.put(str, false);
  			}
  		}
  		return map;
	}


	public Map<String, String> firstChar(String[] strings) {
		Map<String, String> map = new HashMap<String, String>();
  		for (String str : strings) {
  			if (map.get(str.substring(0, 1)) != null) {
  				String tail = map.get(str.substring(0, 1)) + str;
  				map.put(str.substring(0, 1), tail);
  			} else {
  				map.put(str.substring(0, 1), str);
  			}
  		}
  		return map;
	}

	public Map<String, Integer> wordCount(String[] strings) {
  		Map<String, Integer> map = new HashMap<String, Integer>();
  		for (String str : strings) {
  			if (map.get(str) != null) {
  				int increment = map.get(str) + 1;
  				map.put(str, increment);
  			} else {
  				map.put(str, 1);
  			}
  		}
  		return map;
	}

	public Map<String, String> pairs(String[] strings) {
		Map<String, String> map = new HashMap<String, String>();
		for (String str : strings) {
			if (map.get(str) == null) map.put(str.substring(0, 1), str.substring(str.length() - 1));
		}
		return map;
	}

	public Map<String, Integer> wordLen(String[] strings) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String str : strings) {
			if (map.get(str) == null) map.put(str, str.length());
		}
		return map;
	}

	public Map<String, Integer> word0(String[] strings) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String letter : strings) {
			if (map.get(letter) == null) map.put(letter, 0);
		}
		return map;
	}

}