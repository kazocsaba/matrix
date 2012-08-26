package hu.kazocsaba.math.matrix.immutable;

import hu.kazocsaba.math.matrix.EigenDecomposition;
import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.SingularValueDecomposition;
import hu.kazocsaba.math.matrix.SingularityException;
import hu.kazocsaba.math.matrix.Vector;
import hu.kazocsaba.math.matrix.backbone.MatrixOp;

/**
 * An immutable matrix implementation.
 * @author Kazó Csaba
 */
public class ImmutableMatrix implements Matrix {
	private final ImmutableData data;

	ImmutableMatrix(Matrix template) {
		this(new ImmutableDataImpl(template));
	}

	ImmutableMatrix(ImmutableData data) {
		this.data = data;
	}

	@Override
	public double get(int row, int col) {
		return data.get(row, col);
	}

	@Override
	public double getQuick(int row, int col) {
		return data.getQuick(row, col);
	}

	/**
	 * Throws an exception and leaves the matrix unmodified.
	 * @param row the row index
	 * @param col the column index
	 * @param value the new value
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void set(int row, int col, double value) {
		throw new UnsupportedOperationException("Matrix is read-only");
	}

	/**
	 * Throws an exception and leaves the matrix unmodified.
	 * @param row the row index
	 * @param col the column index
	 * @param value the new value
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void setQuick(int row, int col, double value) {
		throw new UnsupportedOperationException("Matrix is read-only");
	}

	@Override
	public int getColumnCount() {
		return data.getColumnCount();
	}

	@Override
	public int getRowCount() {
		return data.getRowCount();
	}
	@Override
	public Matrix mul(Matrix m) {
		return MatrixOp.mul(this, m);
	}

	@Override
	public Vector mul(Vector v) {
		return (Vector)MatrixOp.mul(this, v);
	}

	/**
	 * Throws an exception and leaves the matrix unmodified.
	 * @param c the scalar factor
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void scale(double c) {
		MatrixOp.scale(this, c);
	}

	@Override
	public Matrix times(double c) {
		return MatrixOp.times(this, c);
	}

	/**
	 * Throws an exception and leaves the matrix unmodified.
	 * @param m the other matrix
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void add(Matrix m) {
		MatrixOp.add(this, m);
	}

	/**
	 * Throws an exception and leaves the matrix unmodified.
	 * @param m the other matrix
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void subtract(Matrix m) {
		MatrixOp.subtract(this, m);
	}

	@Override
	public Matrix getSubmatrix(int row1, int row2, int col1, int col2) {
		return MatrixOp.getSubmatrix(this, row1, row2, col1, col2);
	}

	/**
	 * Throws an exception and leaves the matrix unmodified.
	 * @param m the matrix to copy elements from
	 * @param row the row to copy the first row of {@code m} to
	 * @param col the column to copy the first column of {@code m} to
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void setSubmatrix(Matrix m, int row, int col) {
		MatrixOp.setSubmatrix(this, m, row, col);
	}

	@Override
	public Matrix plus(Matrix m) {
		return MatrixOp.plus(this, m);
	}

	@Override
	public Matrix minus(Matrix m) {
		return MatrixOp.minus(this, m);
	}

	@Override
	public Matrix inverse() throws SingularityException {
		return MatrixOp.inverse(this);
	}

	@Override
	public Matrix pseudoInverse() {
		return MatrixOp.pseudoInverse(this);
	}
	
	@Override
	public Matrix transpose() {
		return MatrixOp.transpose(this);
	}

	@Override
	public double determinant() {
		return MatrixOp.determinant(this);
	}
	
	@Override
	public SingularValueDecomposition svd() {
		return MatrixOp.svd(this);
	}

	@Override
	public EigenDecomposition eig() {
		return MatrixOp.eig(this);
	}

	@Override
	public double norm() {
		return MatrixOp.norm(this);
	}

	@Override
	public double error(Matrix m) {
		return MatrixOp.error(this, m);
	}

	@Override
	public void normalize() {
		throw new UnsupportedOperationException("Matrix is read-only");
	}

	@Override
	public Matrix normalized() {
		return MatrixOp.normalized(this);
	}
}
