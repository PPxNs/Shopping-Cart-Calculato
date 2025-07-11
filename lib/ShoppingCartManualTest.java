package lib;
import java.util.ArrayList;

public class ShoppingCartManualTest {

    public static void run() {
        System.out.println("--- Starting Shopping Cart Calculator Tests ---");
        System.out.println(); // for spacing

        int passedCount = 0;
        int failedCount = 0;

        // Test 1: ตะกร้าเป็น null
        try {
            double total1 = ShoppingCartCalculator.calculateTotalPrice(null);
            if (total1 == 0.0) {
                System.out.println("Tase Case 1 : PASSED: Null cart should return 0.0");
                passedCount++;
            } else {
                System.out.println("Tase Case 1 : FAILED: Null cart expected 0.0 but got " + total1);
                failedCount++;
            }
        } catch (Exception e) {
            System.out.println("Tase Case 1 : FAILED: Null cart caused an exception: " + e.getMessage());
            failedCount++;
        }

        // Test 2: ตะกร้าว่าง
        ArrayList<CartItem> emptyCart = new ArrayList<>();
        double total2 = ShoppingCartCalculator.calculateTotalPrice(emptyCart);
        if (total2 == 0.0) {
            System.out.println("Tase Case 2 : PASSED: Empty cart should return 0.0");
            passedCount++;
        } else {
            System.out.println("Tase Case 2 : FAILED: Empty cart expected 0.0 but got " + total2);
            failedCount++;
        }

        // Test 3: คำนวณปกติ ไม่มีส่วนลด
        ArrayList<CartItem> simpleCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Bread", 25.0, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total3 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total3 == 65.0) {
            System.out.println("Tase Case 3 : PASSED: Simple cart total is correct (65.0)");
            passedCount++;
        } else {
            System.out.println("Tase Case 3 : FAILED: Simple cart total expected 65.0 but got " + total3);
            failedCount++;
        }

        // Test 4: ค่า price ติดลบ 
        ArrayList<CartItem> MinusCart = new ArrayList<>();
        simpleCart.add(new CartItem("NORMAL", "Candy", -5, 2)); // 50
        simpleCart.add(new CartItem("NORMAL", "Milk", 15.0, 1));      // 15
        double total4 = ShoppingCartCalculator.calculateTotalPrice(simpleCart);
        if (total4 == 0.0) {
            System.out.println("Tase Case 4 : PASSED: Minus Cart total should return 0.0");
            passedCount++;
        } else {
            System.out.println("Tase Case 4 : FAILED: Minus Cart total expected -5.0 but got " + total4);
            failedCount++;
        }







        
        // --- Test Summary ---
        System.out.println("\n--------------------");
        System.out.println("--- Test Summary ---");
        System.out.println("Passed: " + passedCount + ", Failed: " + failedCount);
        if (failedCount == 0) {
            System.out.println("Excellent! All tests passed!");
        } else {
            System.out.println("Some tests failed.");
        }
    }
}