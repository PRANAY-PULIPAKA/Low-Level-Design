package InterviewProblems.LoggingSystem;

import java.io.FileWriter;
import java.io.IOException;

public class FileAppender implements LogAppender{

    private String filePath;

    public FileAppender(String filePath){
        this.filePath = filePath;
    }
    @Override
    public synchronized void append(LogMessage message) {
        try(FileWriter fw = new FileWriter(filePath,true)){
           fw.write(message.getFormattedMessage() + "/n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
