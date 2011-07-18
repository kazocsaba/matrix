package kcsaba.math.matrix.immutable;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.Matrix2;
import kcsaba.math.matrix.SingularityException;
import kcsaba.math.matrix.Vector2;

/**
 * An immutable Matrix2 implementation.
 * @author Kazó Csaba
 */
public class ImmutableMatrix2 extends ImmutableMatrix implements Matrix2 {

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

	@Override
	public Matrix2 plus(Matrix m) {
		return (Matrix2) super.plus(m);
	}

	@Override
	public Matrix2 minus(Matrix m) {
		return (Matrix2) super.minus(m);
	}

	@Override
	public Matrix2 times(double c) {
		return (Matrix2) super.times(c);
	}

	@Override
	public Matrix2 inverse() throws SingularityException {
		return (Matrix2) super.inverse();
	}

	@Override
	public Matrix2 normalized() {
		return (Matrix2) super.normalized();
	}
}
