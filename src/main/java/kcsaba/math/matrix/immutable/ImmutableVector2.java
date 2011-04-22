package kcsaba.math.matrix.immutable;

import kcsaba.math.matrix.Vector2;

/**
 *
 * @author Kazó Csaba
 */
public class ImmutableVector2 extends ImmutableVector<Vector2> implements Vector2 {

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
	
}
