import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * 未完成，暂不需要了
 * Lombok已安装
 */
public class File003 implements DoFile{
    public static void main(String[] args) {
        System.out.println("hello");
    }

    public void doFile(String path) {
        File f = new File(path);
        File[] fs = f.listFiles();
        for(File file : fs){
            if(file.isDirectory()){
                doFile(file.getPath());
            }else{
                String content = getStrFromFile(file);
                content.replace("log.info","System.out.println");
                content.replace("log.error","System.out.println");
            }
        }
    }

    public String getStrFromFile(File file){
        StringBuffer sf = new StringBuffer();
        FileInputStream fs = null;
        BufferedInputStream bf = null;
        try {
            fs = new FileInputStream(file);
            bf = new BufferedInputStream(fs);
            byte[] buffer = new byte[1024];
            int len = -1;
            while((len = bf.read(buffer)) != -1){
                sf.append(new String(buffer,0,len));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if(null != bf){
                    bf.close();
                }
                if(null != fs){
                    fs.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return sf.toString();
    }
}
