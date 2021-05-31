package calculationengine;

import config.BattleConstants;

import java.util.concurrent.*;

public class CeExecuterService {

    private static final ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
    private static final boolean debug = BattleConstants.battleDebug;

    public static void addThreadToExecutor(Runnable runnable){
        executorService.execute(runnable);
        if(debug) System.out.println("[CE Executor Service] Active Threads: " + executorService.getActiveCount());
    }

    public static void shutdownExecutor(){
        executorService.shutdown();
        if(debug) System.out.println("[CE Executor Service] Active Threads: " + executorService.getActiveCount());
        if(debug) System.out.println("[CE Executor Service]: Shut Down Executor");
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
