package InterviewProblems.FileSystem;

import java.util.HashMap;
import java.util.Map;

public class Directory extends FileSystemNode{
    private Map<String, FileSystemNode> children = new HashMap<>();

    public Directory(String name, Directory parent){
         super(name, parent);

    }
    public void addChild(FileSystemNode node){
        children.put(node.getName(), node);
    }

    public FileSystemNode getChild(String name){
        return children.get(name);
    }

    public void  removeChild(String name){
        children.remove(name);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }
}
