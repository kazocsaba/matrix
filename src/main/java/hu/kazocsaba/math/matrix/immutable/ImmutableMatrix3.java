package hu.kazocsaba.math.matrix.immutable;

import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.Matrix3;
import hu.kazocsaba.math.matrix.SingularityException;
import hu.kazocsaba.math.matrix.Vector3;

/**
 * An immutable Matrix3 implementation.
 * @author Kazó Csaba
 */
public class ImmutableMatrix3 extends ImmutableMatrix implements Matrix3 {

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
	public ImmutableMatrix3 transposedView() {
		return (ImmutableMatrix3)super.transposedView();
	}

	@Override
	public Vector3 mul(Vector3 v) {
		return (Vector3) super.mul(v);
	}

	@Override
	public Matrix3 mul(Matrix3 m) {
		return (Matrix3) super.mul(m);
	}

	@Override
	public Matrix3 plus(Matrix m) {
		return (Matrix3) super.plus(m);
	}

	@Override
	public Matrix3 minus(Matrix m) {
		return (Matrix3) super.minus(m);
	}

	@Override
	public Matrix3 times(double c) {
		return (Matrix3) super.times(c);
	}

	@Override
	public Matrix3 inverse() throws SingularityException {
		return (Matrix3) super.inverse();
	}

	@Override
	public Matrix3 normalized() {
		return (Matrix3) super.normalized();
	}
}
