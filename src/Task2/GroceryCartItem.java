package Task2;

public class GroceryCartItem extends GroceryItem {


    float price;
    float quantity;




    public GroceryCartItem(String name, int pricePerKg) {
        super(name, pricePerKg);

    }

    static float extractQuantity(String quantityStr){

//        String[] s1= quantityStr.split(" ");
//        //System.out.println(s1[0]);
//        String s2= s1[0].replace("Kg","");
//        String s3=s1[1].replace("g","");
//        System.out.println(s2);
//        int x=Integer.parseInt(s2);
//        int y=Integer.parseInt(s3);
//        float f =  ((float)(x*1000)+y)/1000;

        quantityStr=quantityStr.replace("Kg ",".")
                .replace("Kg",".")
                .replace("g","");

        int index=quantityStr.indexOf(".");


        if(quantityStr.length()<3&&index==-1){

            if(quantityStr.length()==1){
                quantityStr = ".00" + quantityStr;
            }
            else {
                quantityStr = ".0" + quantityStr;
            }
            System.out.println(quantityStr);


        }


        return Float.parseFloat(quantityStr);

    }
    static GroceryCartItem createNew(GroceryItem item , String quantityStr){
        GroceryCartItem cartItem= new GroceryCartItem(item.name, item.pricePerKg);

        cartItem.quantity= extractQuantity(quantityStr);

        cartItem.price=(cartItem.quantity* cartItem.pricePerKg);
        System.out.println(cartItem.quantity);
        System.out.println(cartItem.price);

        return cartItem;
    }







    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(name)
                .append("(Rs.") .append(pricePerKg) .append("x").append(quantity).append("Kg)=")
                .append(pricePerKg*quantity);




        String finalString = stringBuilder.toString();
        return finalString;


    }



}

