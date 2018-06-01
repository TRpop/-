import java.io.*;
import java.nio.file.Paths;

public class IO_Manager_201502273 {
    BufferedReader br;

    String filename = Paths.get("src","Random", "1000000.txt").toString();	//데이터 경로
    StringBuffer sb;


    String readData() {
        try {
            br = new BufferedReader(new FileReader(filename));	//파일 읽어오기
            sb = new StringBuffer();
            int i;
            while ((i = br.read()) != -1) {	//읽은 데이터가 있으면
                sb.append((char)i);	//StringBuffer에 append
            }
        } catch (IOException e) {	//IOErrorHandler
            e.printStackTrace();
        }
        return sb.toString();	//만든 String 반환
    }
}




