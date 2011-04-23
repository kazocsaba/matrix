package kcsaba.math.matrix.immutable;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.Vector3;
import kcsaba.math.matrix.Vector4;
import kcsaba.math.matrix.backbone.Vector3Op;

/**
 * An immutable Vector3 implementation.
 * @author Kazó Csaba
 */
public class ImmutableVector3 extends ImmutableVector implements Vector3 {

	ImmutableVector3(Vector3 template) {
		super(template);
	}

	ImmutableVector3(ImmutableData data) {
		super(data);
	}

	@Override
	public double getX() {
		return getCoord(0);
	}

	@Override
	public double getY() {
		return getCoord(1);
	}

	@Override
	public double getZ() {
		return getCoord(2);
	}

	/**
	 * Throws an exception and leaves the matrix unmodified.
	 * @param value the new value
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void setX(double value) {
		throw new UnsupportedOperationException("Matrix is read-only");
	}

	/**
	 * Throws an exception and leaves the matrix unmodified.
	 * @param value the new value
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void setY(double value) {
		throw new UnsupportedOperationException("Matrix is read-only");
	}

	/**
	 * Throws an exception and leaves the matrix unmodified.
	 * @param value the new value
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void setZ(double value) {
		throw new UnsupportedOperationException("Matrix is read-only");
	}

	@Override
	public Vector4 toHomogeneous() {
		return Vector3Op.toHomogeneous(this);
	}

	@Override
	public Vector3 cross(Vector3 v) {
		return Vector3Op.cross(this, v);
	}

	@Override
	public Vector3 plus(Matrix m) {
		return (Vector3) Vector3Op.plus(this, m);
	}

	@Override
	public Vector3 minus(Matrix m) {
		return (Vector3) Vector3Op.minus(this, m);
	}

	@Override
	public Vector3 times(double c) {
		return (Vector3) Vector3Op.times(this, c);
	}
}
