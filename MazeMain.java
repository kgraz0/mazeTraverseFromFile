import java.io.FileNotFoundException;

class MazeMain {

	public static void main(String[] args) throws FileNotFoundException {

		Maze testMaze = new Maze("inputFiles/medium_input.txt");

		testMaze.loadIntoArray();
		boolean solved = testMaze.traverseMaze(testMaze.getStartX(), testMaze.getStartY());

		if (solved == true) {
			testMaze.printMaze();
		} else {
			System.out.println("No solution found.");
		}
	}
}