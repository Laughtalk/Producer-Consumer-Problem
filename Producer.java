package producer_consumer;

public class Producer implements Runnable{

    private String producerName ;
    private StoreHouse storeHouse ;
    
    public Producer(String producerName, StoreHouse storeHouse) { 
        this.producerName = producerName; 
        this.storeHouse = storeHouse; 
    } 
 
    public void setProducerName(String producerName) { 
        this.producerName = producerName; 
    } 
 
    public String getProducerName() { 
        return producerName; 
    } 
     
    @Override
    public void run() {
        execProcuct();
    }

    private void execProcuct() {
        while(true){
             Product pro = storeHouse.push(); 
             try { 
                 Thread.sleep(200); 
             } catch (InterruptedException e) { 
                 return; 
             } 
             System.out.println(getProducerName() + " produced " + pro); 
        }
    }
}
