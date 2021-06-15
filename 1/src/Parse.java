public class Parse {
    protected static int[] number;
    protected static int[] mileage;
    protected static int[] codeData;

    protected static String[] optional;

    public static void CodeCar(String[] data) {
        codeData = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            codeData[i] = Integer.parseInt(data[i].substring(1, 4));
        }
    }

    public static void Start(String[] data) {
        CodeCar(data);
        String[] changesData = Params(data);
        number = new int[data.length];
        mileage = new int[data.length];
        optional = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            String string = changesData[i];
            String[] dataParams = string.split("-");
            number[i] = Integer.parseInt(dataParams[0]);
            mileage[i] = Integer.parseInt(dataParams[1]);

            if (dataParams.length == 3) {
                optional[i] = dataParams[2];
            } else {
                optional[i] = "-";
            }
        }
    }

    public static String[] Params(String[] data) {
        String[] changesData = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            changesData[i] = data[i].substring(5);
        }
        return changesData;
    }

    public static int[] getNumber() {
        return number;
    }

    public static int[] getMileage() {
        return mileage;
    }

    public static String[] getOptional() {
        return optional;
    }

    public static int[] getCodeData() {
        return codeData;
    }
}
