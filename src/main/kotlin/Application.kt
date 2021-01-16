import io.sentry.Sentry
import io.sentry.SentryEvent
import io.sentry.SentryLevel

fun main(args: Array<String>) {

    Sentry.init {
        it.dsn = args[0]
        it.environment = "QA"
        it.release = "0.1.2"
    }
    startApp("Latest Test Message")
}

fun startApp(message: String) {

    try {
        throw IllegalAccessException(message)
    } catch (e: IllegalAccessException) {
        Sentry.captureException(e)
    }
}
