import java.util.HashMap;
import java.util.Map;

public class OrderedHashMap {

	static class Sample{
		int id;

		// same hascode same index elements will be stored as linkedlist
		@Override
		public int hashCode() {
			
			return 1;//(1+id)*31;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Sample other = (Sample) obj;
			if (id != other.id)
				return false;
			return true;
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<Sample, String> map = new HashMap<Sample, String>();
		Sample s1=new Sample();
		s1.id=1;
		map.put(s1, "1");
		Sample s2=new Sample();
		s2.id=2;
		map.put(s2, "2");
		Sample s3=new Sample();
		s3.id=3;
		map.put(s3, "3");
		Sample s4=new Sample();
		s4.id=4;
		map.put(s4, "4");
		map.forEach((k,v)->System.out.println(v));
	}

}
