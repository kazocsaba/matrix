package hu.kazocsaba.math.matrix.immutable;

import hu.kazocsaba.math.matrix.Matrix;

/**
 *
 * @author Kazó Csaba
 */
class ImmutableDataImpl implements ImmutableData {
	private final double[][] data;

	ImmutableDataImpl(Matrix template) {
		data = new double[template.getRowCount()][template.getColumnCount()];
		for (int row=0; row<template.getRowCount(); row++) for (int col=0; col<template.getColumnCount(); col++)
			data[row][col]=template.get(row, col);
	}

	@Override
	public double get(int row, int col) {
		return data[row][col];
	}

	@Override
	public double getQuick(int row, int col) {
		return data[row][col];
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
