package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.MatrixFactory;
import kcsaba.math.matrix.Vector;
import kcsaba.math.matrix.Vector2;
import kcsaba.math.matrix.Vector3;
import kcsaba.math.matrix.Vector4;

/**
 *
 * @author Kazó Csaba
 */
public class MatrixFactoryImpl extends MatrixFactory {

	@Override
	protected Vector2 _createVector2() {
		return new Vector2Impl();
	}

	@Override
	protected Vector3 _createVector3() {
		return new Vector3Impl();
	}

	@Override
	protected Vector4 _createVector4() {
		return new Vector4Impl();
	}

	@Override
	protected Vector _createVector(int dimension) {
		return new VectorImpl(dimension);
	}

	@Override
	protected Matrix _createMatrix(int rowCount, int colCount) {
		return new MatrixImpl(rowCount, colCount);
	}

}
