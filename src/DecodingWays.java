import java.util.HashMap;
import java.util.Map;

public class DecodingWays {
	
	static Map<Integer,String> map = new HashMap<>();
	static{
		map.put(1,"a");
		map.put(2,"b");
		map.put(3,"c");
		map.put(4,"d");
		map.put(5,"e");
		map.put(6,"f");
		map.put(7,"g");
		map.put(8,"h");
		map.put(9,"i");
		map.put(10,"j");
		map.put(11,"k");
		map.put(12,"l");
		map.put(13,"m");
		map.put(14,"n");
		map.put(15,"o");
		map.put(16,"p");
		map.put(17,"q");
		map.put(18,"r");
		map.put(19,"s");
		map.put(20,"t");
		map.put(21,"u");
		map.put(22,"v");
		map.put(23,"w");
		map.put(24,"x");
		map.put(25,"y");
		map.put(26,"z");
		
	}
	public static void decode(String s, String prefix) {
		if(s.length()==0) {
			System.out.println(prefix);
			return;
		}
		int l =prefix.length();
		
			String first= map.get(Integer.parseInt(s.substring(0,1)));
			decode(s.substring(1),prefix+first);
		if(s.length()>=2) {
			if(map.containsKey(Integer.parseInt(s.substring(0,2)))) {
			String firstTwo= map.get(Integer.parseInt(s.substring(0,2)));
				decode(s.substring(2),prefix+firstTwo);
			}
		}
	}

	public static void main(String[] args) {
		decode("121", "");
		decode("231", "");
		decode("1212", "");
	}
}
