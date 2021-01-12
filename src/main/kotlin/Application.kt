import io.sentry.Sentry

fun main(args: Array<String>) {

    Sentry.init {
        it.dsn = args[0]
        it.environment = "QA"
        it.release = "0.1.0"
    }
    startApp("Test Message")
}

fun startApp(message: String) {
    try {
        throw Exception(message)
    } catch (e: Exception) {
        Sentry.captureException(e)
    }
}
