package InterviewProblems.LoggingSystem;

import java.time.LocalDateTime;

public class LogMessage {
    private LogLevel level;
    private String message;
    private LocalDateTime timeStamp;

    public LogMessage(LogLevel level, String message){
        this.level = level;
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }

    public LogLevel getLevel(){
        return level;
    }

    public String getFormattedMessage(){
        return "[" +timeStamp+"] [" + level + "] " + message;
    }


}
