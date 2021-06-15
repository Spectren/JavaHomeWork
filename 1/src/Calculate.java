public class Calculate {
    private final double fuel_cost100 = 46.1;
    private final double fuel_cost200_400 = 48.9;
    private final double fuel_cost300 = 47.5;
    private final double fuel_consumption100 = 12.5;
    private final double fuel_consumption200 = 12;
    private final double fuel_consumption300 = 11.5;
    private final double fuel_consumption400 = 20;
    private final int consumption_km = 100;
    protected double total_cost100;
    protected double total_cost200;
    protected double total_cost300;
    protected double total_cost400;

    public void fullCostForClass(String[] data) {
        for (int i = 0; i < Parse.codeData.length; i++) {
            switch (Parse.codeData[i]) {
                case 100:
                    total_cost100 += (fuel_cost100 * fuel_consumption100 * Parse.mileage[i] / consumption_km);
                case 200:
                    total_cost200 += (fuel_cost200_400 * fuel_consumption200 * Parse.mileage[i] / consumption_km);
                case 300:
                    total_cost300 += (fuel_cost300 * fuel_consumption300 * Parse.mileage[i] / consumption_km);
                case 400:
                    total_cost400 += (fuel_cost200_400 * fuel_consumption400 * Parse.mileage[i] / consumption_km);

            }
        }

    }

    public double fullCostToALLClasses() {
        double totalCost = total_cost100 + total_cost200 + total_cost300 + total_cost400;
        return totalCost;
    }

    public String minCost() {
        if (minExpenses() == total_cost100) {
            return "100";
        } else if (minExpenses() == total_cost200) {
            return "200";
        } else if (minExpenses() == total_cost300) {
            return "300";
        } else if (minExpenses() == total_cost400) {
            return "400";
        }
        return null;
    }

    public String maxCost() {

        if (maxExpenses() == total_cost100) {
            return "100";
        } else if (maxExpenses() == total_cost200) {
            return "200";
        } else if (maxExpenses() == total_cost300) {
            return "300";
        } else if (maxExpenses() == total_cost400) {
            return "400";
        }
        return null;
    }

    public double maxExpenses() {
        double maxExpenses = total_cost100;
        maxExpenses = Math.max(maxExpenses, total_cost200);
        maxExpenses = Math.max(maxExpenses, total_cost300);
        maxExpenses = Math.max(maxExpenses, total_cost400);
        return maxExpenses;
    }

    public double minExpenses() {
        double minExpenses = total_cost100;
        minExpenses = Math.min(minExpenses, total_cost200);
        minExpenses = Math.min(minExpenses, total_cost300);
        minExpenses = Math.min(minExpenses, total_cost400);
        return minExpenses;
    }

    public double getTotal_cost100() {
        return total_cost100;
    }

    public double getTotal_cost200() {
        return total_cost200;
    }

    public double getTotal_cost300() {
        return total_cost300;
    }

    public double getTotal_cost400() {
        return total_cost400;
    }
}
