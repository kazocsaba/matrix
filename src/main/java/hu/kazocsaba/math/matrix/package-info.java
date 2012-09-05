/**
 * This package provides interfaces for matrices and vectors, as well as a factory
 * class for creating instances. Strong typing is enforced on the instances, meaning that
 * if a Matrix instance has a single column, it will in fact be a Vector instance, and
 * if it also has 2, 3, or 4 rows, it will implement Vector2, Vector3, or Vector4, respectively.
 * Furthermore, a 2x2 and a 3x3 matrix will always have the type Matrix2 and Matrix3, respectively.
 * <p>
 * Of course this kind of type-safety is guaranteed only for instances produced by this module, and cannot
 * be enforced for an arbitrary implementation. Moreover, new subtypes and functions may be added to the API at any
 * time, thus creating custom implementations is strongly discouraged. The only supported method for creating "custom"
 * instances is the {@link hu.kazocsaba.math.matrix.MatrixCore} class and
 * {@link hu.kazocsaba.math.matrix.MatrixFactory#create(MatrixCore)}.
 */
package hu.kazocsaba.math.matrix;

