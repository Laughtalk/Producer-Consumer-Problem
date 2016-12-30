package producer_consumer;

public class Consumer implements Runnable{

    private String consumerName = null; 
    
    private StoreHouse storeHouse = null; 
 
    public Consumer(String consumerName, StoreHouse storeHouse) { 
        this.consumerName = consumerName; 
        this.storeHouse = storeHouse; 
    } 
     
    public void setConsumerName(String consumerName) { 
        this.consumerName = consumerName; 
    } 
     
    public String getConsumerName() { 
        return consumerName; 
    } 
     
    public void execConsume() { 
        while (true) { 
        	Product pro = storeHouse.pop();
            try { 
                Thread.sleep(400); 
            } catch (InterruptedException e) { 
                return; 
            } 
            System.out.println(getConsumerName() + " consumed " + pro); 
        } 
    } 

    @Override
    public void run() {
         execConsume(); 
    }
}
