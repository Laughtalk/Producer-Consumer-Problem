package producer_consumer;

public class TestPC {

    public static void main(String[] args) {
         StoreHouse storeHouse = new StoreHouse(); 
         Producer producer_A = new Producer("Producer_A", storeHouse); 
         //Producer producer_B = new Producer("Producer_B", storeHouse); 
         Consumer comsumer_A = new Consumer("Consumer_A", storeHouse);
         Consumer comsumer_B = new Consumer("Consumer_B", storeHouse);
         Thread thread_producer_A = new Thread(producer_A); 
         //Thread thread_producer_B = new Thread(producer_B); 
         Thread thread_comsumer_A = new Thread(comsumer_A); 
         Thread thread_comsumer_B = new Thread(comsumer_B); 
         thread_producer_A.start(); 
         //thread_producer_B.start(); 
         thread_comsumer_A.start(); 
         thread_comsumer_B.start(); 
    }
}
