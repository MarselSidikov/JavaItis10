class Program {
	public static void main(String[] args) {
		int a[];
		a = new int[5];

		a[0] = 3;
		a[1] = 2;
		a[2] = 4;
		a[3] = -7;
		a[4] = 8;

		int i = 0;
		while (i < 5) {
			System.out.println(a[i]);
			i = i + 1;
		}

		i = i - 1;
		while (i >= 0) {
			System.out.println(a[i]);
			i = i - 1;
		}
	}
}