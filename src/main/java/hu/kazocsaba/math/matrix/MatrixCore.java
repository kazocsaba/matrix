package hu.kazocsaba.math.matrix;

/**
 * The data structure for a matrix implementation. This abstract class specifies the bare necessities required for a
 * matrix, without any of the convenience methods and types provided by the {@link Matrix} interface hierarchy.
 *
 * @author Kazó Csaba
 */
public abstract class MatrixCore {
	private final int rowCount;
	private final int colCount;

	/**
	 * Creates a new instance with the specified dimensions. The dimensions must be specified at construction time
	 * because matrix implementations are not allowed to change size.
	 *
	 * @param rowCount the number of rows
	 * @param colCount the number of columns
	 * @throws IllegalArgumentException if either argument is non-positive
	 */
	public MatrixCore(int rowCount, int colCount) {
		if (rowCount <= 0) throw new IllegalArgumentException("Number of rows must be positive");
		if (colCount <= 0) throw new IllegalArgumentException("Number of columns must be positive");

		this.rowCount = rowCount;
		this.colCount = colCount;
	}

	/**
	 * Returns the number of rows.
	 *
	 * @return the number of rows
	 */
	public final int getRowCount() {
		return rowCount;
	}

	/**
	 * Returns the number of columns.
	 *
	 * @return the number of columns
	 */
	public final int getColumnCount() {
		return colCount;
	}

	/**
	 * Retrieves an element of the matrix without checking the arguments. If the row or the column index is invalid, the
	 * behaviour of this method is unspecified. For example, it may return some value or throw an exception.
	 *
	 * @param row the row index
	 * @param col the column index
	 * @return the element at the specified position
	 */
	public abstract double getQuick(int row, int col);

	/**
	 * Updates an element of the matrix without checking the indexes. If the row or the column index is invalid, the
	 * behaviour of this method is unspecified. For example, it may set some element or throw an exception.
	 *
	 * @param row the row index
	 * @param col the column index
	 * @param value the new value
	 */
	public abstract void setQuick(int row, int col, double value);
}
