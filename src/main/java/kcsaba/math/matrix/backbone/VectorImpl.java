package kcsaba.math.matrix.backbone;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.MatrixFactory;
import kcsaba.math.matrix.SingularityException;
import kcsaba.math.matrix.Vector;

/**
 * A {@link MatrixData}-backed {@code Vector} implementation.
 * <p>
 * This class is intended for subclassing to help the creation of implementations using specific {@code MatrixData}.
 * @author Kazó Csaba
 */
public class VectorImpl<V extends Vector<V>> extends MatrixImpl<V> implements Vector<V> {

	/**
	 * Creates an instance with the specified backing data.
	 * @param data the backing data
	 * @throws NullPointerException if {@code data} is {@code null}
	 * @throws IllegalArgumentException if the type of this class does not match the dimensions of the backing data
	 */
	public VectorImpl(MatrixData data) {
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

	@Override
	public void setCoord(int index, double value) {
		set(index, 0, value);
	}

	@Override
	public V inverse() throws SingularityException {
		if (getRowCount() == 1) {
			if (get(0, 0) == 0)
				throw new SingularityException();
			else {
				V result = (V) MatrixFactory.createVector(1);
				result.set(0, 0, 1 / get(0, 0));
				return result;
			}
		} else
			throw new IllegalArgumentException();
	}

	@Override
	public double determinant() {
		if (getRowCount() != 1) throw new IllegalArgumentException("Matrix is not square");
		return getCoord(0);
	}

	@Override
	public Matrix pseudoInverse() {
		double threshold = 1E-15;
		double lenSq = 0;
		for (int i = 0; i < getDimension(); i++)
			lenSq += getCoord(i) * getCoord(i);
		Matrix result = MatrixFactory.createMatrix(1, getDimension());
		if (lenSq < threshold)
			return result;
		for (int i = 0; i < getDimension(); i++)
			result.set(0, i, getCoord(i) / lenSq);
		return result;

	}

	@Override
	public double dot(Vector v) {
		if (getDimension() != v.getDimension()) throw new IllegalArgumentException();
		double result = 0;
		for (int i = 0; i < getDimension(); i++)
			result += getCoord(i) * v.getCoord(i);
		return result;
	}
}
