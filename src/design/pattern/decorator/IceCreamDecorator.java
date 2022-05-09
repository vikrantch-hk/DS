package design.pattern.decorator;

public abstract class IceCreamDecorator implements IceCream{

	IceCream icecream;

	public IceCreamDecorator(IceCream icecream) {
		super();
		System.out.println(" IceCreamDecorator ");
		this.icecream = icecream;
	}
	
	@Override
	public String makeIceCream() {
		return icecream.makeIceCream();
	}
	
}
