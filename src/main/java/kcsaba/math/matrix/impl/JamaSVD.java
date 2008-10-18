package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.Matrix;
import kcsaba.math.matrix.SingularValueDecomposition;
import kcsaba.math.matrix.util.JamaBridge;

class JamaSVD implements SingularValueDecomposition {

	private Matrix u,  v,  s;

	JamaSVD(Matrix m) {
		Jama.SingularValueDecomposition svd = new Jama.SingularValueDecomposition(JamaBridge.toJama(m));
		u = JamaBridge.fromJama(svd.getU());
		v = JamaBridge.fromJama(svd.getV());
		s = JamaBridge.fromJama(svd.getS());
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
