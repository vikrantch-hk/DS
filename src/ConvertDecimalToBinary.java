public class ConvertDecimalToBinary {

	public static void convert(int n) {
		if (n <= 0)
			System.out.println("cannt convert");
		else {
			StringBuilder sb = new StringBuilder();

			while (n  > 0) {
				sb.append(n % 2);
				n = n / 2;
			}
			//sb.append(n % 2);
			System.out.println("binary: "+sb.reverse());

		}
	}

	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convert(10);
		System.out.println(Integer.parseInt("1011", 2));
		System.out.println("shortcut of binary "+Integer.toString(10, 2));
	}

}
