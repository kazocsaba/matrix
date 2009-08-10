package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.MatrixFactory;
import kcsaba.math.matrix.SingularValueDecomposition;
import kcsaba.math.matrix.SingularityException;
import kcsaba.math.matrix.Vector;
import kcsaba.math.matrix.Vector2;

/**
 *
 * @author Kazó Csaba
 */
public class Vector2Impl implements Vector2 {
	private double x, y;

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public void setX(double value) {
		x=value;
	}

	@Override
	public void setY(double value) {
		y=value;
	}

	@Override
	public Vector2 plusVec(Vector2 v) {
		return MatrixFactory.createVector2(x+v.getX(), y+v.getY());
	}

	@Override
	public Vector2 minusVec(Vector2 v) {
		return MatrixFactory.createVector2(x-v.getX(), y-v.getY());
	}

	@Override
	public int getDimension() {
		return 2;
	}

	@Override
	public double getCoord(int index) {
		switch (index) {
			case 0: return x;
			case 1: return y;
			default: throw new IllegalArgumentException();
		}
	}

	@Override
	public void setCoord(int index, double value) {
		switch (index) {
			case 0: x=value; break;
			case 1: y=value; break;
			default: throw new IllegalArgumentException();
		}
	}

	@Override
	public double dot(Vector v) {
		if (v.getDimension()!=2) throw new IllegalArgumentException();
		Vector2 v2=(Vector2)v;
		return x*v2.getX()+y*v2.getY();
	}

	@Override
	public double get(int row, int col) {
		if (col!=0) throw new IllegalArgumentException();
		return getCoord(row);
	}

	@Override
	public void set(int row, int col, double value) {
		if (col!=0) throw new IllegalArgumentException();
		setCoord(row, value);
	}

	@Override
	public int getColumnCount() {
		return 1;
	}

	@Override
	public int getRowCount() {
		return 2;
	}

	@Override
	public Matrix mul(Matrix m) {
		if (m.getRowCount()!=1) throw new IllegalArgumentException();
		Matrix result=MatrixFactory.createMatrix(2, m.getColumnCount());
		for (int col=0; col<result.getColumnCount(); col++) {
			result.set(0, col, x*m.get(0, col));
			result.set(1, col, y*m.get(0, col));
		}
		return result;
	}

	@Override
	public void scale(double c) {
		x*=c;
		y*=c;
	}

	@Override
	public void add(Matrix m) {
		if (m.getColumnCount()!=1 || m.getRowCount()!=2) throw new IllegalArgumentException();
		Vector2 v=(Vector2)m;
		x+=v.getX();
		y+=v.getY();
	}

	@Override
	public void subtract(Matrix m) {
		if (m.getColumnCount()!=1 || m.getRowCount()!=2) throw new IllegalArgumentException();
		Vector2 v=(Vector2)m;
		x-=v.getX();
		y-=v.getY();
	}

	@Override
	public Matrix plus(Matrix m) {
		if (m.getColumnCount()!=1 || m.getRowCount()!=2) throw new IllegalArgumentException();
		Vector2 v=(Vector2)m;
		return MatrixFactory.createVector2(x+v.getX(), y+v.getY());
	}

	@Override
	public Matrix minus(Matrix m) {
		if (m.getColumnCount()!=1 || m.getRowCount()!=2) throw new IllegalArgumentException();
		Vector2 v=(Vector2)m;
		return MatrixFactory.createVector2(x-v.getX(), y-v.getY());
	}

	@Override
	public Matrix getSubmatrix(int row1, int row2, int col1, int col2) {
		if (col1==0 && col2==0) {
			if (row1==0 && row2==1) return MatrixFactory.createVector2(this);
			if (row1==row2) {
				double value=getCoord(row1);
				Vector result=MatrixFactory.createVector(1);
				result.setCoord(0, value);
				return result;
			}
		}
		throw new IllegalArgumentException();
	}

	@Override
	public void setSubmatrix(Matrix m, int row, int col) {
		if (col!=0 || m.getColumnCount()>1 || row<0 || row+m.getRowCount()>2)
			throw new IllegalArgumentException();
		if (m.getColumnCount()>1 || m.getRowCount()>2) throw new IllegalArgumentException();
		setCoord(row, m.get(0, 0));
		if (m.getRowCount()==2)
			y=((Vector2)m).getY();
	}

	@Override
	public Matrix inverse() throws SingularityException {
		throw new IllegalArgumentException();
	}

	@Override
	public Matrix pseudoInverse() {
		double threshold = 1E-15;
		double lenSq = x*x+y*y;
		Matrix result = MatrixFactory.createMatrix(1, 2);
		if (lenSq < threshold)
			return result;
		result.set(0, 0, x/lenSq);
		result.set(0, 1, y/lenSq);
		return result;
	}

	@Override
	public Matrix transpose() {
		Matrix result=MatrixFactory.createMatrix(1, 2);
		result.set(0, 0, x);
		result.set(0, 1, y);
		return result;
	}

	@Override
	public double determinant() {
		throw new IllegalArgumentException("Matrix is not square");
	}

	@Override
	public double norm() {
		return Math.sqrt(x*x+y*y);
	}

	@Override
	public SingularValueDecomposition svd() {
		return new JamaSVD(this);
	}
}
