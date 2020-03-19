package charlie.com.e.portofolio.model;

public class Item{
    private String ItemName;
    private String Stock;
    private String ExpDate;

    public Item(){}
    public Item(String itemName, String stock, String expDate){
        this.ItemName = itemName;
        this.Stock = stock;
        this.ExpDate = expDate;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public String getStock() {
        return Stock;
    }

    public void setStock(String stock) {
        Stock = stock;
    }

    public String getExpDate() {
        return ExpDate;
    }

    public void setExpDate(String expDate) {
        ExpDate = expDate;
    }
}
