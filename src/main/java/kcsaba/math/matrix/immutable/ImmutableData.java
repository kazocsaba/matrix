package kcsaba.math.matrix.immutable;

/**
 *
 * @author Kazó Csaba
 */
interface ImmutableData {

	public double get(int row, int col);

	public int getColumnCount();

	public int getRowCount();
}
