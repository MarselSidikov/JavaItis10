import java.util.Scanner;
import java.util.Arrays;
class Program {

	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static void swapInArray(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void printNumbersInRange(int a, int b) {
		System.out.println("IN printNumbersInRange");
		if (a > b) {
			System.out.println("OUT 1 FROM printNumbersInRange");
			return;
		} 
		for (int i = a; i <= b; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("OUT 2 FROM printNumbersInRange");
	}

	public static void processNumbers() {
		System.out.println("IN processNumbers");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("IN while of processNumbers");
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			printNumbersInRange(x, y);
		}
	}


	public static void main(String[] args) {
		// System.out.println("IN main");
		// processNumbers();
		int array[] = {0, 1, 2, 3, 4};
		swapInArray(array, 1, 4);
		System.out.println(Arrays.toString(array));
	}
}