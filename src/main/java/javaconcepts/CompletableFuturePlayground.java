package javaconcepts;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletableFuturePlayground {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 1️⃣ Run async without returning a value
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            sleep(500);
            System.out.println(Thread.currentThread().getName() + " - Task 1 done");
        }, executor);

        // 2️⃣ Run async returning a value
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(700);
            return Thread.currentThread().getName() + " - Task 2 result";
        }, executor);

        // 3️⃣ Chain transformations
        CompletableFuture<String> future3 = future2
                .thenApply(result -> result + " + processed by thenApply")
                .thenApply(String::toUpperCase);

        // 4️⃣ Consume result without returning anything
        CompletableFuture<Void> future4 = future3.thenAccept(r ->
                System.out.println("thenAccept: " + r)
        );

        // 5️⃣ Run after completion without using result
        CompletableFuture<Void> future5 = future4.thenRun(() ->
                System.out.println("thenRun: Task finished without result")
        );

        // 6️⃣ Combine two independent futures
        CompletableFuture<Integer> future6 = CompletableFuture.supplyAsync(() -> {
            sleep(400);
            return 10;
        }, executor);

        CompletableFuture<Integer> future7 = CompletableFuture.supplyAsync(() -> {
            sleep(600);
            return 20;
        }, executor);

        CompletableFuture<Integer> combined = future6.thenCombine(future7, (a, b) -> a + b);

        // 7️⃣ Compose (flatten) two futures
        CompletableFuture<String> composed = future6.thenCompose(num ->
                CompletableFuture.supplyAsync(() -> "Composed result: " + (num * 2))
        );

        // 8️⃣ allOf and anyOf
        CompletableFuture<Void> all = CompletableFuture.allOf(future1, future2, future3, future4, future5, combined, composed);
        CompletableFuture<Object> any = CompletableFuture.anyOf(future2, future6);

        // 9️⃣ Exception handling
        CompletableFuture<String> withError = CompletableFuture.supplyAsync(() -> {
            sleep(200);
            if (true) throw new RuntimeException("Boom!");
            return "No error";
        }).exceptionally(ex -> "Recovered from: " + ex.getMessage());

        // 1️⃣0️⃣ Handle (process success or failure)
        CompletableFuture<String> handled = CompletableFuture.supplyAsync(() -> {
            if (new Random().nextBoolean()) throw new RuntimeException("Random fail");
            return "Success!";
        }).handle((res, ex) -> (ex == null) ? res : "Handled error: " + ex.getMessage());

        // 1️⃣1️⃣ whenComplete (inspect but don’t change result)
        CompletableFuture<String> inspected = CompletableFuture.supplyAsync(() -> "Final result")
                .whenComplete((res, ex) -> {
                    if (ex == null) System.out.println("whenComplete: Got " + res);
                    else System.out.println("whenComplete: Error " + ex);
                });

        // 1️⃣2️⃣ Timeout examples
        CompletableFuture<String> timeoutFuture = CompletableFuture.supplyAsync(() -> {
            sleep(2000);
            return "Too slow";
        }).completeOnTimeout("Default due to timeout", 1, TimeUnit.SECONDS);

        CompletableFuture<String> timeoutFail = CompletableFuture.supplyAsync(() -> {
                    sleep(2000);
                    return "Never reached";
                }).orTimeout(1, TimeUnit.SECONDS)
                .exceptionally(ex -> "Timeout exception: " + ex.getMessage());

        // Wait for results
        System.out.println("combined: " + combined.get());
        System.out.println("composed: " + composed.get());
        System.out.println("anyOf result: " + any.get());
        System.out.println("withError: " + withError.get());
        System.out.println("handled: " + handled.get());
        System.out.println("inspected: " + inspected.get());
        System.out.println("timeoutFuture: " + timeoutFuture.get());
        System.out.println("timeoutFail: " + timeoutFail.get());

        all.join(); // wait for all to finish
        executor.shutdown();
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
