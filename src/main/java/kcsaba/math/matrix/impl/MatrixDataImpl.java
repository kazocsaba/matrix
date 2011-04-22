package kcsaba.math.matrix.impl;

import kcsaba.math.matrix.backbone.MatrixData;

/**
 *
 * @author Kazó Csaba
 */
class MatrixDataImpl implements MatrixData {
	private double[][] data;

	MatrixDataImpl(int rows, int cols) {
		if (rows<=0) throw new IllegalArgumentException("Invalid row count: "+rows);
		if (cols<=0) throw new IllegalArgumentException("Invalid column count: "+cols);
		data=new double[rows][cols];
	}
	
	@Override
	public double get(int row, int col) {
		return data[row][col];
	}

	@Override
	public void set(int row, int col, double value) {
		data[row][col]=value;
	}

	@Override
	public int getColumnCount() {
		return data[0].length;
	}

	@Override
	public int getRowCount() {
		return data.length;
	}
	
}
