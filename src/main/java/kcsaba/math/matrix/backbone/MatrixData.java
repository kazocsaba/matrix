package kcsaba.math.matrix.backbone;

/**
 * A data structure which stores matrix data. It is analogous to the {@link kcsaba.math.matrix.Matrix
 * interface but it is not type- and feature-rich.
 * @author Kazó Csaba
 */
public interface MatrixData {

	/**
	 * Retrieves an element of the matrix.
	 * @param row the row index
	 * @param col the column index
	 * @return the element at the specified position
	 * @throws IndexOutOfBoundsException if either index is out of range
	 */
	public double get(int row, int col);

	/**
	 * Updates an element of the matrix.
	 * @param row the row index
	 * @param col the column index
	 * @param value the new value
	 * @throws IndexOutOfBoundsException if either index is out of range
	 */
	public void set(int row, int col, double value);

	/**
	 * Returns the number of columns.
	 * @return the number of columns
	 */
	public int getColumnCount();

	/**
	 * Returns the number of rows.
	 * @return the number of rows
	 */
	public int getRowCount();
}
