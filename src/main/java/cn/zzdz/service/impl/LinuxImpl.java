package cn.zzdz.service.impl;

import cn.zzdz.interfaces.service.ILinux;
import org.springframework.stereotype.Service;
import ch.ethz.ssh2.Connection;
import ch.ethz.ssh2.Session;

import java.io.*;
import java.net.InetAddress;
import java.util.*;

import static io.netty.handler.codec.http.HttpConstants.DEFAULT_CHARSET;

@Service
public class LinuxImpl implements ILinux {
    private static Connection connection;

    @Override
    public String getMemory(String ip) {
        String value="";
        if (net(ip) && openConnection(ip, "root")) {
            value=execCommand(connection,"free -h");
        }
        return value;
    }

    @Override
    public String getContainers(String ip) {
        String value="";
        if (net(ip) && openConnection(ip, "root")) {
            value=execCommand(connection,"dokcer ps -a");
        }
        return value;
    }

    @Override
    public String getDev(String ip) {
        String value="";
        if (net(ip) && openConnection(ip, "root")) {
            value=execCommand(connection,"df -hl /");
        }
        return value;
    }

    public String execCommand(Connection connection, String command) {
        List<String> ar = null;
        Session session = null;
        try {
            session = connection.openSession();
            // 执行命令
            session.execCommand(command);
            ar = parseResult(session.getStdout());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return ar.toString();
    }

    private List<String> parseResult(InputStream inputStream) throws IOException {
        List<String> arrTr = new ArrayList<String>();
        // 读取输出流内容
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream, DEFAULT_CHARSET));
        StringBuffer resultSb = new StringBuffer();
        String line;
        while ((line = br.readLine()) != null) {
            arrTr.add(line);
        }
        return arrTr;
    }

    public String repaceWhiteSapce(String original) {
        StringBuilder sb = new StringBuilder();
        boolean isFirstSpace = false;//标记是否是第一个空格
        original = original.trim();//如果考虑开头和结尾有空格的情形

        char c;
        for (int i = 0; i < original.length(); i++) {
            c = original.charAt(i);
            if (c == ' ' || c == '\t')//遇到空格字符时,先判断是不是第一个空格字符
            {
                if (!isFirstSpace) {
                    sb.append(c);
                    isFirstSpace = true;
                }
            } else {//遇到非空格字符时
                sb.append(c);
                isFirstSpace = false;
            }
        }
        return sb.toString();
    }

    public boolean openConnection(String host, String username) {
        File keyfile = new File("~/.ssh/id_pub");
        boolean ac = false;
        try {
            connection = new Connection(host);
            connection.connect();
            boolean isAuthenticated = connection.authenticateWithPublicKey(username, keyfile, "");
            if (isAuthenticated) {
                ac = true;
            }

        } catch (IOException e) {

        }
        return ac;

    }

    public boolean net(String ip) {
        int timeOut = 30000; //超时应该在3钞以上

        boolean val = false;
        try {
            val = InetAddress.getByName(ip).isReachable(timeOut);
        } catch (IOException e) {
            return val;
        }
        return val;
    }
}
