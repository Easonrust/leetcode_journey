class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] arr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int a = num1.charAt(i) - '0';
                int b = num2.charAt(j) - '0';
                int sum = a * b + arr[i + j + 1];
                arr[i + j + 1] = sum % 10;
                arr[i + j] = arr[i + j] + sum / 10;
            }
        }
        int i = 0;
        while (i < arr.length && arr[i] == 0) {
            i++;
        }
        if (i == arr.length) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (i < arr.length) {
            sb.append(arr[i]);
            i++;
        }
        return sb.toString();
    }
}
