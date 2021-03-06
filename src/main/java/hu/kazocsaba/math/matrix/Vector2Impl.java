package hu.kazocsaba.math.matrix;

import hu.kazocsaba.math.matrix.backbone.VectorOp;

/**
 *
 * @author Kazó Csaba
 */
class Vector2Impl implements Vector2 {
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
	public double getCoordQuick(int index) {
		if (index==0)
			return x;
		else
			return y;
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
	public void setCoordQuick(int index, double value) {
		if (index==0)
			x=value;
		else
			y=value;
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
	public double getQuick(int row, int col) {
		return getCoordQuick(row);
	}

	@Override
	public void set(int row, int col, double value) {
		if (col!=0) throw new IllegalArgumentException();
		setCoord(row, value);
	}

	@Override
	public void setQuick(int row, int col, double value) {
		setCoordQuick(row, value);
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
			result.setQuick(0, col, x*m.getQuick(0, col));
			result.setQuick(1, col, y*m.getQuick(0, col));
		}
		return result;
	}

	@Override
	public Vector mul(Vector v) {
		if (v.getRowCount()!=1) throw new IllegalArgumentException();
		return this.times(v.getQuick(0, 0));
	}

	@Override
	public void scale(double c) {
		x*=c;
		y*=c;
	}

	@Override
	public Vector2 times(double c) {
		return MatrixFactory.createVector(x * c, y * c);
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
	public Vector2 plus(Matrix m) {
		if (m.getColumnCount()!=1 || m.getRowCount()!=2) throw new IllegalArgumentException();
		Vector2 v=(Vector2)m;
		return MatrixFactory.createVector(x+v.getX(), y+v.getY());
	}

	@Override
	public Vector2 minus(Matrix m) {
		if (m.getColumnCount()!=1 || m.getRowCount()!=2) throw new IllegalArgumentException();
		Vector2 v=(Vector2)m;
		return MatrixFactory.createVector(x-v.getX(), y-v.getY());
	}

	@Override
	public Matrix getSubmatrix(int row1, int row2, int col1, int col2) {
		if (col1==0 && col2==0) {
			if (row1==0 && row2==1) return MatrixFactory.copy(this);
			if (row1==row2) {
				double value=getCoord(row1);
				Vector result=MatrixFactory.createVector(1);
				result.setCoordQuick(0, value);
				return result;
			}
		}
		throw new IllegalArgumentException();
	}

	@Override
	public SubmatrixAccessor getSub() {
		return VectorOp.getSub(this);
	}

	@Override
	public SubmatrixAccessor viewSub() {
		return VectorOp.viewSub(this);
	}

	@Override
	public void setSubmatrix(Matrix m, int row, int col) {
		if (col!=0 || m.getColumnCount()>1 || row<0 || row+m.getRowCount()>2)
			throw new IllegalArgumentException();
		if (m.getColumnCount()>1 || m.getRowCount()>2) throw new IllegalArgumentException();
		setCoordQuick(row, m.getQuick(0, 0));
		if (m.getRowCount()==2)
			y=((Vector2)m).getY();
	}

	@Override
	public Matrix inverse() throws SingularityException {
		return VectorOp.inverse(this);
	}

	@Override
	public Matrix pseudoInverse() {
		return VectorOp.pseudoInverse(this);
	}

	@Override
	public Matrix transpose() {
		Matrix result=MatrixFactory.createMatrix(1, 2);
		result.setQuick(0, 0, x);
		result.setQuick(0, 1, y);
		return result;
	}

	@Override
	public Matrix transposedView() {
		return VectorOp.transposedView(this);
	}

	@Override
	public Vector3 toHomogeneous() {
		return MatrixFactory.createVector(x, y, 1);
	}

	@Override
	public Vector fromHomogeneous() {
		return VectorOp.fromHomogeneous(this);
	}

	@Override
	public double determinant() {
		return VectorOp.determinant(this);
	}

	@Override
	public double norm() {
		return Math.hypot(x, y);
	}

	@Override
	public SingularValueDecomposition svd() {
		return VectorOp.svd(this);
	}

	@Override
	public EigenDecomposition eig() {
		return VectorOp.eig(this);
	}

	@Override
	public String toString() {
		return VectorOp.toString(this);
	}

	@Override
	public Vector2 normalized() {
		return (Vector2) VectorOp.normalized(this);
	}

	@Override
	public double error(Matrix m) {
		return VectorOp.error(this, m);
	}

	@Override
	public void normalize() {
		VectorOp.normalize(this);
	}
	
	@Override
	public boolean equals(Object obj) {
		return VectorOp.equals(this, obj);
	}

	@Override
	public int hashCode() {
		return VectorOp.hashCode(this);
	}
}
