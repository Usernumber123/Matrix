package pojo;

public class Matrix {
    private double mat[][];
    private int quantityRows;
    private int quantityColumns;

    public Matrix(double[][] mat) {
        this.mat = mat;
        this.quantityRows = mat[0].length;
        this.quantityColumns = mat.length;
    }

    public double[][] getMat() {
        return mat;
    }

    public int getQuantityRows() {
        return quantityRows;
    }

    public int getQuantityColumns() {
        return quantityColumns;
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
        return quantityRows == matrix.quantityRows &&
                quantityColumns == matrix.quantityColumns;

    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.quantityRows;
        result = 31 * result + this.quantityColumns;
        result = 31 * result + mat.hashCode();
        return result;
    }


}
