import io.sentry.Sentry

fun main(args: Array<String>) {

    Sentry.init {
        it.dsn = args[0]
        it.environment = "QA"
        it.release = "0.1.0"
    }
    startApp()
}

fun startApp() {
    try {
        throw Exception("Test Exception")
    } catch (e: Exception) {
        Sentry.captureException(e)
    }
}
