import io.sentry.Sentry

fun main(args: Array<String>) {

    Sentry.init {
        it.dsn = args[0]
        it.environment = "QA"
        it.release = "0.1.1"
    }
    startApp("Different Test Message")
}

fun startApp(message: String) {
    try {
        throw IllegalAccessException(message)
    } catch (e: IllegalAccessException) {
        Sentry.captureException(e)
    }
}
