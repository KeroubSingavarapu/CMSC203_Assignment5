import java.util.*;
import java.io.*;

public class TwoDimRaggedArrayUtility {

/**
 * 
 * @param file  The file containing numbers that is to be read into the program
 * @return A double jagged array that contains the sales from different stores/brands
 * @throws java.io.FileNotFoundException  if no file is found
 */
	public static double[][] readFile(File file) throws java.io.FileNotFoundException {
		Scanner inputFile = new Scanner(file); 
		String[][] input = new String[10][10]; 
		double[][] data;
		String[] rowIndex;
		int row = 0;

		
		/*
		 * Go through the file to create a jagged array with appropriate sized rows and columns
		 */
		while (inputFile.hasNext()) {
			rowIndex = inputFile.nextLine().split(" "); 
			input[row] = new String[rowIndex.length]; 
			for (int column = 0; column < rowIndex.length; column++) {
				input[row][column] = rowIndex[column];
			}
			row++; 
		}
		inputFile.close(); 

		data = new double[row][]; 

		for (int i = 0; i < row; i++) {
			data[i] = new double[input[i].length]; 
			for (int j = 0; j < input[i].length; j++) {
				data[i][j] = Double.parseDouble(input[i][j]);
			}
		}
		return data; 
	}

	/**
	 * 
	 * @param data  The double jagged that was used in the program that the sales from different stores/brands
	 * @param outputFile  The file created with data
	 * @throws java.io.FileNotFoundException  If there is no file found
	 */
	public static void writeToFile(double[][] data, File outputFile) throws java.io.FileNotFoundException {
		PrintWriter file = new PrintWriter(outputFile); 

		for (int row = 0; row < data.length; row++) {
			for (int column = 0; column < data[row].length; column++) {
				file.print(data[row][column] + " "); 
			}
			file.println(); 
		}
		file.close(); 
	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @return The overall total from the jagged array
	 */
	public static double getTotal(double[][] data) {
		double total = 0.0;

		for (int row = 0; row < data.length; row++) {
			for (int column = 0; column < data[row].length; column++) {
				total += data[row][column]; 
			}
		}
		return total; 
	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from different stores/brands
	 * @return The average from the overall array
	 */
	public static double getAverage(double[][] data) {
		double total = 0.0;
		int count = 0; 

		for (int row = 0; row < data.length; row++) {
			for (int column = 0; column < data[row].length; column++) {
				total += data[row][column]; 
				count++; 
			}
		}
		return total/count;
	}

	
	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param row  The specified row within the array
	 * @return The total from a specific row
	 */
	public static double getRowTotal(double[][] data, int row) {
		double total = 0.0;

		for (int column = 0; column < data[row].length; column++) {
			total += data[row][column];
		}
		return total;
	}

	
	/**
	 * 
	 * @param data The jagged array that contains the sales from the different stores/brands
	 * @param col  The specified column within the array
	 * @return  The total from a specific column
	 */
	public static double getColumnTotal(double[][] data, int col) {
		double total = 0.0;

		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
			total += data[row][col]; 
			}
		}
		return total;
	}

	
	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param row  The specified row within the array
	 * @return  The highest value in the specified row
	 */
	public static double getHighestInRow(double[][] data, int row) {
		double highest = 0.0;

		for (int column = 0; column < data[row].length; column++) {
			if (data[row][column] >= highest) {
				highest = data[row][column]; 
			}
		}
		return highest;
	}

	
	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param row  The specified row within the array
	 * @return  The column index containing the highest value in the specified row
	 */
	public static int getHighestInRowIndex(double[][] data, int row) {
		double highest = 0.0;
		int index = 0;

		for (int column = 0; column < data[row].length; column++) {
			if (data[row][column] >= highest) {
				highest = data[row][column];
				index = column; 
			}
		}
		return index;
	}

	
	/**
	 * 
	 * @param data  he jagged array that contains the sales from the different stores/brands
	 * @param row  The specified row within the array
	 * @return  The lowest value in the specified row
	 */
	public static double getLowestInRow(double[][] data, int row) {
		double lowest = 999999;

		for (int column = 0; column < data[row].length; column++)
		{
			if (data[row][column] <= lowest) //if value is less than lowest
			{
				lowest = data[row][column]; //assign new value to lowest
			}
		}
		return lowest;
	}

	
	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param row  The specified row within the array
	 * @return  The column index containing the lowest value in the specified row
	 */
	public static int getLowestInRowIndex(double[][] data, int row) {
		double lowest = 999999;
		int index = 0;

		for (int column = 0; column < data[row].length; column++) {
			if (data[row][column] <= lowest) {
				lowest = data[row][column];
				index = column; 
			}
		}
		return index; 
	}

	
	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param col  The specified column within the array
	 * @return  the highest value in the specified column
	 */
	public static double getHighestInColumn(double[][] data, int col) {
		double highest = 0.0;

		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] >= highest) {
					highest = data[row][col]; 
				}
			}
		}
		return highest;
	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param col  The specified column within the array
	 * @return  The row index containing the highest value in the specified column
	 */
	public static int getHighestInColumnIndex(double[][] data, int col) {
		double highest = 0.0;
		int index = 0;

		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] >= highest) {
					highest = data[row][col];
					index = row; 
				}
			}
		}
		return index; 
	}

	
	/**
	 * 
	 *@param data  The jagged array that contains the sales from the different stores/brands
	 * @param col  The specified column within the array
	 * @return  The lowest value for the specified column
	 */
	public static double getLowestInColumn(double[][] data, int col) {
		double lowest = 999999;

		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] <= lowest) {
					lowest = data[row][col]; 
				}
			}
		}
		return lowest;
	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param col  The specified column within the array
	 * @return  the row index containing the lowest value for the specified column
	 */
	public static int getLowestInColumnIndex(double[][] data, int col) {
		double lowest = 999999;
		int index = 0;

		for (int row = 0; row < data.length; row++) {
			if (col < data[row].length) {
				if (data[row][col] <= lowest) {
					lowest = data[row][col]; 
					index = row; 
				}
			}
		}
		return index;
	} 

	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @return  the highes value in the entire array
	 */
	public static double getHighestInArray(double[][] data) {
		double highest = 0.0;

		//going through the entire array
		for (int row = 0; row < data.length; row++) {
			for (int column = 0; column < data[row].length; column++) {
				if (data[row][column] > highest) {
					highest = data[row][column]; 
				}
			}
		}
		return highest;
	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @return  The lowest value in the entire array
	 */
	public static double getLowestInArray(double[][] data) {
		double lowest = 999999;

		for (int row = 0; row < data.length; row++) {
			for (int column = 0; column < data[row].length; column++) {
				if (data[row][column] < lowest) {
					lowest = data[row][column]; 
				}
			}
		}
		return lowest;
	}
}