package hu.kazocsaba.math.matrix;

import hu.kazocsaba.math.matrix.backbone.MatrixOp;

/**
 *
 * @author Kazó Csaba
 */
class Matrix2Impl extends MatrixImpl implements Matrix2 {

	public Matrix2Impl() {
		super(2, 2);
	}

	@Override
	public Matrix2 transpose() {
		return (Matrix2)super.transpose();
	}

	@Override
	public Matrix2 transposedView() {
		return (Matrix2)super.transposedView();
	}

	@Override
	public Vector2 mul(Vector2 v) {
		return (Vector2)super.mul(v);
	}

	@Override
	public Matrix2 mul(Matrix2 m) {
		return (Matrix2)super.mul(m);
	}

	@Override
	public Matrix2 inverse() throws SingularityException {
		return (Matrix2)super.inverse();
	}

	@Override
	public Matrix2 times(double c) {
		return (Matrix2)super.times(c);
	}

	@Override
	public Matrix2 minus(Matrix m) {
		return (Matrix2)super.minus(m);
	}

	@Override
	public Matrix2 plus(Matrix m) {
		return (Matrix2)super.plus(m);
	}

	@Override
	public Matrix2 normalized() {
		return (Matrix2)super.normalized();
	}

	@Override
	public SubmatrixAccessor2 getSub() {
		return MatrixOp.getSub(this);
	}

	@Override
	public SubmatrixAccessor2 viewSub() {
		return MatrixOp.viewSub(this);
	}
	
}
