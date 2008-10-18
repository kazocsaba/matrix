package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.MatrixFactory;
import kcsaba.math.matrix.SingularValueDecomposition;
import kcsaba.math.matrix.SingularityException;
import kcsaba.math.matrix.Vector;

/**
 *
 * @author Kazó Csaba
 */
class VectorImpl implements Vector {

	private final double[] data;

	public VectorImpl(int dimension) {
		data = new double[dimension];
	}

	@Override
	public int getDimension() {
		return data.length;
	}

	@Override
	public double getCoord(int index) {
		return data[index];
	}

	@Override
	public void setCoord(int index, double value) {
		data[index] = value;
	}

	@Override
	public double get(int row, int col) {
		if (col != 0) throw new IndexOutOfBoundsException();
		return data[row];
	}

	@Override
	public void set(int row, int col, double value) {
		if (col != 0) throw new IndexOutOfBoundsException();
		data[row] = value;
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Matrix mul(Matrix m) {
		if (m.getRowCount() != 1) throw new IllegalArgumentException();
		Matrix result = MatrixFactory.createMatrix(getRowCount(), m.getColumnCount());
		for (int row = 0; row < result.getRowCount(); row++)
			for (int col = 0; col < result.getColumnCount(); col++)
				result.set(row, col, data[row] * m.get(0, col));
		return result;
	}

	@Override
	public void scale(double c) {
		for (int i = 0; i < data.length; i++)
			data[i] *= c;
	}

	@Override
	public void add(Matrix m) {
		if (m.getColumnCount() != 1 || m.getRowCount() != data.length) throw new IllegalArgumentException();
		for (int i = 0; i < data.length; i++)
			data[i] += m.get(i, 0);
	}

	@Override
	public Matrix getSubmatrix(int row1, int row2, int col1, int col2) {
		if (col1 != 1 || col2 != 1 || row1 < 0 || row2 >= data.length || row2 < row1)
			throw new IllegalArgumentException();
		Vector result = MatrixFactory.createVector(row2 - row1 + 1);
		for (int i = 0; i < row2 - row1 + 1; i++)
			result.setCoord(i, data[row1 + i]);
		return result;
	}

	@Override
	public double dot(Vector v) {
		if (getDimension() != v.getDimension()) throw new IllegalArgumentException();
		double result = 0;
		for (int i = 0; i < getDimension(); i++)
			result += getCoord(i) * v.getCoord(i);
		return result;
	}

	@Override
	public Matrix plus(Matrix m) {
		if (getRowCount() != m.getRowCount() || 1 != m.getColumnCount())
			throw new IllegalArgumentException();
		Vector result=MatrixFactory.createVector(getRowCount());
		for (int i=0; i<getRowCount(); i++)
			result.setCoord(i,getCoord(i) + m.get(i, 0));
		return result;
	}

	@Override
	public Matrix inverse() throws SingularityException {
		if (getRowCount() == 1) {
			if (get(0, 0) == 0)
				throw new SingularityException();
			else {
				Vector result = MatrixFactory.createVector(1);
				result.set(0, 0, 1 / get(0, 0));
				return result;
			}
		} else
			throw new IllegalArgumentException();
	}

	@Override
	public Matrix transpose() {
		Matrix result = MatrixFactory.createMatrix(1, getDimension());
		for (int i = 0; i < getDimension(); i++)
			result.set(0, i, getCoord(i));
		return result;
	}
	
	@Override
	public double determinant() {
		if (getRowCount()!=1) throw new IllegalArgumentException("Matrix is not square");
		return getCoord(0);
	}
	
	@Override
	public SingularValueDecomposition svd() {
		return new JamaSVD(this);
	}

	@Override
	public Matrix pseudoInverse() {
		double threshold = 1E-15;
		double lenSq = 0;
		for (int i = 0; i < getDimension(); i++)
			lenSq += getCoord(i) * getCoord(i);
		Matrix result = MatrixFactory.createMatrix(1, getDimension());
		if (lenSq < threshold)
			return result;
		for (int i = 0; i < getDimension(); i++)
			result.set(0, i, getCoord(i) / lenSq);
		return result;

	}
}
