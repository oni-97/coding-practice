package Chapter5;

public class DoubleToBinary {
    public static void main(String[] args) {
        realToBinary(0.3);
        realToBinary(0.25);
        realToBinary(0.375);
    }

    static void realToBinary(double num) {
        if (num <= 0 || 1 <= num) {
            System.out.println("ERROR");
            return;
        }

        StringBuilder s = new StringBuilder();
        s.append(".");
        int cnt = 0;
        while (num != 0 && cnt < 32) {
            num *= 2;
            if (num >= 1) {
                s.append(1);
                num -= 1;
            } else {
                s.append(0);
            }
            cnt++;
        }

        if (num != 0) {
            System.out.println("ERROR");
        } else {
            System.out.println(s.toString());
        }
    }
}
