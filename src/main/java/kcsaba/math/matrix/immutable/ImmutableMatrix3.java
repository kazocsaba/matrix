package kcsaba.math.matrix.immutable;

import kcsaba.math.matrix.Matrix3;
import kcsaba.math.matrix.Vector3;

/**
 * An immutable Matrix3 implementation.
 * @author Kazó Csaba
 */
public class ImmutableMatrix3 extends ImmutableMatrix<Matrix3> implements Matrix3 {

	ImmutableMatrix3(Matrix3 template) {
		super(template);
	}

	ImmutableMatrix3(ImmutableData data) {
		super(data);
	}

	@Override
	public Matrix3 transpose() {
		return (Matrix3) super.transpose();
	}

	@Override
	public Vector3 mul(Vector3 v) {
		return (Vector3) super.mul(v);
	}

	@Override
	public Matrix3 mul(Matrix3 m) {
		return (Matrix3) super.mul(m);
	}
}
