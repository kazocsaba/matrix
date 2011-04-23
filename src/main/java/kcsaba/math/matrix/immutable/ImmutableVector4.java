package kcsaba.math.matrix.immutable;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.Vector4;
import kcsaba.math.matrix.backbone.VectorOp;

/**
 * An immutable Vector4 implementation.
 * @author Kazó Csaba
 */
public class ImmutableVector4 extends ImmutableVector implements Vector4 {

	ImmutableVector4(Vector4 template) {
		super(template);
	}

	ImmutableVector4(ImmutableData data) {
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

	@Override
	public double getH() {
		return getCoord(3);
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

	/**
	 * Throws an exception and leaves the matrix unmodified.
	 * @param value the new value
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void setH(double value) {
		throw new UnsupportedOperationException("Matrix is read-only");
	}

	@Override
	public Vector4 plus(Matrix m) {
		return (Vector4) VectorOp.plus(this, m);
	}

	@Override
	public Vector4 minus(Matrix m) {
		return (Vector4) VectorOp.minus(this, m);
	}

	@Override
	public Vector4 times(double c) {
		return (Vector4) VectorOp.times(this, c);
	}
}
