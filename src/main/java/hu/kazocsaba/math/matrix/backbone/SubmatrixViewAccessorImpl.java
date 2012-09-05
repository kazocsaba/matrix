package hu.kazocsaba.math.matrix.backbone;

import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.MatrixCore;
import hu.kazocsaba.math.matrix.MatrixFactory;
import hu.kazocsaba.math.matrix.Vector;

/**
 * An implementation of {@code SubmatrixAccessor} which creates views that share data with the original matrix.
 * @author Kazó Csaba
 */
class SubmatrixViewAccessorImpl extends AbstractSubmatrixAccessor {
	public SubmatrixViewAccessorImpl(Matrix matrix) {
		super(matrix);
	}
	
	private class ViewCore extends MatrixCore {
		private final int subRow, subCol;

		public ViewCore(int row, int col, int rowCount, int colCount) {
			super(rowCount, colCount);
			if (row < 0 || col < 0 || row+getRowCount()-1 >= matrix.getRowCount() || col+getColumnCount()-1 >= matrix.getColumnCount())
				throw new IllegalArgumentException();
			this.subRow = row;
			this.subCol = col;
		}

		@Override
		public double getQuick(int row, int col) {
			return matrix.getQuick(subRow+row, subCol+col);
		}

		@Override
		public void setQuick(int row, int col, double value) {
			matrix.setQuick(subRow+row, subCol+col, value);
		}
		
	}
	
	private class RowVectorViewCore extends MatrixCore {
		private final int subRow, subCol;

		public RowVectorViewCore(int row, int col, int dimension) {
			super(dimension, 1);
			if (row < 0 || col < 0 || row+getColumnCount()-1 >= matrix.getRowCount() || col+getRowCount()-1 >= matrix.getColumnCount())
				throw new IllegalArgumentException();
			this.subRow = row;
			this.subCol = col;
		}

		@Override
		public double getQuick(int row, int col) {
			return matrix.getQuick(subRow, subCol+row);
		}

		@Override
		public void setQuick(int row, int col, double value) {
			matrix.setQuick(subRow, subCol+row, value);
		}
		
	}
	
	@Override
	public Matrix matrix(int row, int col, int rowCount, int colCount) {
		return MatrixFactory.create(new ViewCore(row, col, rowCount, colCount));
	}
	
	@Override
	public Vector rowVector(int row, int col, int dimension) {
		return (Vector)MatrixFactory.create(new RowVectorViewCore(row, col, dimension));
	}
	
}
