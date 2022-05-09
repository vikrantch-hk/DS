package design.pattern.decorator;

public class FruitDecorator extends IceCreamDecorator {

	public FruitDecorator(IceCream icecream) {
		super(icecream);
	}
	
	@Override
	public String makeIceCream() {
		return icecream.makeIceCream()+" add fruits";
	}

}
