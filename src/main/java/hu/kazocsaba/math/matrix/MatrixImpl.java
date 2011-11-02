package hu.kazocsaba.math.matrix;

import hu.kazocsaba.math.matrix.backbone.MatrixOp;

/**
 *
 * @author Kazó Csaba
 */
class MatrixImpl implements Matrix {

	private final double[][] data;

	MatrixImpl(int rowCount, int colCount) {
		data = new double[rowCount][colCount];
	}

	@Override
	public double get(int row, int col) {
		return data[row][col];
	}

	@Override
	public void set(int row, int col, double value) {
		data[row][col] = value;
	}

	@Override
	public int getColumnCount() {
		return data[0].length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public Matrix mul(Matrix m) {
		return MatrixOp.mul(this, m);
	}

	@Override
	public void scale(double c) {
		MatrixOp.scale(this, c);
	}

	@Override
	public Matrix times(double c) {
		return MatrixOp.times(this, c);
	}

	@Override
	public void add(Matrix m) {
		MatrixOp.add(this, m);
	}

	@Override
	public void subtract(Matrix m) {
		MatrixOp.subtract(this, m);
	}

	@Override
	public Matrix getSubmatrix(int row1, int row2, int col1, int col2) {
		return MatrixOp.getSubmatrix(this, row1, row2, col1, col2);
	}

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
	public double norm() {
		return MatrixOp.norm(this);
	}

	@Override
	public double error(Matrix m) {
		return MatrixOp.error(this, m);
	}

	@Override
	public void normalize() {
		MatrixOp.normalize(this);
	}

	@Override
	public Matrix normalized() {
		return MatrixOp.normalized(this);
	}
	
}