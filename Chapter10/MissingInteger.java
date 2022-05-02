package Chapter10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MissingInteger {
    void missingInteger(String fileName) throws FileNotFoundException {
        long intSize = Integer.MAX_VALUE + 1;
        int[] used = new int[(int) intSize / 32 + 1];

        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            used[n / 32] |= (1 << (n % 32));
        }

        for (int i = 0; i < used.length; i++) {
            for (int j = 0; j < 32; j++) {
                if ((used[i] & (1 << i)) == 0) {
                    System.out.println(32 * i + j);
                    scanner.close();
                    return;
                }
            }
        }

        scanner.close();
    }
}
