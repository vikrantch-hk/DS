package design.pattern.decorator;

public class NuttyDecorator extends IceCreamDecorator {

	public NuttyDecorator(IceCream icecream) {
		super(icecream);
	}

	@Override
	public String makeIceCream() {
		return icecream.makeIceCream()+" add nuts";
	}
}
