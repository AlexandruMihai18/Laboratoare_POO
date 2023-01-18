package task2;


import java.util.EnumSet;

enum LogLevel {
    Info,
    Debug,
    Warning,
    Error,
    FunctionalMessage,
    FunctionalError;

    public static EnumSet<LogLevel> all() {
        return EnumSet.allOf(LogLevel.class);
    }
}

abstract class LoggerBase {
    private EnumSet<LogLevel> logLevels;
    private LoggerBase nextLoggerBase = null;

    public LoggerBase(EnumSet<LogLevel> logLevels) {
        this.logLevels = logLevels;
    }

    public void setNext(LoggerBase nextLoggerBase) {
        this.nextLoggerBase = nextLoggerBase;
    }

    protected abstract void writeMessage(String message);

    public void message(String message, LogLevel logLevel) {
        if (logLevels.contains(logLevel)) {
            writeMessage(message);
        }

        if (nextLoggerBase != null) {
            nextLoggerBase.message(message, logLevel);
        }
    }
}

class ConsoleLogger extends LoggerBase {
    public ConsoleLogger() {
        super(LogLevel.all());
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[Console] " + message);
    }
}

class EmailLogger extends LoggerBase {
    public EmailLogger() {
        super(EnumSet.of(LogLevel.FunctionalMessage, LogLevel.FunctionalError));
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[Email] " + message);
    }
}

class FileLogger extends LoggerBase {
    public FileLogger() {
        super(EnumSet.of(LogLevel.Warning, LogLevel.Error));
    }

    @Override
    protected void writeMessage(String message) {
        System.out.println("[File] " + message);
    }
}

public class Main {
    public static void main(final String[] args) {
           LoggerBase logger1 = new ConsoleLogger();
           LoggerBase logger2 = new EmailLogger();
           LoggerBase logger3 = new FileLogger();

           logger1.setNext(logger2);
           logger2.setNext(logger3);

            logger1.message("Se execută metoda ProcessOrder()", LogLevel.Debug);
            logger1.message("Comanda a fost procesată cu succes", LogLevel.Info);
            logger1.message("Datele despre adresa clientului lipsesc din baza de date a filialei", LogLevel.Warning);
            logger1.message("Detele despre adresa clientului lipsesc din baza de date a organizație", LogLevel.Error);
            logger1.message("Nu se poate procesa comanda #Comanda1 datată pe 25.11.2018 pentru clientul #Clientul1",
                    LogLevel.FunctionalError);
            logger1.message("Comandă procesată", LogLevel.FunctionalMessage);
    }
}