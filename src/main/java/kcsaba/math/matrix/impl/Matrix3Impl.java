package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix3;
import kcsaba.math.matrix.Vector3;

/**
 *
 * @author Kazó Csaba
 */
public class Matrix3Impl extends MatrixImpl<Matrix3> implements Matrix3 {

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

}
