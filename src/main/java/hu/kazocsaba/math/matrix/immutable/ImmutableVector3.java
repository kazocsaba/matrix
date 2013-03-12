package hu.kazocsaba.math.matrix.immutable;

import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.Vector2;
import hu.kazocsaba.math.matrix.Vector3;
import hu.kazocsaba.math.matrix.Vector4;
import hu.kazocsaba.math.matrix.backbone.Vector3Op;

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
		return getCoordQuick(0);
	}

	@Override
	public double getY() {
		return getCoordQuick(1);
	}

	@Override
	public double getZ() {
		return getCoordQuick(2);
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
		return (Vector4)Vector3Op.toHomogeneous(this);
	}

	@Override
	public Vector2 fromHomogeneous() {
		return (Vector2)Vector3Op.fromHomogeneous(this);
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

	@Override
	public Vector3 normalized() {
		return (Vector3) Vector3Op.normalized(this);
	}
}
