public class HolidayBonus {

	
	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param high  the bonus given to the highest sales value
	 * @param low  The bonus given to the lowest sales value
	 * @param other  The bonus given to all the other sale values, minus negative sales
	 * @return  The total bonus for each row/store in the data array
	 */
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {
		
		double[] bonus = new double[data.length];
		
		for (int row = 0; row < bonus.length; row++) {
			
			double total = 0.0;

			for (int column = 0; column < data[row].length; column++) {
				
				if (data[row][column] <= 0) {
					total += 0; 
				}
				else if (data[row][column] == TwoDimRaggedArrayUtility.getHighestInColumn(data, column)) {
					total += high; 
				}
				else if (data[row][column] == TwoDimRaggedArrayUtility.getLowestInColumn(data, column)) {
					total += low; 
				}
				else total += other; 
			}
			bonus[row] = total; 
		}
		return bonus; 
	}

	/**
	 * 
	 * @param data  The jagged array that contains the sales from the different stores/brands
	 * @param high  the bonus given to the highest sales value
	 * @param low  The bonus given to the lowest sales value
	 * @param other  The bonus given to all the other sale values, minus negative sales
	 * @return  The total bonus amount for the entire data array
	 */
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {
		double[] bonus = calculateHolidayBonus(data, high, low, other); //to get the bonus amount for each row
		double totalBonus = 0.0; //to hold the total bonus
		
		//for loop to traverse the bonus array
		for (int row = 0; row < bonus.length; row++) {
			totalBonus += bonus[row]; //adding each row to total
		}
		return totalBonus; //return total amount
	}
}