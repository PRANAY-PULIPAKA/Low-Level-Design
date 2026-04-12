package InterviewProblems.LoggingSystem;

import java.util.List;

public class Logger {

    private static Logger loggerInstance;
    private LogLevel currentLevel;

    private List<LogAppender> appenders;

    private Logger(LogLevel level, List<LogAppender> appenders){
        this.currentLevel = level;
        this.appenders = appenders;
    }

    public static synchronized Logger getInstance(LogLevel level, List<LogAppender> appenders){
        if(loggerInstance == null){
            loggerInstance = new Logger(level, appenders);
        }
        return  loggerInstance;
    }

    public void log(LogLevel level, String message){
        if(level.getPriority() >= currentLevel.getPriority()){
            LogMessage logMessage = new LogMessage(level, message);
            for(LogAppender appender :appenders){
                appender.append(logMessage);
            }
        }
    }

    public void info(String msg){
        log(LogLevel.INFO, msg);
    }
    public void debug(String msg){
        log(LogLevel.DEBUG, msg);
    }
    public void warn (String msg){
        log(LogLevel.WARN, msg);
    }
    public void error(String msg){
        log(LogLevel.ERROR, msg);
    }

}
