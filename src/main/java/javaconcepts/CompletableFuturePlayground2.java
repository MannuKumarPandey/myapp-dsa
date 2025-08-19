package javaconcepts;

import javax.sound.midi.Soundbank;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFuturePlayground2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorThreads = Executors.newFixedThreadPool(3);


        //runAsync means a async call which will not retrurn any valuye as output
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(100);
                System.out.println(Thread.currentThread().getName()+" "+ "task is done.");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, executorThreads);



        //use of supplyAsync() where we will return some output from that executor service task
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(100);
                return Thread.currentThread().getName()+ " " + "Task 2 result";
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }, executorThreads);


        //chain apply
        CompletableFuture<String> future3 = future2.thenApply(result-> result+" is processed by thenApply()").thenApply(result->result.toUpperCase());


        //Now consume result of future3 without returning anything
        CompletableFuture<Void> future4 = future3.thenAccept(r->{
            System.out.println(" then accept "+ r);
        });


        //run after completion without returning anything
        CompletableFuture<Void> future5 = future4.thenRun(()->{
            System.out.println("then run Task is finished without returning the values.");
        });


        //combine two independent futures
        CompletableFuture<Integer> future6 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(100);
                return 100;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }, executorThreads);

        CompletableFuture<Integer> future7 = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(200);
                return 200;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }, executorThreads);


        //combining future6 and future7
        CompletableFuture<Integer> combined = future6.thenCombine(future7, (a,b)-> a+b);
        System.out.println(combined.get());


        //thenCompose---> chaining supplyAsync
        CompletableFuture<String> composed = future6.thenCompose((num)->{
            System.out.println("Before compose the result: "+num);
            return CompletableFuture.supplyAsync(()-> "ComposedResult :"+ num*2);
        });
        System.out.println(composed.get());



    }
}
