public class Main {
    public static void main(String[] args) {
        String[] data = new String[]{"C100_1-100", "C200_1-120-1200", "C300_1-120-30", "C400_1-80-20", "C100_2-50",
                "C200_2-40-1000", "C300_2-200-45", "C400_2-10-20", "C100_3-10", "C200_3-170-1100", "C300_3-150-29",
                "C400_3-100-28", "C100_1-300", "C200_1-100-750", "C300_1-32-15"
        };

        Parse.Start(data);
        Calculate calc = new Calculate();
        calc.fullCostForClass(data);

        System.out.println("GMS: " + calc.fullCostToALLClasses());
        System.out.println("100: " + calc.getTotal_cost100());
        System.out.println("200: " + calc.getTotal_cost200());
        System.out.println("300: " + calc.getTotal_cost300());
        System.out.println("400: " + calc.getTotal_cost400());
        System.out.println("Min cost type: " + calc.minCost());
        System.out.println("Max cost type: " + calc.maxCost());
        System.out.println("Enter car number (100, 200, 300, 400)");
        Filter filter= new Filter();
        filter.startFiltering();
    }
}
