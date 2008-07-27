package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.MatrixFactory;
import kcsaba.math.matrix.SingularValueDecomposition;
import kcsaba.math.matrix.SingularityException;
import kcsaba.math.matrix.util.JamaBridge;

/**
 *
 * @author Kazó Csaba
 */
class MatrixImpl implements Matrix {

	private final double[][] data;

	MatrixImpl(int rowCount, int colCount) {
		data = new double[rowCount][colCount];
	}

	public double get(int row, int col) {
		return data[row][col];
	}

	public void set(int row, int col, double value) {
		data[row][col] = value;
	}

	public int getColumnCount() {
		return data[0].length;
	}

	public int getRowCount() {
		return data.length;
	}

	public Matrix mul(Matrix m) {
		if (getColumnCount() != m.getRowCount()) throw new IllegalArgumentException();
		Matrix result = MatrixFactory.createMatrix(getRowCount(), m.getColumnCount());
		for (int row = 0; row < result.getRowCount(); row++)
			for (int col = 0; col < result.getColumnCount(); col++) {
				double v = 0;
				for (int i = 0; i < getColumnCount(); i++)
					v += get(row, i) * m.get(i, col);
				result.set(row, col, v);
			}
		return result;
	}

	public void scale(double c) {
		for (int row = 0; row < getRowCount(); row++)
			for (int col = 0; col < getColumnCount(); col++)
				set(row, col, get(row, col)*c);
	}

	public void add(Matrix m) {
		if (getRowCount() != m.getRowCount() || getColumnCount() != m.getColumnCount())
			throw new IllegalArgumentException();
		for (int i=0; i<getRowCount(); i++) for (int j=0; j<getColumnCount(); j++)
			set(i, j, get(i, j) + m.get(i, j));
	}

	public Matrix getSubmatrix(int row1, int row2, int col1, int col2) {
		if (row1 < 0 || col1 < 0 || row2 >= getRowCount() || col2 >= getColumnCount() || row2 < row1 || col2 < col1)
			throw new IllegalArgumentException();
		Matrix result = MatrixFactory.createMatrix(row2 - row1 + 1, col2 - col1 + 1);
		for (int row = 0; row < result.getRowCount(); row++)
			for (int col = 0; col < result.getColumnCount(); col++)
				result.set(row, col, get(row1 + row, col1 + col));
		return result;
	}

	public Matrix plus(Matrix m) {
		if (getRowCount() != m.getRowCount() || getColumnCount() != m.getColumnCount())
			throw new IllegalArgumentException();
		Matrix result=MatrixFactory.createMatrix(getRowCount(), getColumnCount());
		for (int i=0; i<getRowCount(); i++) for (int j=0; j<getColumnCount(); j++)
			result.set(i, j, get(i, j) + m.get(i, j));
		return result;
	}

	public Matrix inverse() throws SingularityException {
		if (getRowCount()!=getColumnCount()) throw new IllegalArgumentException("Matrix is not square");
		Jama.Matrix m=JamaBridge.toJama(this);
		try {
			m=m.inverse();
		} catch (RuntimeException e) {
			if ("Matrix is singular.".equals(e.getMessage()))
				throw new SingularityException();
			else
				throw e;
		}
		return JamaBridge.fromJama(m);
	}

	public Matrix pseudoInverse() {
		double threshold = 1E-15;
		SingularValueDecomposition svd = svd();
		Matrix D = svd.getS();
		for (int i = 0; i < D.getRowCount(); i++) {
			if (D.get(i, i) > threshold) D.set(i, i, 1 / D.get(i, i));
		}
		return svd.getV().transpose().mul(D).mul(svd.getU().transpose());
	}
	
	public Matrix transpose() {
		Matrix result = MatrixFactory.createMatrix(getColumnCount(), getRowCount());
		for (int i = 0; i < getRowCount(); i++)
			for (int j = 0; j < getColumnCount(); j++)
				result.set(j, i, get(i, j));
		return result;
	}

	public SingularValueDecomposition svd() {
		return new JamaSVD(this);
	}
}
