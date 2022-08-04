package example.micronaut;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

import java.util.Random;

@ExecuteOn(TaskExecutors.IO)
@Controller("/warehouse")
public class WarehouseController {

    @Get("/count")
    public HttpResponse getItemCount() {
        return HttpResponse.ok(new Random().nextInt(11));
    }

    @Post("/order")
    public HttpResponse order() {
        try {
            //To simulate an external process taking time
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }

        return HttpResponse.accepted();
    }
}