package kcsaba.math.matrix.immutable;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.Vector;
import kcsaba.math.matrix.backbone.VectorOp;

/**
 * An immutable vector implementation.
 * @author Kazó Csaba
 */
public class ImmutableVector extends ImmutableMatrix implements Vector {

	ImmutableVector(Vector template) {
		super(template);
	}

	ImmutableVector(ImmutableData data) {
		super(data);
	}

	@Override
	public int getDimension() {
		return getRowCount();
	}

	@Override
	public double getCoord(int index) {
		return get(index, 0);
	}

	/**
	 * Throws an exception and leaves the matrix unmodified.
	 * @param index the coordinate to set
	 * @param value the new value
	 * @throws UnsupportedOperationException always
	 */
	@Override
	public void setCoord(int index, double value) {
		throw new UnsupportedOperationException("Matrix is read-only");
	}

	@Override
	public double dot(Vector v) {
		return VectorOp.dot(this, v);
	}

	@Override
	public String toString() {
		return VectorOp.toString(this);
	}

	@Override
	public Vector plus(Matrix m) {
		return (Vector) VectorOp.plus(this, m);
	}

	@Override
	public Vector minus(Matrix m) {
		return (Vector) VectorOp.minus(this, m);
	}

	@Override
	public Vector times(double c) {
		return (Vector) VectorOp.times(this, c);
	}
}
