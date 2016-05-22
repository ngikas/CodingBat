public class Map1 {

	public Map<String, String> topping3(Map<String, String> map) {
		if (map.get("potato") != null) {
		map.put("fries", map.get("potato"));
		}

		if (map.get("salad") != null) {
		map.put("spinach", map.get("salad"));
		}
		return map;
	}

	public Map<String, String> topping2(Map<String, String> map) {
		if (map.get("ice cream") != null) {
		map.put("yogurt", map.get("ice cream"));
		}

		if (map.get("spinach") != null) {
		map.put("spinach", "nuts");
		}
		return map;
	}

	public Map<String, String> topping1(Map<String, String> map) {
		map.put("bread", "butter");
		if (map.get("ice cream") != null) map.put("ice cream", "cherry");
		return map;
	}

	public Map<String, String> mapAB(Map<String, String> map) {
		if (map.get("a") != null && map.get("b") != null) {
		map.put("ab", map.get("a") + map.get("b")); 
		}
		return map;
	}

	public Map<String, String> mapShare(Map<String, String> map) {
  		map.remove("c");
  		if (map.get("a") != null) {
			map.put("b", map.get("a"));
  		}
  		return map;
	}

	public Map<String, String> mapBully(Map<String, String> map) {
		if (map.get("a") != null) {
			map.put("b", map.get("a"));
			map.put("a", "");
		}
		return map;
	}

}