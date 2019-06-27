package cn.zzdz.elasticsearch.dao;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

@Configuration
public class ESconfig {
    //private static final Logger LOGGER = LoggerFactory.getLogger(ESconfig.class);

    /**
     * elk集群地址
     */
    @Value("${elasticsearch.ip}")
    private String hostName;
    /**
     * 端口
     */
    @Value("${elasticsearch.port}")
    private String port;
    /**
     * 集群名称
     */
    @Value("${elasticsearch.cluster.name}")
    private String clusterName;

    /**
     * 连接池
     */
    @Value("${elasticsearch.pool}")
    private String poolSize;

    @Bean
    public TransportClient transportClient() {
        //LOGGER.info("初始化开始。。。。。");
        TransportClient client = null;
        try {

//            TransportAddress transportAddress = new InetSocketTransportAddress(InetAddress.getByName("172.16.100.43"),
//                    Integer.valueOf(port));
//            TransportAddress transportAddress2 = new InetSocketTransportAddress(InetAddress.getByName("172.16.100.41"),
//                    Integer.valueOf(port));
//            TransportAddress transportAddress3 = new InetSocketTransportAddress(InetAddress.getByName("172.16.100.44"),
//                    Integer.valueOf(port));

            // 配置信息
            Settings esSetting = Settings.builder()
                    .put("cluster.name", clusterName)
                    .put("client.transport.sniff", true)//增加嗅探机制，找到ES集群
                    .build();
            //配置信息Settings自定义,下面设置为EMPTY
            client = new PreBuiltTransportClient(esSetting);
            String [] iparr=hostName.split(",");
            for (String ip:iparr) {
                client.addTransportAddresses(new InetSocketTransportAddress(InetAddress.getByName(ip),
                        Integer.valueOf(port)));
            }
//            client.addTransportAddresses(transportAddress);
//            client.addTransportAddresses(transportAddress2);
//            client.addTransportAddresses(transportAddress3);


        } catch (Exception e) {
            System.out.println("#############");
            //logger.error("elasticsearch TransportClient create error!!!", e);
        }

        return client;
    }

    //@Bean
    public void init() {
//        TransportClient transportClient = null;
//        try {
//            // 配置信息
//            Settings esSetting = Settings.builder()
//                    .put("client.transport.sniff", true)//增加嗅探机制，找到ES集群
//                    //.put("thread_pool.search.size", Integer.parseInt(poolSize))//增加线程池个数，暂时设为5
//                    .put("cluster.name",clusterName)
//                    .build();
//            //配置信息Settings自定义,下面设置为EMPTY
//            transportClient = new PreBuiltTransportClient(esSetting);
//            TransportAddress transportAddress = new InetSocketTransportAddress(InetAddress.getByName(hostName), Integer.valueOf(port));
//            transportClient.addTransportAddresses(transportAddress);
//
//
//        } catch (Exception e) {
//            System.out.println("#############");
//            //throw new Error(ErrorMessage.INCORRECT_PASSWORD, "www");
//        }
//
//        return transportClient;
    }
}
