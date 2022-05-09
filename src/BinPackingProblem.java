import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// https://www.geeksforgeeks.org/bin-packing-problem-minimize-number-of-used-bins/
public class BinPackingProblem {

	static class Bin {
		public List<Integer> indexes = new ArrayList<>();
		public int wt = 0;
	}

	public static List<Bin> getBins(Integer[] wieght, int BinCapacity) {
		List<Bin> bins = new ArrayList<>();
		// sort in decreasing weight order
		Arrays.sort(wieght, Comparator.reverseOrder());

		// take first fit approach
		for (int i = 0; i < wieght.length; i++) {
			if (bins.isEmpty()) {
				Bin bin = new Bin();
				bin.indexes.add(wieght[i]);
				bin.wt += wieght[i];
				bins.add(bin);
			} else {
				// add wt to first fit bin
				Bin firstFitBin = null;
				
				for(int j=0;j<bins.size();j++) {
					if(bins.get(j).wt + wieght[i] <= BinCapacity) {
						firstFitBin = bins.get(j);
						break;
					}
				}
				
				if (firstFitBin!=null) {
					firstFitBin.indexes.add(wieght[i]);
					firstFitBin.wt += wieght[i];
				} else {
					Bin bin = new Bin();
					bin.indexes.add(wieght[i]);
					bin.wt += wieght[i];
					bins.add(bin);
				}
			}
		}

		return bins;

	}

	public static void main(String[] args) {

		// wieght[] = {2, 5, 4, 7, 1, 3, 8};
		// Bin Capacity c = 10 o/p--> 3
		// wieght[] = {2, 3, 3, 5, 6};
		// Bin Capacity c = 10 o/p--> 2 {0,2,3}{1,4}
		System.out.println("bins are ");
		getBins(new Integer[] { 2, 3, 3, 5, 6 }, 10).stream().forEach(bin -> {
			System.out.println();
			bin.indexes.stream().forEach(i -> System.out.print(i + " "));
		});
		System.out.println("secnd");
		getBins(new Integer[] { 2, 5, 4, 7, 1, 3, 8 }, 10).stream().forEach(bin -> {
			System.out.println();
			bin.indexes.stream().forEach(i -> System.out.print(i + " "));
		});

	}

}
