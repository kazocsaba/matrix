package kcsaba.math.matrix.backbone;

import kcsaba.math.matrix.Matrix3;
import kcsaba.math.matrix.Vector3;

/**
 * A {@link MatrixData}-backed {@code Matrix3} implementation.
 * <p>
 * This class is intended for subclassing to help the creation of implementations using specific {@code MatrixData}.
 * @author Kazó Csaba
 */
public class Matrix3Impl extends MatrixImpl<Matrix3> implements Matrix3 {

	/**
	 * Creates an instance with the specified backing data.
	 * @param data the backing data
	 * @throws NullPointerException if {@code data} is {@code null}
	 * @throws IllegalArgumentException if the type of this class does not match the dimensions of the backing data
	 */
	public Matrix3Impl(MatrixData data) {
		super(data);
	}

	@Override
	public Matrix3 transpose() {
		return (Matrix3) super.transpose();
	}

	@Override
	public Vector3 mul(Vector3 v) {
		return (Vector3) super.mul(v);
	}

	@Override
	public Matrix3 mul(Matrix3 m) {
		return (Matrix3) super.mul(m);
	}
}
