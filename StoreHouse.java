package producer_consumer;


public class StoreHouse {

    private int base = 0;
    private int top = 0;
    private int i=0;
    //≤÷ø‚¥Û–°
    private Product[] products = new Product[10];
    
    /**
     * Produce products.
     * @param product
     */
    public synchronized Product push(){
    	i++;
    	Product product = new Product(i);
        while(top==products.length){
            try {
                System.out.println("Store house is full. Waiting...");
                wait();
            }catch (InterruptedException e) { 
                System.out.println("stop push product because other reasons"); 
            } 
        }
        products[top] = product;
        top++;
        notifyAll();
        return product;
    }
    
    /**
     * Consume products.
     * @return
     */
    public synchronized Product pop() { 
        Product product = null; 
        while (top == base) {
            try { 
                System.out.println("Store house is empty. Waiting..."); 
                wait(); 
            } catch (InterruptedException e) { 
                System.out.println("stop push product because other reasons"); 
            } 
        } 
        top--;
        product = products[top]; 
        products[top] = null;
        notifyAll();
        return product; 
    }     
}
