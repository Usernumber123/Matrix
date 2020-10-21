package pojo;

public class Matrix {
    private double mat[][];
    private int row;
    private int column;

    public Matrix(double[][] mat) {
        this.mat = mat;
        this.row = mat[0].length;
        this.column = mat.length;
    }

    public double[][] getMat() {
        return mat;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        if (matrix.mat.length == mat.length && matrix.mat[0].length == mat[0].length) {
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (matrix.mat[i][j] != mat[i][j]) return false;
                }
            }
        } else return false;
        return row == matrix.row &&
                column == matrix.column;

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.row;
        result = 31 * result + this.column;
        result = 31 * result + mat.hashCode();
        return result;
    }


}
