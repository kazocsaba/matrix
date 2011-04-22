package kcsaba.math.matrix.backbone;

import kcsaba.math.matrix.MatrixFactory;
import kcsaba.math.matrix.Vector3;
import kcsaba.math.matrix.Vector4;

/**
 * A {@link MatrixData}-backed {@code Vector3} implementation.
 * <p>
 * This class is intended for subclassing to help the creation of implementations using specific {@code MatrixData}.
 * @author Kazó Csaba
 */
public class Vector3Impl extends VectorImpl<Vector3> implements Vector3 {

	/**
	 * Creates an instance with the specified backing data.
	 * @param data the backing data
	 * @throws NullPointerException if {@code data} is {@code null}
	 * @throws IllegalArgumentException if the type of this class does not match the dimensions of the backing data
	 */
	public Vector3Impl(MatrixData data) {
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
	public void setX(double value) {
		setCoord(0, value);
	}

	@Override
	public void setY(double value) {
		setCoord(1, value);
	}

	@Override
	public void setZ(double value) {
		setCoord(2, value);
	}

	@Override
	public Vector4 toHomogen() {
		return MatrixFactory.createVector4(getX(), getY(), getZ(), 1);
	}

	@Override
	public Vector3 cross(Vector3 v) {
		return MatrixFactory.createVector3(
				getY() * v.getZ() - getZ() * v.getY(),
				getZ() * v.getX() - getX() * v.getZ(),
				getX() * v.getY() - getY() * v.getX());
	}
	
}
