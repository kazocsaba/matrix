package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.MatrixFactory;
import kcsaba.math.matrix.SingularValueDecomposition;
import kcsaba.math.matrix.SingularityException;
import kcsaba.math.matrix.Vector;
import kcsaba.math.matrix.backbone.VectorOp;

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
	public Vector times(double c) {
		Vector result=(Vector)MatrixFactory.createVector(getDimension());
		for (int i = 0; i < data.length; i++)
			result.setCoord(i, data[i] * c);
		return result;
	}

	@Override
	public void add(Matrix m) {
		if (m.getColumnCount() != 1 || m.getRowCount() != data.length) throw new IllegalArgumentException();
		for (int i = 0; i < data.length; i++)
			data[i] += m.get(i, 0);
	}

	@Override
	public void subtract(Matrix m) {
		if (m.getColumnCount() != 1 || m.getRowCount() != data.length) throw new IllegalArgumentException();
		for (int i = 0; i < data.length; i++)
			data[i] -= m.get(i, 0);
	}

	@Override
	public Matrix getSubmatrix(int row1, int row2, int col1, int col2) {
		if (col1 != 0 || col2 != 0 || row1 < 0 || row2 >= data.length || row2 < row1)
			throw new IllegalArgumentException();
		Vector result = MatrixFactory.createVector(row2 - row1 + 1);
		for (int i = 0; i < row2 - row1 + 1; i++)
			result.setCoord(i, data[row1 + i]);
		return result;
	}

	@Override
	public void setSubmatrix(Matrix m, int row, int col) {
		if (col!=0 || m.getColumnCount()>1 || row<0 || row+m.getRowCount()>getDimension())
			throw new IllegalArgumentException();
		for (int r=0; r<m.getRowCount(); r++)
			setCoord(row+r, m.get(r, 0));
	}

	@Override
	public double dot(Vector v) {
		return VectorOp.dot(this, v);
	}

	@Override
	public Vector plus(Matrix m) {
		return (Vector)VectorOp.plus(this, m);
	}

	@Override
	public Vector minus(Matrix m) {
		return (Vector)VectorOp.minus(this, m);
	}

	@Override
	public Matrix inverse() throws SingularityException {
		return (Matrix)VectorOp.inverse(this);
	}

	@Override
	public Matrix transpose() {
		return VectorOp.transpose(this);
	}
	
	@Override
	public double determinant() {
		return VectorOp.determinant(this);
	}
	
	@Override
	public SingularValueDecomposition svd() {
		return VectorOp.svd(this);
	}

	@Override
	public Matrix pseudoInverse() {
		return VectorOp.pseudoInverse(this);

	}

	@Override
	public double norm() {
		return VectorOp.norm(this);
	}

	@Override
	public String toString() {
		return VectorOp.toString(this);
	}
	
}
