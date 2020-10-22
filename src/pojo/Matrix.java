package pojo;

public class Matrix {
    private double mat[][];
    private int matrixRow;
    private int matrixColumn;

    public Matrix(double[][] mat) {
        this.mat = mat;
        this.matrixRow = mat[0].length;
        this.matrixColumn = mat.length;
    }

    public double[][] getMat() {
        return mat;
    }

    public int getMatrixRow() {
        return matrixRow;
    }

    public int getMatrixColumn() {
        return matrixColumn;
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
        return matrixRow == matrix.matrixRow &&
                matrixColumn == matrix.matrixColumn;

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.matrixRow;
        result = 31 * result + this.matrixColumn;
        result = 31 * result + mat.hashCode();
        return result;
    }


}
