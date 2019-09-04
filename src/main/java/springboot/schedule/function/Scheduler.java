package springboot.schedule.function;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableAsync
public class Scheduler {

    /**
     * Java Cron expressions are used to configure the instances of CronTrigger, a subclass of org.quartz.Trigger
     */
    @Async
    @Scheduled(cron = "0 * 23 * * ?")
    public void cronJobSch() {
        System.out.println("cronJobSch ==> " + new Date() + Thread.currentThread().getName());
    }

    /**
     * Fixed Rate
     * Fixed Rate scheduler is used to execute the tasks at the specific time.
     * It does not wait for the completion of previous task.
     * The values should be min miliseconds.
     */
    @Async
    @Scheduled(fixedRate = 10000)
    public void fixedRateSch() {
        System.out.println("fixedRateSch ==> " + new Date() + Thread.currentThread().getName());
    }

    /**
     * Fixed Delay
     * Fixed Delay scheduler is used to execute the tasks at a specific time
     * It should wait for the previuos task completion
     * The values should be in miliseconds
     */
    @Async
    @Scheduled(fixedDelay = 1000)
    public void fixedDelaySch() {
        System.out.println("fixedDelaySch ==> " + new Date() + Thread.currentThread().getName());
    }
}
