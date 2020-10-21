
public interface IMatrixWorker {
    public void print(double[][] m);
    public boolean haveSameDimension(double[][] m1, double[][] m2);
    public double[][] add(double[][] m1, double[][] m2);
    public double[][] subtract(double[][] m1, double[][] m2);
    public double[][] multiply(double[][] m1, double[][] m2);

}
