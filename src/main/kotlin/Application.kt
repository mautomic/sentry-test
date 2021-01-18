import io.sentry.Sentry

fun main(args: Array<String>) {

    Sentry.init {
        it.dsn = if (args.size > 0) args[0] else ""
        it.environment = "QA"
        it.release = "v0.1.4"
    }
    startApp("Secondary Test Message")
}

fun startApp(message: String) {

    try {
        throw IllegalCallerException(message)
    } catch (e: IllegalCallerException) {
        Sentry.captureException(e)
    }
}
