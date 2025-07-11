package lib;
import java.util.ArrayList;
import java.util.Arrays;
public class ShoppingCartCalculator {

    /**
     * เขียน Javadoc ที่นี่เพื่ออธิบายกฎการทำงานและกรณีพิเศษ:
     * - ถ้า items เป็น null หรือ empty จะทำการ return ค่า 0.0 กลับไป
     * - จะทำอย่างไรถ้า CartItem มี price หรือ quantity ติดลบ เริ่มแรกจะเข้าตรวจสอบติดลบหรือไม่ ถ้าติดลบจะทำการ retrun ค่า 0.0 กลับไป
     * - กฎส่วนลด BOGO-APPLE (ซื้อ 1 แถม 1) โดยเริ่มแรกจะทำการเช็ค sku และเช็คปริมาณสินค้าว่าลูกค้าหยิบใส่ตะกร้าดี่ชิ้น หาก 2 ชิ้น ขึ้นไปจะทำการคำนวณตามโปรที่ได้จัดไว้
     * - กฎส่วนลด BULK-SODA (ซื้อ >= 6 ชิ้น ลด 10%) โดยเริ่มแรกจะทำการเช็ค sku และเช็คปริมาณสินค้าว่าลูกค้าหยิบใส่ตะกร้าดี่ชิ้น หาก 6 ชิ้น ขึ้นไปจะทำการคำนวณตามโปรที่ได้จัดไว้
     * -
     * -
     * -
     * -
     */
    
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        // TODO: เขียนโค้ด Implementation ที่นี่
        double total = 0 ;
        String namesku[] = {"BULK","BOGO","NORMAL"};
        if (items == null || items.isEmpty()) {
           return 0.0; 
        }    
        for (CartItem item : items) {
            if (item.price()<=0 || item.quantity()<=0 || !(Arrays.asList(namesku).contains(item.sku().toUpperCase()))) {
                return 0.0 ;
            }
            
            if (item.sku().equalsIgnoreCase("BULK")) {
                if (item.quantity()>=6) {
                    total +=(item.price()*item.quantity())-(item.price()*item.quantity()*10.0/100.0);
                }else total +=item.price()*item.quantity(); //รอปรับ logic again
            } 
            else if (item.sku().equalsIgnoreCase("BOGO")) {
                total += item.price()*(Math.ceil(item.quantity()/2.0));
            } 
            else {total +=item.price()*item.quantity();
            } 
        }
        return total;
    }
}