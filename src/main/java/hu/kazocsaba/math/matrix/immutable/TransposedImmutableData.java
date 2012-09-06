package hu.kazocsaba.math.matrix.immutable;

/**
 *
 * @author Kazó Csaba
 */
class TransposedImmutableData extends ImmutableData {
	private final ImmutableData data;

	TransposedImmutableData(ImmutableData data) {
		super(data.getColumnCount(), data.getRowCount());
		this.data = data;
	}

	@Override
	public double getQuick(int row, int col) {
		return data.getQuick(col, row);
	}
}
