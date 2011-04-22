package kcsaba.math.matrix.backbone;

import kcsaba.math.matrix.Matrix2;
import kcsaba.math.matrix.Vector2;

/**
 * A {@link MatrixData}-backed {@code Matrix2} implementation.
 * <p>
 * This class is intended for subclassing to help the creation of implementations using specific {@code MatrixData}.
 * @author Kazó Csaba
 */
public class Matrix2Impl extends MatrixImpl<Matrix2> implements Matrix2 {

	/**
	 * Creates an instance with the specified backing data.
	 * @param data the backing data
	 * @throws NullPointerException if {@code data} is {@code null}
	 * @throws IllegalArgumentException if the type of this class does not match the dimensions of the backing data
	 */
	public Matrix2Impl(MatrixData data) {
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
}
