package InterviewProblems.FileSystem;

public abstract class FileSystemNode {

    protected String name;
    protected Directory parent;

    protected long createdAt;

    protected long modifiedAt;

    public FileSystemNode(String name, Directory parent){
        this.name = name;
        this.parent = parent;
        this.createdAt = System.currentTimeMillis();
        this.modifiedAt = createdAt;
    }

    public String getName(){
        return name;
    }
    public abstract boolean isDirectory();
}


