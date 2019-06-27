package benjamin_sun.mywallbackend.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

@Component
public class FtpUtils {

    private final static String ftpIp = "152.136.70.35";
    private final static String ftpUserName = "aaa";
    private final static String ftpPwd = "12345678";
    private final static String ftpPath = "/home/image";

    /**
     * ftp连接上传
     * @param file
     * @param fileName
     * @throws IOException
     */
    public static String ftpUpload(MultipartFile file, String fileName) throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect(ftpIp);
        ftpClient.login(ftpUserName, ftpPwd);
        FileInputStream inputStream = (FileInputStream) file.getInputStream();
        ftpClient.changeWorkingDirectory("ftp://" + ftpIp + ftpPath);
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //第一个参数：服务器端文档名
        //第二个参数：上传文档的inputStream
        String newName = ImageUtils.getFileName(fileName);
        ftpClient.storeFile(newName, inputStream);
        ftpClient.logout();
        return ftpIp + ftpPath + "/" + newName;
    }
}
