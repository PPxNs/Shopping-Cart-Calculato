package lib;
import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * - ถ้า items เป็น null หรือ empty จะทำการ return ค่า 0.0 กลับไป
     * - จะทำอย่างไรถ้า CartItem มี price หรือ quantity ติดลบ เริ่มแรกจะเข้าตรวจสอบติดลบหรือไม่ ถ้าติดลบจะทำการ retrun ค่า 0.0 กลับไป
     * - กฎส่วนลด BOGO-APPLE (ซื้อ 1 แถม 1)
     * - กฎส่วนลด BULK-SODA (ซื้อ >= 6 ชิ้น ลด 10%)
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        // TODO: เขียนโค้ด Implementation ที่นี่
        if (items == null || items.isEmpty()) {
           return 0.0; 
        }
        
        for (CartItem item : items) {
            if (item.price()<0 || item.quantity()<0) {
                return 0.0 ;
            }
        }
        return 0.0;
    }
}