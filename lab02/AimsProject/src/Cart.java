public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if(this.qtyOrdered >= MAX_NUMBERS_ORDERED) {
            System.err.println("The cart is almost full!");
        } else {
            this.itemsOrdered[qtyOrdered] = disc;
            this.qtyOrdered += 1;
            System.err.println("The disc has been added!");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        DigitalVideoDisc new_itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        int cnt = 0;
        for(int i = 0; i < this.qtyOrdered; i++) {
            if(this.itemsOrdered[i] != disc) {
                new_itemsOrdered[cnt] = this.itemsOrdered[i];
                cnt += 1;
            }
        }
        if(cnt != this.qtyOrdered) {
            this.itemsOrdered = new_itemsOrdered;
            this.qtyOrdered = cnt;
            System.err.println("The disc has been removed!");
        } else {
            System.err.println("The disc is not in the card!");
        }
    }
    public float totalCost() {
        float totalCost = 0;
        for(int i = 0; i < this.qtyOrdered; i++) {
            totalCost += this.itemsOrdered[i].getCost();
        }
        return totalCost;
    }
}