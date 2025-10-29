package Lab;

public class Price {
    public static void main(String[] args) {

        float orginalprice = 250;
        float disocountedpercentage = 15;
        float discountedamount = (disocountedpercentage / 100) * orginalprice;
        float finalprice = orginalprice - discountedamount;
        System.out.printf("final pricer after  discount", disocountedpercentage, finalprice);
    }

}
