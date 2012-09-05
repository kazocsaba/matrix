package hu.kazocsaba.math.matrix.immutable;

import hu.kazocsaba.math.matrix.Matrix;

/**
 *
 * @author Kazó Csaba
 */
class ImmutableDataImpl extends ImmutableData {
	private final double[] data;

	ImmutableDataImpl(Matrix template) {
		super(template.getRowCount(), template.getColumnCount());
		data = new double[template.getRowCount()*template.getColumnCount()];
		for (int row=0; row<template.getRowCount(); row++) for (int col=0; col<template.getColumnCount(); col++)
			data[row*getColumnCount()+col]=template.getQuick(row, col);
	}

	@Override
	public double getQuick(int row, int col) {
		return data[row*getColumnCount()+col];
	}

}
