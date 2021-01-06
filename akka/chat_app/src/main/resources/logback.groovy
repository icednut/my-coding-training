import ch.qos.logback.classic.PatternLayout

appender("CONSOLE", ConsoleAppender) {
    layout(PatternLayout) {
        pattern = "%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"
    }
}
logger("com.mkyong", DEBUG, ["CONSOLE"], false)
root(INFO, ["CONSOLE"])