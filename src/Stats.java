import java.util.*;
import java.util.concurrent.*;

public class Stats {
	public static class StatisticsAggregatorImpl implements StatisticsAggregator {

		static final class Item {
			private final String symbol;
			private final Double price;

			public Item(String symbol, Double price) {
				super();
				this.symbol = symbol;
				this.price = price;
			}

		}

		List<Item> list = new ArrayList<Item>();

		@Override
		public void putNewPrice(String symbol, double price) {
			// YOUR CODE HERE
			synchronized (this) {
				Item item = new Item(symbol, price);
				list.add(item);
			}
		}

		@Override
		public double getAveragePrice(String symbol) {
			// YOUR CODE HERE
			int count = 0;
			double sum = 0;
			synchronized (this) {
				for (Item item : list) {
					if (item.symbol.equals(symbol)) {
						sum += item.price;
						count++;
					}
				}
			}
			return sum / count;
		}

		@Override
		public int getTickCount(String symbol) {
			// YOUR CODE HERE
			int count = 0;
			synchronized (this) {
				for (Item item : list) {
					if (item.symbol.equals(symbol)) {
						count++;
					}
				}
			}
			return count;
		}
	}

	////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

	public interface StatisticsAggregator {
		// This is an input. Make note of this price.
		public void putNewPrice(String symbol, double price);

		// Get the average price
		public double getAveragePrice(String symbol);

		// Get the total number of prices recorded
		public int getTickCount(String symbol);
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			final StatisticsAggregator stats = new StatisticsAggregatorImpl();
			final Set<String> symbols = new TreeSet<>();

			String line = scanner.nextLine();
			String[] inputs = line.split(",");
			int threads = Integer.parseInt(inputs[0]);
			ExecutorService pool = Executors.newFixedThreadPool(threads);
			for (int i = 1; i < inputs.length; ++i) {
				String[] tokens = inputs[i].split(" ");
				final String symbol = tokens[0];
				symbols.add(symbol);
				final double price = Double.parseDouble(tokens[1]);
				pool.submit(new Runnable() {
					@Override
					public void run() {
						stats.putNewPrice(symbol, price);
					}
				});

			}
			pool.shutdown();
			try {
				pool.awaitTermination(5000, TimeUnit.MILLISECONDS);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			for (String symbol : symbols) {
				System.out.println(
						String.format("%s %.4f %d", symbol, stats.getAveragePrice(symbol), stats.getTickCount(symbol)));
			}
		}
		scanner.close();

	}
}