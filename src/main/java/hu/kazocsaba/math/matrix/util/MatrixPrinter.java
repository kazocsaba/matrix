package hu.kazocsaba.math.matrix.util;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.text.NumberFormat;
import java.util.Locale;
import hu.kazocsaba.math.matrix.Matrix;

/**
 * Utility class for displaying matrices. The layout can be fine-tuned using a
 * {@link MatrixPrinter.Control} instance. If a control is not supplied as an argument, the
 * default control parameters are used. See the documentation of the <code>Control</code> class
 * for the defaults.
 * <p>
 * The format of the matrix elements can also be specified;
 * they can be converted to string using the default canonical {@link Double#toString(double)},
 * a supplied {@link NumberFormat} instance, or a
 * <a href="http://java.sun.com/javase/6/docs/api/java/util/Formatter.html#syntax">format
 * string</a>. (<b>Note:</b> due to
 * <a href="http://bugs.sun.com/bugdatabase/view_bug.do?bug_id=6534606">a bug</a> in Java
 * versions prior to 7, results of format strings
 * are not localized when the "%e" or "%g" conversion is used.)
 * @author Kazó Csaba
 */
public class MatrixPrinter {
	/**
	 * A number formatter that uses {@link Double#toString(double)} to format values.
	 * The resulting string is a locale-independent canonical form.
	 */
	private static final NumberFormatter CANONICAL_NUMBER_FORMAT=new NumberFormatter() {

		@Override
		public String format(double value) {
			return Double.toString(value);
		}
	};
	/**
	 * A default Control instance.
	 */
	private static final Control DEFAULT_CONTROL=new Control();
	
	private MatrixPrinter() {}
	
	private static void pad(PrintWriter out, int width) {
		for (int i=0; i<width; i++)
			out.write(' ');
	}
	
	/**
	 * Prints the matrix to the standard output using default control arguments.
	 * The matrix elements are converted to string using
	 * {@link Double#toString(double)} resulting in a locale-independent canonical form.
	 * <p>
	 * An invocation of this method of the form {@code print(m)} behaves in exactly the
	 * same way as the invocation
	 * <pre>
	 *     print(m, new Control())</pre>
	 * @param m the matrix to print
	 * @throws NullPointerException if <code>m</code> is <code>null</code>
	 */
	public static void print(Matrix m) {
		print(m, DEFAULT_CONTROL, CANONICAL_NUMBER_FORMAT);
	}
	
	/**
	 * Prints the matrix to the standard output using default control arguments. The matrix
	 * elements are formatted using the specified
	 * <a href="http://java.sun.com/javase/6/docs/api/java/util/Formatter.html#syntax">format
	 * string</a> and the default locale. The format string is expected to receive a single
	 * argument of type double.
	 * <p>
	 * An invocation of this method of the form {@code print(m, f)} behaves in exactly the
	 * same way as the invocation
	 * <pre>
	 *     print(m, new Control(), f, Locale.getDefault())</pre>
	 * @param m the matrix to print
	 * @param format the format string
	 * @throws NullPointerException if either argument is <code>null</code>
	 * @throws java.util.IllegalFormatException if the format string is incorrect
	 */
	public static void print(Matrix m, String format) {
		print(m, DEFAULT_CONTROL, new FormatterNumberFormatter(format, Locale.getDefault()));
	}
	
	/**
	 * Prints the matrix to the standard output using default control arguments. The matrix
	 * elements are formatted using the specified
	 * <a href="http://java.sun.com/javase/6/docs/api/java/util/Formatter.html#syntax">format
	 * string</a> and the specified locale. The format string is expected to receive a single
	 * argument of type double. If <code>locale</code> is <code>null</code>, then no localization
	 * is applied.
	 * <p>
	 * An invocation of this method of the form {@code print(m, f, l)} behaves in exactly the
	 * same way as the invocation
	 * <pre>
	 *     print(m, new Control(), f, l)</pre>
	 * @param m the matrix to print
	 * @param format the format string
	 * @param locale the locale to use; if it is <code>null</code>, then no localization is
	 * applied
	 * @throws NullPointerException if the matrix or the format is <code>null</code>
	 * @throws java.util.IllegalFormatException if the format string is incorrect
	 */
	public static void print(Matrix m, String format, Locale locale) {
		print(m, DEFAULT_CONTROL, new FormatterNumberFormatter(format, locale));
	}
	
	/**
	 * Prints the matrix as specified by the supplied <code>Control</code> instance. The matrix
	 * elements are formatted using the specified
	 * <a href="http://java.sun.com/javase/6/docs/api/java/util/Formatter.html#syntax">format
	 * string</a> and locale. The format string is expected to receive a single
	 * argument of type double. If <code>locale</code> is <code>null</code> then no localization
	 * is applied.
	 * @param m the matrix to print
	 * @param control the control instance specifying the destination and format-related
	 * parameters
	 * @param format the format string
	 * @param locale the locale to apply; if it is <code>null</code>, then no localization is
	 * performed
	 * @throws NullPointerException if the matrix, control, or format string is <code>null</code>
	 * @throws java.util.IllegalFormatException if the format string is incorrect
	 */
	public static void print(Matrix m, Control control, String format, Locale locale) {
		print(m, control, new FormatterNumberFormatter(format, locale));
	}
	/**
	 * Prints the matrix as specified by the supplied <code>Control</code> using canonical
	 * number format. The matrix elements are converted to string using
	 * {@link Double#toString(double)} resulting in a locale-independent canonical form.
	 * @param m the matrix to print
	 * @param control the control instance specifying the destination and format-related
	 * parameters
	 * @throws NullPointerException if either argument is <code>null</code>
	 */
	public static void print(Matrix m, Control control) {
		print(m, control, CANONICAL_NUMBER_FORMAT);
	}
	
	/**
	 * Prints the matrix using default control arguments. The matrix
	 * elements are formatted using the specified <code>NumberFormat</code>.
	 * @param m the matrix to print
	 * @param format the NumberFormat used to convert the matrix elements to string
	 * @throws NullPointerException if either argument is <code>null</code>
	 */
	public static void print(Matrix m, NumberFormat format) {
		print(m, DEFAULT_CONTROL, new NumberFormatNumberFormatter(format));
	}

	/**
	 * Prints the matrix as specified by the supplied <code>Control</code> instance. The matrix
	 * elements are formatted using the specified <code>NumberFormat</code>.
	 * @param m the matrix to print
	 * @param control the <code>Control</code> instance to use
	 * @param format the NumberFormat used to convert the matrix elements to string
	 * @throws NullPointerException if either argument is <code>null</code>
	 */
	public static void print(Matrix m, Control control, NumberFormat format) {
		print(m, control, new NumberFormatNumberFormatter(format));
	}
	/**
	 * Prints the matrix as specified by the supplied <code>Control</code> and
	 * <code>NumberFormatter</code> instance.
	 * @param m the matrix to print
	 * @param control the control instance specifying the destination and format-related
	 * parameters
	 * @param formatter the formatter that converts the elements of the matrix to strings
	 * @throws NullPointerException if either argument is <code>null</code>
	 */
	private static void print(Matrix m, Control control, NumberFormatter formatter) {
		if (m==null || control==null || formatter==null) throw new NullPointerException();
		String[][] elements=new String[m.getRowCount()][m.getColumnCount()];
		int[] columnWidths=new int[m.getColumnCount()];
		int maxColumnWidth = 0;
		for (int i=0; i<m.getRowCount(); i++) for (int j=0; j<m.getColumnCount(); j++) {
			elements[i][j]=formatter.format(m.getQuick(i,j));
			columnWidths[j]=Math.max(columnWidths[j], elements[i][j].length());
			maxColumnWidth=Math.max(maxColumnWidth, elements[i][j].length());
		}
		if (control.columnWidthsEqual) {
			for (int i=0; i<columnWidths.length; i++)
				columnWidths[i]=maxColumnWidth;
		}
		PrintWriter out=control.writer;
		for (int row=0; row<m.getRowCount(); row++) {
			out.write(control.linePrefix);
			
			for (int col=0; col<m.getColumnCount(); col++) {
				if (col>0)
					out.write(control.columnSeparator);
				int padding=columnWidths[col]-elements[row][col].length();
				switch (control.alignment) {
					case LEFT:
						out.write(elements[row][col]);
						pad(out, padding);
						break;
					case RIGHT:
						pad(out, padding);
						out.write(elements[row][col]);
						break;
					case CENTER_LEFT:
						pad(out, padding/2);
						out.write(elements[row][col]);
						pad(out, (padding+1)/2);
						break;
					case CENTER_RIGHT:
						pad(out, (padding+1)/2);
						out.write(elements[row][col]);
						pad(out, padding/2);
						break;
				}
			}
			
			out.write(control.lineSuffix);
			out.println();
		}
		out.flush();
	}
	
	/**
	 * Prints the matrix to the standard output, producing an array representation that can be used to recreate
	 * the matrix with {@link hu.kazocsaba.math.matrix.MatrixFactory#createMatrix(double[][])} or
	 * {@link hu.kazocsaba.math.matrix.MatrixFactory#createVector(double[])}. This method is intended for debugging.
	 * @param m the matrix to print
	 * @throws NullPointerException if the argument is {@code null}
	 */
	public static void printCode(Matrix m) {
		PrintWriter out=new PrintWriter(System.out);
		if (m.getColumnCount()==1) {
			out.print('{');
			out.print(m.getQuick(0, 0));
			for (int row=1; row<m.getRowCount(); row++) {
				out.print(", ");
				out.print(m.getQuick(row, 0));
			}
			out.println('}');
		} else {
			out.println('{');
			for (int row=0; row<m.getRowCount(); row++) {
				out.print("\t{");
				out.print(m.getQuick(row, 0));
				for (int col=1; col<m.getColumnCount(); col++) {
					out.print(", ");
					out.print(m.getQuick(row, col));
				}
				out.print('}');
				if (row<m.getRowCount()-1)
					out.println(',');
				else
					out.println();
			}
			out.println('}');
		}
		out.flush();
	}
	
	/**
	 * {@code MatrixPrinter.Control} encapsulates data used for printing matrices.
	 * These data are the following:
	 * <table cellpadding="5">
	 * <tr>
	 * <td valign="top">writer</td>
	 * <td>The destination to receive the result; defaults to the standard output
	 * ({@code new BufferedWriter(new OutputStreamWriter(System.out))}).</td>
	 * </tr><tr>
	 * <td valign="top">linePrefix, lineSuffix</td>
	 * <td>String values that are written at the beginning and at the end of each line.
	 * Both default to the empty string.</td>
	 * </tr><tr>
	 * <td valign="top">columnSeparator</td>
	 * <td>The string that separates columns of the matrix; it is printed in every line
	 * after each matrix element but the last one. It defaults to two space characters.</td>
	 * </tr><tr>
	 * <td valign="top">columnWidthsEqual</td>
	 * <td>If this flag is true, all columns are forced to have the same width, padding
	 * with space if necessary. The default value is true.</td>
	 * </tr><tr>
	 * <td valign="top">alignment</td>
	 * <td>The horizontal alignment of the matrix elements within the columns. The
	 * default value is <code>HorizontalAlignment.CENTER_RIGHT</code>. (Note that the
	 * layout algorithm assumes fixed character width.)</td>
	 * </tr>
	 * </table>
	 */
	public static class Control {
		private PrintWriter writer;
		private String linePrefix="", lineSuffix="", columnSeparator="  ";
		private boolean columnWidthsEqual = true;
		private HorizontalAlignment alignment = HorizontalAlignment.CENTER_RIGHT;
		
		/**
		 * Creates an instance with default parameters. The destination is the standard output.
		 */
		public Control() {
			this(new BufferedWriter(new OutputStreamWriter(System.out)));
		}
		/**
		 * Creates an instance with the specified writer.
		 * @param writer the destination of the <code>MatrixPrinter</code>.
		 * @throws NullPointerException if the argument is <code>null</code>
		 */
		public Control(Writer writer) {
			if (writer==null) throw new NullPointerException();
			if (writer instanceof PrintWriter)
				this.writer=(PrintWriter)writer;
			else
				this.writer=new PrintWriter(writer);
		}
		/**
		 * Sets the line prefix string that is printed at the beginning of each line. If
		 * <code>linePrefix</code> is <code>null</code>, the default empty string is be set.
		 * @param linePrefix the line prefix string
		 */
		public void setLinePrefix(String linePrefix) {
			if (linePrefix==null)
				this.linePrefix = "";
			else
				this.linePrefix = linePrefix;
		}

		/**
		 * Sets the line suffix string that is printed at the end of each line. If
		 * <code>lineSuffix</code> is <code>null</code>, the default empty string is be set.
		 * @param lineSuffix the line suffix string
		 */
		public void setLineSuffix(String lineSuffix) {
			if (lineSuffix==null)
				this.lineSuffix = "";
			else
				this.lineSuffix = lineSuffix;
		}
		/**
		 * Sets the column separator. As removing the space between columns is generally
		 * undesired, the <code>null</code> value is not permitted; the empty string must
		 * be passed to this function explicitly to achieve this result.
		 * @param columnSeparator the column separator
		 * @throws NullPointerException if the argument is <code>null</code>
		 */
		public void setColumnSeparator(String columnSeparator) {
			this.columnSeparator = columnSeparator;
		}
		/**
		 * Sets whether or not the columns of the matrix should have the same width.
		 * @param columnWidthsEqual true if columns should have the same width, false
		 * otherwise
		 */
		public void setColumnWidthsEqual(boolean columnWidthsEqual) {
			this.columnWidthsEqual = columnWidthsEqual;
		}
		/**
		 * Sets the horizontal alignment of the matrix elements within their columns.
		 * @param alignment the horizontal alignment of the elements
		 * @throws NullPointerException if the argument is <code>null</code>
		 */
		public void setAlignment(HorizontalAlignment alignment) {
			if (alignment==null) throw new NullPointerException();
			this.alignment = alignment;
		}
	}
	/**
	 * A number formatter produces a string representation of a double value.
	 */
	private static abstract class NumberFormatter {
		public abstract String format(double value);
	}
	/**
	 * A number formatter that uses a format string to render matrix elements.
	 */
	private static class FormatterNumberFormatter extends NumberFormatter {
		private final String formatString;
		private final Locale locale;

		public FormatterNumberFormatter(String formatString, Locale locale) {
			if (formatString==null) throw new NullPointerException();
			this.formatString = formatString;
			this.locale = locale;
		}

		@Override
		public String format(double value) {
			return String.format(locale, formatString, value);
		}
	}
	/**
	 * A number formatter using a {@link NumberFormat} instance.
	 */
	private static class NumberFormatNumberFormatter extends NumberFormatter {
		private final NumberFormat format;

		public NumberFormatNumberFormatter(NumberFormat format) {
			if (format==null) throw new NullPointerException();
			this.format = format;
		}

		@Override
		public String format(double value) {
			return format.format(value);
		}
		
	}
	/**
	 * Enumeration defining possible values for horizontal alignment of matrix elements.
	 */
	public static enum HorizontalAlignment {
		/**
		 * Indicates that the elements should be left aligned.
		 */
		LEFT,
		/**
		 * Indicates that the elements should be centered, and if they cannot be
		 * centered prefectly, the extra space should be added to the right.
		 */
		CENTER_LEFT,
		/**
		 * Indicates that the elements should be centered, and if they cannot be
		 * centered prefectly, the extra space should be added to the left.
		 */
		CENTER_RIGHT,
		/**
		 * Indicates that the elements should be left aligned.
		 */
		RIGHT
	}
}
