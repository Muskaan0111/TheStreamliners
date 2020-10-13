package Task1;

public class SpecialProduct extends Product {

    int regularPrice, percentageOff;

    public SpecialProduct(String name, int price) {
        super(name, price);


    }


    @Override
    public String toString() {
        return String.format(super.toString() + "," + " " + "regularPrice=%d PercentageOff=%d", regularPrice, percentageOff);
    }

    static SpecialProduct applyOffOnProduct(Product product, int percentageOff) {
        int off = (percentageOff * product.price) / 100;

        int discountedPrice = (int) (product.price - off);
        System.out.println(discountedPrice);
        SpecialProduct specialProduct = new SpecialProduct(product.name, discountedPrice);

        specialProduct.regularPrice = product.price;
        specialProduct.percentageOff = percentageOff;
        return specialProduct;


    }

}
