import java.util.ArrayList;
import java.util.List;


public class FiveTon {

	private static List<FiveTon> FiveTons= new ArrayList<FiveTon>();
	
	static{
		FiveTons.add(new FiveTon());
		FiveTons.add(new FiveTon());
		FiveTons.add(new FiveTon());
		FiveTons.add(new FiveTon());
		FiveTons.add(new FiveTon());
	}
	
	public static FiveTon getInstance() {
		if(FiveTons.size()>0)
			return FiveTons.remove(FiveTons.size()-1);
		return null;
	}
	
	@Override
	protected void finalize() throws Throwable {
		// TODO Auto-generated method stub
		super.finalize();
		System.out.println("finalize");
		FiveTons.add(new FiveTon());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(FiveTon.getInstance());
		System.gc();
		System.out.println(FiveTon.getInstance());
		System.out.println(FiveTon.getInstance());
		System.gc();
		System.out.println(FiveTon.getInstance());
		System.out.println(FiveTon.getInstance());
		System.out.println(FiveTon.getInstance());
		System.gc();
		System.out.println(FiveTon.getInstance());
		System.out.println(FiveTon.getInstance());
		System.out.println(FiveTon.getInstance());
		System.gc();
		System.out.println(FiveTon.getInstance());
		System.out.println(FiveTon.getInstance());
		System.out.println(FiveTon.getInstance());
		System.gc();
		System.out.println(FiveTon.getInstance());
		System.out.println(FiveTon.getInstance());
		System.gc();
		System.out.println(FiveTon.getInstance());

	}

}
