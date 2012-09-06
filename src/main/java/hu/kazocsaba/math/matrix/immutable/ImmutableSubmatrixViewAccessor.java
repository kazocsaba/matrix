package hu.kazocsaba.math.matrix.immutable;

import hu.kazocsaba.math.matrix.backbone.AbstractSubmatrixAccessor;

/**
 * Provides access to submatrix views of immutable matrices. The views themselves are also immutable.
 *
 * @author Kazó Csaba
 */
public class ImmutableSubmatrixViewAccessor extends AbstractSubmatrixAccessor {
	private class ViewData extends ImmutableData {
		private final int subRow;
		private final int subCol;

		ViewData(int row, int col, int rowCount, int colCount) {
			super(rowCount, colCount);
			if (row < 0 || col < 0 || row + getRowCount() - 1 >= matrix.getRowCount() || col + getColumnCount() - 1 >= matrix.getColumnCount())
				throw new IllegalArgumentException();
			subRow = row;
			subCol = col;
		}

		@Override
		public double getQuick(int row, int col) {
			return matrix.getQuick(subRow + row, subCol + col);
		}
	}

	private class ViewRowVectorData extends ImmutableData {
		private final int subRow;
		private final int subCol;

		ViewRowVectorData(int row, int col, int dimension) {
			super(dimension, 1);
			if (row < 0 || col < 0 || row + getColumnCount() - 1 >= matrix.getRowCount() || col + getRowCount() - 1 >= matrix.getColumnCount())
				throw new IllegalArgumentException();
			this.subRow = row;
			this.subCol = col;
		}

		@Override
		public double getQuick(int row, int col) {
			return matrix.getQuick(subRow, subCol + row);
		}
	}

	ImmutableSubmatrixViewAccessor(ImmutableMatrix matrix) {
		super(matrix);
	}

	@Override
	public ImmutableMatrix matrix(int row, int col, int rowCount, int colCount) {
		return ImmutableMatrixFactory.create(new ViewData(row, col, rowCount, colCount));
	}

	@Override
	public ImmutableVector rowVector(int row, int col, int dimension) {
		return (ImmutableVector)ImmutableMatrixFactory.create(new ViewRowVectorData(row, col, dimension));
	}

	@Override
	public ImmutableMatrix2 matrix2(int row, int col) {
		return (ImmutableMatrix2)super.matrix2(row, col);
	}

	@Override
	public ImmutableMatrix3 matrix3(int row, int col) {
		return (ImmutableMatrix3)super.matrix3(row, col);
	}

	@Override
	public ImmutableVector column(int col) {
		return (ImmutableVector)super.column(col);
	}

	@Override
	public ImmutableVector row(int row) {
		return (ImmutableVector)super.row(row);
	}

	@Override
	public ImmutableVector2 rowVector2(int row, int col) {
		return (ImmutableVector2)super.rowVector2(row, col);
	}

	@Override
	public ImmutableVector3 rowVector3(int row, int col) {
		return (ImmutableVector3)super.rowVector3(row, col);
	}

	@Override
	public ImmutableVector4 rowVector4(int row, int col) {
		return (ImmutableVector4)super.rowVector4(row, col);
	}

	@Override
	public ImmutableVector vector(int row, int col, int dimension) {
		return (ImmutableVector)super.vector(row, col, dimension);
	}

	@Override
	public ImmutableVector2 vector2(int row, int col) {
		return (ImmutableVector2)super.vector2(row, col);
	}

	@Override
	public ImmutableVector3 vector3(int row, int col) {
		return (ImmutableVector3)super.vector3(row, col);
	}

	@Override
	public ImmutableVector4 vector4(int row, int col) {
		return (ImmutableVector4)super.vector4(row, col);
	}
}
