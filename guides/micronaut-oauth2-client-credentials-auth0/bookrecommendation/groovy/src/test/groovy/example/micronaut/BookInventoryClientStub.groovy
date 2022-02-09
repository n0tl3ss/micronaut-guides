package example.micronaut

import io.micronaut.context.annotation.Requires
import io.micronaut.core.annotation.NonNull
import io.micronaut.retry.annotation.Fallback
import jakarta.inject.Singleton
import reactor.core.publisher.Mono
import javax.validation.constraints.NotBlank
import static io.micronaut.context.env.Environment.TEST
import io.micronaut.core.util.StringUtils
import io.micronaut.context.annotation.Property

@Property(name = 'micronaut.security.enabled', value= StringUtils.FALSE)
@Requires(env = TEST) // <1>
@Fallback
@Singleton
class BookInventoryClientStub implements BookInventoryOperations {

    @Override
    Mono<Boolean> stock(@NonNull @NotBlank String isbn) {
        if (isbn == "1491950358") {
            return Mono.just(true) // <2>
        }
        if (isbn == "1680502395") {
            return Mono.just(false) // <3>
        }
        Mono.empty() // <4>
    }
}