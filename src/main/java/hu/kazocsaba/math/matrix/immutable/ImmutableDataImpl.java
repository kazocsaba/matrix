package hu.kazocsaba.math.matrix.immutable;

import hu.kazocsaba.math.matrix.Matrix;

/**
 *
 * @author Kazó Csaba
 */
class ImmutableDataImpl implements ImmutableData {
	private final double[] data;
	private final int rows, cols;

	ImmutableDataImpl(Matrix template) {
		data = new double[template.getRowCount()*template.getColumnCount()];
		rows=template.getRowCount();
		cols=template.getColumnCount();
		for (int row=0; row<template.getRowCount(); row++) for (int col=0; col<template.getColumnCount(); col++)
			data[row*cols+col]=template.getQuick(row, col);
	}

	@Override
	public double get(int row, int col) {
		if (row<0 || row>=rows || col<0 || col>=cols) throw new IndexOutOfBoundsException();
		return getQuick(row, col);
	}

	@Override
	public double getQuick(int row, int col) {
		return data[row*cols+col];
	}

	@Override
	public int getColumnCount() {
		return cols;
	}

	@Override
	public int getRowCount() {
		return rows;
	}
}
