import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class App {
    public static void doFile(String code,String path){
        Properties prop = new Properties();
        InputStream is = App.class.getResourceAsStream("filecode.properties");
        try {
            prop.load(is);
        } catch (IOException e) {
            System.out.println("file is not exist ");
        }finally {
            try {
                is.close();
            } catch (IOException e) {}
        }
        String className = prop.getProperty(code);
        if(className == null || "".equals(className)){
            throw new RuntimeException("code "+"["+code+"] is not exists ");
        }
        try {
            DoFile fileHandler = (DoFile) Class.forName(className).newInstance();
            fileHandler.doFile(path);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("ok");
    }

    public static void main(String[] args) {
        App.doFile("002","/Volumes/D/VBlog-master/vueblog");
    }
}
