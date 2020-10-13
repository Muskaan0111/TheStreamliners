package Task2;

import java.util.ArrayList;
public class Cart {
    ArrayList<GroceryCartItem> cartItems;
    float totalAmount;

    public Cart() {
        cartItems =new ArrayList<>();
        totalAmount=0;
    }

    public Cart add(GroceryCartItem item){

        cartItems.add(item);

        totalAmount+= (item.pricePerKg*item.quantity);
        return this;


    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("Cart{ groceryCartItems=")
                .append(cartItems) .append(", totalAmount=") .append(totalAmount);




        String s = stringBuilder.toString();
        return s;

    }
}
