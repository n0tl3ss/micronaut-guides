package example.micronaut

import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment
import io.micronaut.retry.annotation.Fallback
import org.reactivestreams.Publisher
import reactor.core.publisher.Mono
import jakarta.inject.Singleton
import javax.validation.constraints.NotBlank

@Requires(env = Environment.TEST)
@Fallback
@Singleton
class BookInventoryClientStub implements BookInventoryOperations {

    @Override
    Mono<Boolean> stock(@NotBlank String isbn) {
        if (isbn == "1491950358") {
            return Mono.just(Boolean.TRUE)

        } else if (isbn == "1680502395") {
            return Mono.just(Boolean.FALSE)
        }
        Mono.empty()
    }
}
