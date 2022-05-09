package design.pattern.builder;

public class BuilderMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NutritionFacts nf = new NutritionFacts.Builder(240, 8).sodium(2)
				.calories(3).carbohydrate(4).build();
		System.out.println("done");
	}

}
