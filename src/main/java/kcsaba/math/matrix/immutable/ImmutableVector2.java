package kcsaba.math.matrix.immutable;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.Vector2;
import kcsaba.math.matrix.backbone.VectorOp;

/**
 *
 * @author Kazó Csaba
 */
public class ImmutableVector2 extends ImmutableVector implements Vector2 {

	ImmutableVector2(Vector2 template) {
		super(template);
	}

	ImmutableVector2(ImmutableData data) {
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

	@Override
	public Vector2 plus(Matrix m) {
		return (Vector2) VectorOp.plus(this, m);
	}

	@Override
	public Vector2 minus(Matrix m) {
		return (Vector2) VectorOp.minus(this, m);
	}

	@Override
	public Vector2 times(double c) {
		return (Vector2) VectorOp.times(this, c);
	}

	@Override
	public Vector2 normalized() {
		return (Vector2) VectorOp.normalized(this);
	}
}
