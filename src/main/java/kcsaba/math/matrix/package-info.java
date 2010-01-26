/**
 * This package provides interfaces for matrices and vectors, as well as a factory
 * class for creating instances. Strong typing is enforced on the instances, meaning that
 * if a Matrix instance has a single column, that it will in fact be a Vector instance, and
 * if it also has 2, 3, or 4 rows, it will implement Vector2, Vector3, or Vector4, respectively.
 * Furthermore, a 2x2 and a 3x3 matrix will always have the type Matrix2 and Matrix3, respectively.
 */
package kcsaba.math.matrix;

