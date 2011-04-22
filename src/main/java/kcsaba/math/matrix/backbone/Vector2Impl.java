package kcsaba.math.matrix.backbone;

import kcsaba.math.matrix.Vector2;

/**
 * A {@link MatrixData}-backed {@code Vector2} implementation.
 * <p>
 * This class is intended for subclassing to help the creation of implementations using specific {@code MatrixData}.
 * @author Kazó Csaba
 */
public class Vector2Impl extends VectorImpl<Vector2> implements Vector2 {

	/**
	 * Creates an instance with the specified backing data.
	 * @param data the backing data
	 * @throws NullPointerException if {@code data} is {@code null}
	 * @throws IllegalArgumentException if the type of this class does not match the dimensions of the backing data
	 */
	public Vector2Impl(MatrixData data) {
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
	public void setX(double value) {
		setCoord(0, value);
	}

	@Override
	public void setY(double value) {
		setCoord(1, value);
	}
	
}
