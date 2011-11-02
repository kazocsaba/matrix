package hu.kazocsaba.math.matrix.immutable;

import hu.kazocsaba.math.matrix.Matrix;
import hu.kazocsaba.math.matrix.Vector2;
import hu.kazocsaba.math.matrix.backbone.VectorOp;

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
