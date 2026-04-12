package InterviewProblems.FileSystem;

public class FileSystemManager {

   private  Directory root = new Directory("/", null);
   public void createDirectory(String path){
       traverseAndCreate(path, true, null);

   }
   public void createFile(String path, String content){
       traverseAndCreate(path,false, content);
   }

   public void traverseAndCreate(String path, boolean isDir, String content){
       String [] parts = path.split("/");
       Directory current = root;

       for (int i = 1; i < parts.length - 1; i++) {
         FileSystemNode node = current.getChild(parts[i]);
         if(node == null || !node.isDirectory()){
             throw new RuntimeException("Invalid path");
         }
         current = (Directory) node;
       }

       String name = parts[parts.length - 1];

       if (isDir) {
           current.addChild(new Directory(name, current));
       } else {
           current.addChild(new File(name, current, content));
       }
   }

}
