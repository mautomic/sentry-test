import io.sentry.Sentry
import java.lang.IllegalStateException

fun main(args: Array<String>) {

    Sentry.init {
        it.dsn = if (args.size > 0) args[0] else ""
        it.environment = "QA"
        it.release = "v0.1.3"
    }
    startApp("Another Test Message")
}

fun startApp(message: String) {

    try {
        throw IllegalStateException(message)
    } catch (e: IllegalStateException) {
        Sentry.captureException(e)
    }
}
