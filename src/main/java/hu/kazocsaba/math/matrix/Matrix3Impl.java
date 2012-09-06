package hu.kazocsaba.math.matrix;

import hu.kazocsaba.math.matrix.backbone.MatrixOp;

/**
 *
 * @author Kazó Csaba
 */
class Matrix3Impl extends MatrixImpl implements Matrix3 {

	public Matrix3Impl() {
		super(3, 3);
	}

	@Override
	public Matrix3 transpose() {
		return (Matrix3)super.transpose();
	}

	@Override
	public Matrix3 transposedView() {
		return (Matrix3)super.transposedView();
	}

	@Override
	public Vector3 mul(Vector3 v) {
		return (Vector3)super.mul(v);
	}

	@Override
	public Matrix3 mul(Matrix3 m) {
		return (Matrix3)super.mul(m);
	}

	@Override
	public Matrix3 inverse() throws SingularityException {
		return (Matrix3)super.inverse();
	}

	@Override
	public Matrix3 times(double c) {
		return (Matrix3)super.times(c);
	}

	@Override
	public Matrix3 minus(Matrix m) {
		return (Matrix3)super.minus(m);
	}

	@Override
	public Matrix3 plus(Matrix m) {
		return (Matrix3)super.plus(m);
	}

	@Override
	public Matrix3 normalized() {
		return (Matrix3)super.normalized();
	}
	
	@Override
	public SubmatrixAccessor3 getSub() {
		return MatrixOp.getSub(this);
	}

	@Override
	public SubmatrixAccessor3 viewSub() {
		return MatrixOp.viewSub(this);
	}
}
