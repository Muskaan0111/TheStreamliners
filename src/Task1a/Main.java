package Task1;

public class Main {
    public static void main(String[] args){
        Product product=new Product("fan",1500);
        Product product1=new Product("fan",1500);
        Product product2=new Product("A.c",1500);


        System.out.println(product);
        System.out.println(product1);
        System.out.println(product2);


        System.out.println(product.equals(product1));

        System.out.println(  SpecialProduct.applyOffOnProduct(product,50));




    }
















}
