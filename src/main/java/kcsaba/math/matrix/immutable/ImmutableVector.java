package kcsaba.math.matrix.immutable;

import kcsaba.math.matrix.Vector;
import kcsaba.math.matrix.backbone.VectorOp;

/**
 * An immutable vector implementation.
 * @author Kazó Csaba
 */
public class ImmutableVector<V extends Vector<V>> extends ImmutableMatrix<V> implements Vector<V> {

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
}
