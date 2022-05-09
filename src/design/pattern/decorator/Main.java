package design.pattern.decorator;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		IceCream iceCream = new NuttyDecorator(new FruitDecorator(new SimpleIceCream()));
		System.out.println(iceCream.makeIceCream());
		
		IceCream iceCream2 = new FruitDecorator(new NuttyDecorator(new SimpleIceCream()));
		System.out.println(iceCream2.makeIceCream());
		
	}

}
