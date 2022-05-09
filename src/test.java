import java.applet.AppletContext;
import java.applet.AppletStub;


public interface test extends AppletContext,AppletStub{
	private int a =0;////for the interface field test.a; only public, static & final are permitted
	//public test(){}//Interfaces cannot have constructors
	public abstract static void abc();//Illegal modifier for the interface method abc; only public & abstract are permitted
}

