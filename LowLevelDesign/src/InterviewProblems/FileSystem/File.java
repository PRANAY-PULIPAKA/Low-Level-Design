package InterviewProblems.FileSystem;

public class File extends FileSystemNode{
    private String content;
    public File(String name, Directory parent, String content){
        super(name, parent);
        this.content = content;
    }
    public String read(){
        return content;
    }
    public void write(String content){
      this.content = content;
      this.modifiedAt = System.currentTimeMillis();
    }
    @Override
    public boolean isDirectory() {
        return false;
    }
}
