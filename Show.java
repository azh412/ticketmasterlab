public class Show {
    private String date;
    private double price;
    private int quantity;
    private String performer;
    private String city;
    public Show(String date, double price, int quantity, String performer, String city){
        this.date = date;
        this.price = price;
        this.quantity = quantity;
        this.performer = performer;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public double getPrice() {
        return price;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString() {
        int spaces = 30 - performer.length();
        String s1 = date + "\t$" + price + "\t\t" + quantity + "\t\t" + performer;
        for (int i = 0; i < spaces; i++){
            s1 += " ";
        }
        s1 += city;
        return s1;
    }
}
