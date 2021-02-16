package no.systek.cloud

import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component
import java.time.Instant
import java.time.format.DateTimeFormatter

@Component
class TestQueryResolver: GraphQLQueryResolver {
    fun hello() = "Hello from Cloud Workshop " + DateTimeFormatter.ISO_INSTANT.format(Instant.now())
}
