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

	ImmutableDataImpl(double[][] elements) {
		super(elements.length, elements[0].length);
		data = new double[getRowCount()*getColumnCount()];
		for (int row=0; row<getRowCount(); row++) {
			double[] rowData=elements[row];
			if (rowData.length!=getColumnCount()) throw new IllegalArgumentException("Invalid array");
			for (int col=0; col<getColumnCount(); col++) {
				data[row*getColumnCount()+col]=rowData[col];
			}
		}
	}

	@Override
	public double getQuick(int row, int col) {
		return data[row*getColumnCount()+col];
	}

}
