public class Products {
    private int prdId;
    private String prdName;
    private double unitPrice;
    private int qty;
    private String date;

    public Products(){

    }

    public Products(int prdId, String prdName, double unitPrice, int qty, String date) {
        this.prdId = prdId;
        this.prdName = prdName;
        this.unitPrice = unitPrice;
        this.qty = qty;
        this.date = date;

    }

    public int getPrdId() {
        return prdId;
    }

    public String getPrdName() {
        return prdName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQty() {
        return qty;
    }

    public String getDate() {
        return date;
    }
}
