import java.util.Scanner;

public class Filter {
    public void startFiltering() {
        boolean validation = false;
        while (!validation) {
            Scanner str = new Scanner(System.in);
            int numb;
            String number = str.next();
            if (!isValidNumber(number)) {
                System.out.println("Enter the number (100, 200, 300, 400)");
            } else {
                numb = Integer.parseInt(number);
                if (number.length() == 3 && (numb == 100 || numb == 200 || numb == 300 || numb == 400)) {
                    checkNumber(numb);
                    validation = true;
                } else {
                    System.out.println("Wrong Number");
                    validation = false;
                }
            }
            System.out.println(validation);
        }
    }

    public void checkNumber(int number) {
        switch (number) {
            case 100:
                info100();
            case 200:
                info200();
            case 300:
                info300();
            case 400:
                info400();
        }

    }

    public void info100() {
        int[] code = Parse.getCodeData();
        int[] number = Parse.getNumber();
        int[] mileage = Parse.getMileage();
        String[] optional = Parse.getOptional();
        for (int i = 0; i < code.length; i++) {
            if (code[i] == 100) {
                System.out.println("100:");
                System.out.println("Num auto:" + number[i] + "   Mileage: " + mileage[i] + "   Metadata: " + optional[i]);
            }
        }
        startFiltering();
    }

    public void info200() {
        int[] code = Parse.getCodeData();
        int[] number = Parse.getNumber();
        int[] mileage = Parse.getMileage();
        String[] optional = Parse.getOptional();
        for (int i = 0; i < code.length; i++) {
            if (code[i] == 200) {
                System.out.println("200:");
                System.out.println("Num auto:" + number[i] + "   Mileage: " + mileage[i] + "   Metadata: " + optional[i]);
            }
        }
        startFiltering();
    }

    public void info300() {
        int[] code = Parse.getCodeData();
        int[] number = Parse.getNumber();
        int[] mileage = Parse.getMileage();
        String[] optional = Parse.getOptional();
        for (int i = 0; i < code.length; i++) {
            if (code[i] == 300) {
                System.out.println("300:");
                System.out.println("Num auto:" + number[i] + "   Mileage: " + mileage[i] + "   Metadata: " + optional[i]);
            }
        }
        startFiltering();
    }

    public void info400() {
        int[] code = Parse.getCodeData();
        int[] number = Parse.getNumber();
        int[] mileage = Parse.getMileage();
        String[] optional = Parse.getOptional();
        for (int i = 0; i < code.length; i++) {
            if (code[i] == 400) {
                System.out.println("400:");
                System.out.println("Num auto:" + number[i] + "   Mileage: " + mileage[i] + "   Metadata: " + optional[i]);
            }
        }
        startFiltering();
    }

    public static boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
