package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.Matrix2;
import kcsaba.math.matrix.Matrix3;
import kcsaba.math.matrix.MatrixFactory;
import kcsaba.math.matrix.Vector;
import kcsaba.math.matrix.Vector2;
import kcsaba.math.matrix.Vector3;
import kcsaba.math.matrix.Vector4;
import kcsaba.math.matrix.backbone.Matrix2Impl;
import kcsaba.math.matrix.backbone.Matrix3Impl;
import kcsaba.math.matrix.backbone.MatrixImpl;
import kcsaba.math.matrix.backbone.Vector2Impl;
import kcsaba.math.matrix.backbone.Vector3Impl;
import kcsaba.math.matrix.backbone.Vector4Impl;
import kcsaba.math.matrix.backbone.VectorImpl;

/**
 *
 * @author Kazó Csaba
 */
public class MatrixFactoryImpl extends MatrixFactory {

	@Override
	protected Vector2 _createVector2() {
		return new Vector2Impl(new MatrixDataImpl(2, 1));
	}

	@Override
	protected Vector3 _createVector3() {
		return new Vector3Impl(new MatrixDataImpl(3, 1));
	}

	@Override
	protected Vector4 _createVector4() {
		return new Vector4Impl(new MatrixDataImpl(4, 1));
	}

	@Override
	protected Vector _createVector(int dimension) {
		return new VectorImpl(new MatrixDataImpl(dimension, 1));
	}

	@Override
	protected Matrix _createMatrix(int rowCount, int colCount) {
		return new MatrixImpl(new MatrixDataImpl(rowCount, colCount));
	}

	@Override
	protected Matrix2 _createMatrix2() {
		return new Matrix2Impl(new MatrixDataImpl(2, 2));
	}

	@Override
	protected Matrix3 _createMatrix3() {
		return new Matrix3Impl(new MatrixDataImpl(3, 3));
	}

}
