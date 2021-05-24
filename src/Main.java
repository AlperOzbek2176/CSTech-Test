import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		// Board 1
		Scanner scan1 = new Scanner(System.in);
		ArrayList<String> arr1 = new ArrayList<>();
		String[][] board1 = new String[8][8];

		File file1 = new File("C:\\Users\\alper\\Desktop\\CSTech Test\\boards\\board1.txt");
		Scanner sc1 = new Scanner(file1);

		while (sc1.hasNextLine()) {
			Scanner s1 = new Scanner(sc1.nextLine());
			while (s1.hasNext()) {

				String s = s1.next();
				arr1.add(s);
			}
		}
		int k1 = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board1[i][j] = arr1.get(k1++);
			}
		}

		System.out.println("Board File Name \tResults");
		System.out.println("--------------- \t-------");
		System.out.print("\n" + file1.getName() + " -->");
		Black blackscore1 = new Black();
		blackscore1.blackKnightThreatControl(board1);
		blackscore1.blackBishopThreatControl(board1);
		blackscore1.write(board1);
		blackscore1.score();

		System.out.print("\t");
		White whitescore1 = new White();
		whitescore1.whiteKnightThreatControl(board1);
		whitescore1.whiteBishopThreatControl(board1);
		whitescore1.write(board1);
		whitescore1.score();

		// Board 2
		Scanner scan2 = new Scanner(System.in);
		ArrayList<String> arr2 = new ArrayList<>();
		String[][] board2 = new String[8][8];

		File file2 = new File("C:\\Users\\alper\\Desktop\\CSTech Test\\boards\\board2.txt");
		Scanner sc2 = new Scanner(file2);

		while (sc2.hasNextLine()) {
			Scanner s1 = new Scanner(sc2.nextLine());
			while (s1.hasNext()) {

				String s = s1.next();
				arr2.add(s);

			}
		}
		int k2 = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board2[i][j] = arr2.get(k2++);
			}
		}

		System.out.print("\n" + file2.getName() + " -->");
		Black blackscore2 = new Black();
		blackscore2.blackKnightThreatControl(board2);
		blackscore2.blackBishopThreatControl(board2);
		blackscore2.write(board2);
		blackscore2.score();

		System.out.print("\t");
		White whitescore2 = new White();
		whitescore2.whiteKnightThreatControl(board2);
		whitescore2.whiteBishopThreatControl(board2);
		whitescore2.write(board2);
		whitescore2.score();

		// Board 3
		Scanner scan3 = new Scanner(System.in);
		ArrayList<String> arr3 = new ArrayList<>();
		String[][] board3 = new String[8][8];

		File file3 = new File("C:\\Users\\alper\\Desktop\\CSTech Test\\boards\\board3.txt");
		Scanner sc3 = new Scanner(file3);

		while (sc3.hasNextLine()) {
			Scanner s1 = new Scanner(sc3.nextLine());
			while (s1.hasNext()) {

				String s = s1.next();
				arr3.add(s);

			}
		}
		int k3 = 0;

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				board3[i][j] = arr3.get(k3++);
			}
		}

		System.out.print("\n" + file3.getName() + " -->");
		Black blackscore3 = new Black();
		blackscore3.blackKnightThreatControl(board3);
		blackscore3.blackBishopThreatControl(board3);
		blackscore3.write(board3);
		blackscore3.score();

		System.out.print("\t");
		White whitescore3 = new White();
		whitescore3.whiteKnightThreatControl(board3);
		whitescore3.whiteBishopThreatControl(board3);
		whitescore3.write(board3);
		whitescore3.score();

		String fileName = "C:\\Users\\alper\\Desktop\\CSTech Test\\boards\\Results.txt";
		final boolean append = true, autoflush = true;
		PrintStream printStream = new PrintStream(new FileOutputStream(fileName, append), autoflush);
		System.setOut(printStream);

	}
}