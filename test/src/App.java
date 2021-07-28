public class App {
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while (i <= j) {
            int sum = i * i + j * j;
            if (sum == c) {
                System.out.println(i);
                System.out.println(j);
                return true;
            } else if (sum < c) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        App app = new App();
        System.out.println(app.judgeSquareSum(1000000));
    }
}
