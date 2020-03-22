package j5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static Page[] arr;
	public static String[] input;

	public static BufferedReader reader;

	public Main() {

	}

	public static void main(String[] args) {
		reader = new BufferedReader(new InputStreamReader(System.in));
		int size = 0;
		try {
			size = Integer.parseInt(reader.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		getArr(size);
		printTree();
		System.out.println(getLeastPath(arr));
	}

	public static void getInput(int size) {

		input = new String[size];
		StringTokenizer tokenizer = null;

		for (int i = 0; i < size; i++) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

	public static void getArr(int size) {

		arr = new Page[size];
		StringTokenizer tokenizer = null;

		for (int i = 0; i < size; i++) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}

			int length = Integer.parseInt(tokenizer.nextToken());

			if (length != 0) {

				arr[i] = new Page(i + 1);
				Page[] Options = new Page[length];
				for (int j = 0; j < length; j++) {
					if (tokenizer.hasMoreElements()) {
						Options[j] = new Page(Integer.parseInt(tokenizer.nextToken()));
					}
				}

				arr[i].addOptions(Options);
			} else {
				arr[i] = new Page(i + 1);
				arr[i].addOptions(new Page[0]);
			}
		}
	}

	public static int getLeastPath(Page[] arr) {

		return traverseTree(arr, 0, 1);

	}

	public static int count = 0;

	public static int traverseTree(Page[] arr, int index, int count) {
		count = 0;
		if (arr[index].options.length != 0) {
			for (int i = 0; i < arr[index].options.length; i++) {
				System.out.println("traverse");
				traverseTree(arr, arr[index].options[i].number - 1, count + 1);
				count++;
				System.out.println(arr[index].options[i].number - 1 + " , " + count);
			}

		} else {
			
			return count;
		}
		return count;
	}

	public static void printTree() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].number + " ");
			for (int j = 0; j < arr[i].options.length; j++) {
				System.out.print(arr[i].options[j].number + " ");
			}

			System.out.println();
		}
	}

}

class Page {
	public int number;
	public Page[] options;

	public Page(int number) {
		this.number = number;
		options = null;
	}

	public void addOptions(Page[] options) {
		this.options = options;
	}

	public Page getOption(int index) {
		return options[index];
	}
}
