package kcsaba.math.matrix.immutable;

import kcsaba.math.matrix.Matrix2;
import kcsaba.math.matrix.Vector2;

/**
 * An immutable Matrix2 implementation.
 * @author Kazó Csaba
 */
public class ImmutableMatrix2 extends ImmutableMatrix<Matrix2> implements Matrix2 {

	ImmutableMatrix2(Matrix2 template) {
		super(template);
	}

	ImmutableMatrix2(ImmutableData data) {
		super(data);
	}

	@Override
	public Matrix2 transpose() {
		return (Matrix2) super.transpose();
	}

	@Override
	public Vector2 mul(Vector2 v) {
		return (Vector2) super.mul(v);
	}

	@Override
	public Matrix2 mul(Matrix2 m) {
		return (Matrix2) super.mul(m);
	}
}
