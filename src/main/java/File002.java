import java.io.File;

public class File002 implements DoFile{
    public void doFile(String path) {
        //递归遍历出文件，找出目标文件，删除
        File file = new File(path);
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){
                doFile(f.getPath());
            }else if(f.isFile() && f.getName().startsWith(".")){
                f.delete();
            }
        }

    }


}
