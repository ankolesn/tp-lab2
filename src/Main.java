public class Main {
    public static void main(String[] args) {
        Matrix a = new Matrix(2,2);
        a.setElement(0, 1, 1);
        a.setElement(1, 0, 1);
        a.setElement(1, 1, 0);

        Matrix b = new Matrix(2,2);
        b.setElement(0, 1, 1);
        b.setElement(1, 0, 1);
        b.setElement(1, 1, 0);

        a.setElement(0, 0, 9);
        a.setElement(0, 1, 2);
        a.setElement(1, 0, 3);
        a.setElement(1, 1, 4);
        a.setElement(0, 2, 5);
        a.setElement(2, 0, 6);
        a.setElement(2, 1, 7);
        a.setElement(1, 2, 8);
        a.setElement(2, 2, 9);
        for (int i = 0; i < 9; i++) {
            a = a.product(b);
        }
        System.out.println(a);
        int res[][] = a.sumColumns();
        System.out.println(a.toStringArr(res));
    }
}