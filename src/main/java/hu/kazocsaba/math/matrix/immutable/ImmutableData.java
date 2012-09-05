package hu.kazocsaba.math.matrix.immutable;

import hu.kazocsaba.math.matrix.MatrixCore;

/**
 *
 * @author Kazó Csaba
 */
abstract class ImmutableData extends MatrixCore {

	ImmutableData(int rowCount, int colCount) {
		super(rowCount, colCount);
	}

	@Override
	public final void setQuick(int row, int col, double value) {
		throw new UnsupportedOperationException("Matrix is read-only");
	}

}
