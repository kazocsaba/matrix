package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.SingularValueDecomposition;
import kcsaba.math.matrix.util.JamaBridge;

class JamaSVD implements SingularValueDecomposition {

	private Matrix u,  v,  s;

	JamaSVD(Matrix m) {
		Jama.Matrix jm;
		if (m.getRowCount() < m.getColumnCount()) {
			// Jama can only do SVD for its transpose
			jm = JamaBridge.toJamaTransposed(m);
		} else {
			jm = JamaBridge.toJama(m);
		}
		Jama.SingularValueDecomposition svd = new Jama.SingularValueDecomposition(jm);
		if (m.getRowCount() < m.getColumnCount()) {
			v = JamaBridge.fromJama(svd.getU());
			u = JamaBridge.fromJama(svd.getV());
			s = JamaBridge.fromJamaTranspose(svd.getS());
		} else {
			u = JamaBridge.fromJama(svd.getU());
			v = JamaBridge.fromJama(svd.getV());
			s = JamaBridge.fromJama(svd.getS());
		}
	}

	@Override
	public Matrix getU() {
		return u;
	}

	@Override
	public Matrix getV() {
		return v;
	}

	@Override
	public Matrix getS() {
		return s;
	}
}
