package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix2;
import kcsaba.math.matrix.Vector2;

/**
 *
 * @author Kazó Csaba
 */
public class Matrix2Impl extends MatrixImpl<Matrix2> implements Matrix2 {

	public Matrix2Impl() {
		super(2, 2);
	}

	@Override
	public Matrix2 transpose() {
		return (Matrix2)super.transpose();
	}

	@Override
	public Vector2 mul(Vector2 v) {
		return (Vector2)super.mul(v);
	}

	@Override
	public Matrix2 mul(Matrix2 m) {
		return (Matrix2)super.mul(m);
	}

}
