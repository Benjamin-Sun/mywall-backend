package benjamin_sun.mywallbackend.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;

@Component
public class FtpUtils {

    private final static String ftpIp = "152.136.70.35";
    private final static String ftpUserName = "benjamin";
    private final static String ftpPwd = "12345678";
    private final static String ftpPath = "/home/image/";

    /**
     * ftp连接上传
     * @param file
     * @param fileName
     * @throws IOException
     */
    public static String ftpUpload(MultipartFile file, String fileName) throws IOException {
        FTPClient ftpClient = new FTPClient();
        ftpClient.setRemoteVerificationEnabled(false);
//        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.connect(ftpIp);
        ftpClient.login(ftpUserName, ftpPwd);
//        ftpClient.enterLocalPassiveMode();
        int replyCode = ftpClient.getReplyCode(); //是否成功登录服务器
        if(!FTPReply.isPositiveCompletion(replyCode)){
            System.out.println("connect failed...ftp服务器");
        }

        FileInputStream inputStream = (FileInputStream) file.getInputStream();
        ftpClient.changeWorkingDirectory(ftpPath);
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        //第一个参数：服务器端文档名
        //第二个参数：上传文档的inputStream
        String newName = ImageUtils.getFileName(fileName);
        ftpClient.storeFile(newName, inputStream);
        ftpClient.logout();
        return  "/image/" + newName;
    }
}
