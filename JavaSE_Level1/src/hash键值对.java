import java.util.HashMap;

public class hash键值对 {
public static void main(String[] args) {
	HashMap<String, Integer> map=new HashMap<>();
	map.put("张三", 18);
	map.put("张8", 13);
	map.put("张三", 18);
	
	System.out.println(map.containsKey("张三"));
	
	for(String key: map.keySet()) {
		System.out.println(key+" "+map.get(key));
	}

	
}
}
