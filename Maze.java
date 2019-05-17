import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;

class Maze {

	char[][] mazeArray;
	int width, height, startX, startY, endX, endY, row;
	String inputFile;

	protected Maze(String inputFile) {
		this.inputFile = inputFile;
	}

	protected void loadIntoArray() throws FileNotFoundException {

		Scanner sc = new Scanner(new File(inputFile));

		width = (char) sc.nextInt();
		height = (char) sc.nextInt();
		startX = (char) sc.nextInt();
		startY = (char) sc.nextInt();
		endX = (char) sc.nextInt();
		endY = (char) sc.nextInt();
		row = 0;

		mazeArray = new char[height][width];

		sc.nextLine();

		while (sc.hasNextLine()) {
			String lineWithoutSpaces = sc.nextLine().replaceAll(" ", "");

				for (int col = 0; col < lineWithoutSpaces.length(); col++) {
					mazeArray[row][col] = lineWithoutSpaces.charAt(col);
				}
				row++;
		}
		sc.close();
	}

	protected boolean traverseMaze(int x, int y) {

		boolean solved = false;

		// check whether wall was hit or whether the coordinate was already checked
		if(mazeArray[y][x] == '1' || mazeArray[y][x] == ' ') {
			return false;
		}

		// unvisited coordinate; change it to visited
		if(mazeArray[y][x] == '0') {
			mazeArray[y][x] = ' ';
		}

		if (x == endX && y == endY) {
			solved = true;
		} else {
		if(traverseMaze(x, y + 1) ){
			mazeArray[y][x] = 'X';
			return true;
		} else if(traverseMaze(x, y - 1)) {
			mazeArray[y][x] = 'X';
			return true;
		} else if(traverseMaze(x + 1, y)) {
			mazeArray[y][x] = 'X';
			return true;
		} else if(traverseMaze(x - 1, y)) {
			mazeArray[y][x] = 'X';
			return true;
		}
	}
		return solved;
	}

	protected int getStartX() {
		return startX;
	}

	protected int getStartY() {
		return startY;
	}
	
	protected void printMaze() {
		mazeArray[startY][startX] = 'S';
		mazeArray[endY][endX] = 'E';

		/*
		change the characters as task requires
		0 = empty space
		1 = # (a wall)
		*/

		for (int row = 0; row < height; row++) {
			for (int col = 0; col < width; col++) {
				if (mazeArray[row][col] == '0') {
					mazeArray[row][col] = ' ';
				} else if (mazeArray[row][col] == '1') {
					mazeArray[row][col] = '#';
				}
			}
		}
		for (char[] row : mazeArray) {
			System.out.println(Arrays.toString(row));
		}
	}
}