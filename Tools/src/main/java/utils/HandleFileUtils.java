package utils;

import org.testng.annotations.Test;

import java.io.*;

/**
 * 处理文件小工具
 *
 * @author lijinjin
 */
public class HandleFileUtils {
    /**
     * 处理桌面文件，给txt文件每行格式改为：[...](...)
     */
    @Test
    public void handleDesktopFiles() throws IOException {
        // File file = new File("C:/Users/admin/Desktop/网盘资源by金大神.txt");
        //File newfile = new File("C:/Users/admin/Desktop/newfile.txt");

        InputStreamReader fReader = new InputStreamReader(new FileInputStream("src\\main\\resources\\网盘资源by金大神.txt"), "GBK");
        BufferedReader br = new BufferedReader(fReader);
//        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\admin\\Desktop\\网盘资源by金大神.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\admin\\Desktop\\神奇Website.txt"));
        String line = null;
        //            bw.write("[" + line.substring(0, line.indexOf("http")) +
        //                    "](" + line.substring(line.indexOf("http")+1));
        // System.out.println(line.indexOf("http"));
        while ((line = br.readLine()) != null) {
            if (line.contains("http:")||line.contains("https:")) {
                String s1 = "[" + line.substring(0, line.indexOf("http"));
                String s2 = "](" + line.substring(line.indexOf("http")) + ")";
                String s3 = s1 + s2;
                System.out.println(s3);
                bw.write(s3);
                bw.newLine();
            }else{
                bw.write(line);
                bw.newLine();
            }
        }
        br.close();
        bw.close();
    }
}
