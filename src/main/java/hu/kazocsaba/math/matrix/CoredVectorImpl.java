package hu.kazocsaba.math.matrix;

import hu.kazocsaba.math.matrix.backbone.VectorOp;

/**
 *
 * @author Kazó Csaba
 */
class CoredVectorImpl extends CoredMatrixImpl implements Vector {
	CoredVectorImpl(MatrixCore core) {
		super(core);
	}

	@Override
	public int getDimension() {
		return getRowCount();
	}

	@Override
	public double getCoord(int index) {
		return get(index, 0);
	}

	@Override
	public double getCoordQuick(int index) {
		return getQuick(index, 0);
	}

	@Override
	public void setCoord(int index, double value) {
		set(index, 0, value);
	}

	@Override
	public void setCoordQuick(int index, double value) {
		setQuick(index, 0, value);
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
	public Vector times(double c) {
		return (Vector)VectorOp.times(this, c);
	}

	@Override
	public Vector normalized() {
		return (Vector)VectorOp.normalized(this);
	}

	@Override
	public Vector toHomogeneous() {
		return VectorOp.toHomogeneous(this);
	}
}
