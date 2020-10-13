package Task2;

public class Main {
    public static void main(String[] args){


        GroceryItem groceryItem =new GroceryItem("Rajma",50);
        GroceryItem groceryItem1 =new GroceryItem("Dal",50);
        GroceryItem groceryItem2 =new GroceryItem("Rice",50);
        GroceryItem groceryItem3 =new GroceryItem("Tori",50);

        System.out.println(GroceryCartItem.createNew(groceryItem,"5Kg 500g"));
        System.out.println(GroceryCartItem.createNew(groceryItem1,"8Kg 500g"));
        System.out.println(GroceryCartItem.createNew(groceryItem2,"9Kg 500g"));
        System.out.println(GroceryCartItem.createNew(groceryItem3,"4Kg 500g"));

        Cart cart =new Cart();
        cart.add(GroceryCartItem.createNew(groceryItem,"5Kg 500g"))
                .add(GroceryCartItem.createNew(groceryItem1,"8Kg 500g"))
                .add(GroceryCartItem.createNew(groceryItem2,"9Kg 500g"))
                .add(GroceryCartItem.createNew(groceryItem3,"4Kg 500g"));
        System.out.println(cart);



    }
}
