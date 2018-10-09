import java.util.Scanner;

class Anz {
    static Scanner scanner = new Scanner(System.in);
    static float closingSharePrices[];

    public static void main(String args[]) {

        // Loop infinitely to until the user opts for exit
        while (true) {
            // Present user the menu with different choises
            System.out.println("Menu");
            System.out.println("Press 1 - Read and Validate Data");
            System.out.println("Press 2 - Calculate total Gain and Losses");
            System.out.println("Press 3 - Exit");
            // Read user choise
            int menu = scanner.nextInt();
            // Based on the users choise call the appropriate function
            switch (menu) {
            case 1:
                ReadAndValidateData();
                break;
            case 2:
                CalculateTotalLossesAndGains();
                break;
            case 3:
                System.out.print("Thanks for using the application, bye !");
                System.exit(0);
            default:
                System.out.print("Please enter the valid option");

            }
        }
    }

    // This method reads the data and validates it
    private static void ReadAndValidateData() {
        System.out.println("Please enter the number of days to take closing share prices for ?");
        int numberOfDays = 0;
        while (true) {
            if (scanner.hasNextInt()) {
                numberOfDays = scanner.nextInt();
                if (numberOfDays <= 0) {
                    // Validate if the user entered a positive number for the number of days
                    System.out.print("The number of days should be a positive number greater than 0");
                    scanner.next();
                } else {
                    break;
                }
            } else {
                scanner.next();
                System.out.println("Error please enter correct data");
            }
        }
        // Instantiate closingSharePrices based on the number of days
        closingSharePrices = new float[numberOfDays];
        for (int i = 0; i < numberOfDays; i++) {
            while (true) {
                System.out.println("Day " + (i + 1));
                if (scanner.hasNextFloat()) {
                    closingSharePrices[i] = scanner.nextFloat();
                    break;
                } else {
                    scanner.next();
                    System.out.println("Error please enter correct data");
                }
            }
        }
    }

    /*
     * This method calculates the total losses and gains for the previously read /
     * data
     */
    private static void CalculateTotalLossesAndGains() {

        float totalLosses = 0;
        float totalGains = 0;

        if (closingSharePrices == null) {
            System.out.println("Please choose option 1 to enter the data first");
            return;
        } else {
            System.out.println("Calculating total losses and gains based on the data entered recently");
            for (int i = 0; i < closingSharePrices.length - 1; i++) {
                if (closingSharePrices[i] > closingSharePrices[i + 1]) {
                    totalLosses = totalLosses + (closingSharePrices[i + 1] - closingSharePrices[i]);
                } else {
                    totalGains = totalGains + Math.abs(closingSharePrices[i] - closingSharePrices[i + 1]);
                }
            }

            System.out.println("Total Losses : " + totalLosses);
            System.out.println("Total Gains : " + totalGains);
        }
    }
}
