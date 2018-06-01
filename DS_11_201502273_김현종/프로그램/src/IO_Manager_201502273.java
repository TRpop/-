import java.io.*;
import java.nio.file.Paths;

public class IO_Manager_201502273 {
    BufferedReader br;

    String filename = Paths.get("src","Random", "1000000.txt").toString();	//������ ���
    StringBuffer sb;


    String readData() {
        try {
            br = new BufferedReader(new FileReader(filename));	//���� �о����
            sb = new StringBuffer();
            int i;
            while ((i = br.read()) != -1) {	//���� �����Ͱ� ������
                sb.append((char)i);	//StringBuffer�� append
            }
        } catch (IOException e) {	//IOErrorHandler
            e.printStackTrace();
        }
        return sb.toString();	//���� String ��ȯ
    }
}




