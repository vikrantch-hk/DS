import java.util.ArrayList;
import java.util.List;


public class TestInner {
// anonymous inner class example
	public static void main(String[] args) {
		Inner inner = new Inner() {
			{
				List list = new ArrayList();
				System.out.println(list.size());
				System.out.println("hii");
			}
		};
	}
}

abstract class Inner{
	public void read(){};
} 