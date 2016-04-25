package quoters;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jeka on 02/10/2015.
 */


@Transactional
@Component
@Order(1)
public class TerminatorQuoter implements Quoter {

    private List<String> messages;

    @Value("${terminator}")
    public void setMessages(String[] messages) {
        this.messages = Arrays.asList(messages);
    }

    public void terminate(){
        new Thread(() -> {
            System.out.println("You are terminated...");
        }).start();

    }

    @Override
    @Benchmark
    public void sayQuote() {
        messages.forEach(System.out::println);
    }
}



