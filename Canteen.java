import java.util.Scanner;

public class Canteen {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Food menu
        String[] foodItems = {
            "Burger",
            "Fries",
            "Fried Chicken",
            "Spaghetti",
            "Soft Drink"
        };

        double[] prices = {
            50.00,
            35.00,
            75.00,
            60.00,
            25.00
        };

        int totalQuantity = 0;
        double totalAmount = 0.00;

        boolean customerIsStudent = false;

        System.out.println("======================================");
        System.out.println("        CANTEEN ORDERING SYSTEM");
        System.out.println("======================================");

        // Display menu
        System.out.println("\nCANTEEN MENU");
        for (int i = 0; i < foodItems.length; i++) {
            System.out.printf("%d. %-20s $%.2f%n",
                    i + 1, foodItems[i], prices[i]);
        }

        System.out.println("======================================");

        while (true) {

            System.out.print("\nEnter item number (1-5): ");
            int itemNumber = input.nextInt();

            System.out.print("Enter quantity (1-10): ");
            int quantity = input.nextInt();

            System.out.print("Are you a student? (Y/N): ");
            String studentAnswer = input.next().toUpperCase();

            // Validate item number
            if (itemNumber < 1 || itemNumber > 5) {
                System.out.println("Invalid item number! Please try again.");

                System.out.print("Do you want to order again? (Y/N): ");
                String again = input.next().toUpperCase();

                if (again.equals("N")) {
                    break;
                }

                continue;
            }

            // Validate quantity
            if (quantity < 1 || quantity > 10) {
                System.out.println(
                    "Invalid quantity! Quantity must be between 1 and 10."
                );

                System.out.print("Do you want to order again? (Y/N): ");
                String again = input.next().toUpperCase();

                if (again.equals("N")) {
                    break;
                }

                continue;
            }

            // Validate student status
            if (!studentAnswer.equals("Y") && !studentAnswer.equals("N")) {
                System.out.println(
                    "Invalid student status! Please enter Y or N."
                );

                System.out.print("Do you want to order again? (Y/N): ");
                String again = input.next().toUpperCase();

                if (again.equals("N")) {
                    break;
                }

                continue;
            }

            // Store student status
            if (studentAnswer.equals("Y")) {
                customerIsStudent = true;
            }

            // Compute order
            double orderAmount = prices[itemNumber - 1] * quantity;

            totalQuantity += quantity;
            totalAmount += orderAmount;

            System.out.println("\nOrder added successfully!");
            System.out.println("Item: " + foodItems[itemNumber - 1]);
            System.out.println("Quantity: " + quantity);
            System.out.printf("Order Amount: $%.2f%n", orderAmount);

            // Ask for another order
            System.out.print("\nDo you want to order again? (Y/N): ");
            String again = input.next().toUpperCase();

            if (again.equals("N")) {
                break;
            }

            while (!again.equals("Y")) {
                System.out.println("Invalid choice! Please enter Y or N.");
                System.out.print("Do you want to order again? (Y/N): ");
                again = input.next().toUpperCase();
            }
        }

        // Calculate deduction
        double deductionRate = 0.00;

        if (customerIsStudent && totalAmount >= 500) {
            deductionRate = 0.15;
        } else if (customerIsStudent) {
            deductionRate = 0.10;
        } else if (totalAmount >= 500) {
            deductionRate = 0.05;
        }

        double totalDeduction = totalAmount * deductionRate;
        double finalAmount = totalAmount - totalDeduction;

        // Final receipt
        System.out.println("\n======================================");
        System.out.println("             FINAL RECEIPT");
        System.out.println("======================================");

        System.out.println("Total Quantity: " + totalQuantity);
        System.out.printf("Total Amount Before Deduction: $%.2f%n",
                totalAmount);
        System.out.printf("Total Deduction: $%.2f%n",
                totalDeduction);
        System.out.printf("Final Amount to Pay: $%.2f%n",
                finalAmount);

        System.out.println("======================================");
        System.out.println("       Thank you for ordering!");
        System.out.println("======================================");

        input.close();
    }
}
