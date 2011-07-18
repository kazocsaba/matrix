package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.Matrix3;
import kcsaba.math.matrix.SingularityException;
import kcsaba.math.matrix.Vector3;

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
}
