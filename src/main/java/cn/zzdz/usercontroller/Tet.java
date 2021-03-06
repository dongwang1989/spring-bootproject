package cn.zzdz.usercontroller;

import ch.qos.logback.core.net.SyslogOutputStream;
import cn.zzdz.fastfd.FastDFSClient;
import cn.zzdz.interfaces.service.IUserService;
import cn.zzdz.rabbitmq.HelloSender;
import cn.zzdz.redismap.RedisUtils;
import com.github.tobato.fastdfs.domain.MataData;
import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;


import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FilenameUtils;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.cluster.node.DiscoveryNode;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.search.DocValueFormat;
import org.junit.Test;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.*;
import javax.swing.JFrame;

import org.bytedeco.javacpp.Loader;
import org.bytedeco.javacpp.avcodec;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_objdetect;
import org.bytedeco.javacv.*;
import org.bytedeco.javacv.FrameGrabber.Exception;
//@Service
@RestController
//@Api("用户相关操作")
@RequestMapping("/tet")
public class Tet {
    @Autowired
    private FastFileStorageClient fastFileStorageClient;
    @Autowired
    private IUserService userService;


    @ApiOperation(value = "文件上传", httpMethod = "POST")
    @PostMapping(value = "/uppload", headers = "content-type=multipart/form-data")
    public StorePath test(@RequestParam MultipartFile file) throws IOException {
        // 设置文件信息
        Set<MataData> mataData = new HashSet<>();
        mataData.add(new MataData("author", "zonghui"));
        mataData.add(new MataData("description", "xxx文件，嘿嘿嘿"));
        // 上传   （文件上传可不填文件信息，填入null即可）
        StorePath storePath = fastFileStorageClient.uploadFile(file.getInputStream(), file.getSize(), FilenameUtils.getExtension(file.getOriginalFilename()), mataData);
        String url = FastDFSClient.getResAccessUrl(storePath.getFullPath());
        System.out.println("address dizhi:" + url);
        return storePath;
    }

    @RequestMapping("/c")
    public void gec(HttpServletResponse response) {
        String[] bn = {"ClgBYl0uqpCAOALdAJBH5vbiUU0944.jpg",
                 "ClgBYl0mn9GAfRVTAJBH5vbiUU0991.jpg",
                "ClgBYV0dwE2AZGxWAAMtk3_3ZEM177.jpg",
                "ClgBYV0lj7CAF87gAAPpEkpyTYo099.jpg",
                "ClgBYV0lj7SAbjF2AAPpEkpyTYo129.jpg",
                "ClgBYV0Z5MWAf_lAABGFgUK4LA0462.jpg"
                };
        for (String c : bn) {
            FastDFSClient.deleteFile("group1/M00/00/00/" + c);
        }
    }

    @RequestMapping("/cc")
    @CacheEvict(value = "producta", key = "#id")// 清空accountCache 缓存
    public void getrel(String id) {
        System.out.println("cc");
    }

    @Test
    public void ab() {
        String[] bn = {"rBBkOVziAsWAdeDcABfC2uG9_-o960.pdf"};
        for (String c : bn) {
            FastDFSClient.deleteFile("group1/M00/00/00/" + c);
        }

    }

    //Cookie cookie = new Cookie("access_token", UUID.randomUUID().toString());
    @RequestMapping("/aa")
    public void aa(HttpServletResponse response) {
        Cookie cookie = new Cookie("access_token", "aa");
        response.addCookie(cookie);
    }

    @RequestMapping("/aaa")
    public void aaa(HttpServletResponse response) {
        Cookie cookie = new Cookie("access_token", "aaa");
        response.addCookie(cookie);
    }

    @RequestMapping("/bb")
    public void bb(HttpServletResponse response) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        Cookie cook = null;
        for (Cookie c : cookies) {
            System.out.println(c.getName() + ":" + c.getValue());
        }
//        Cookie ncookie = new Cookie("access_token", null);//重新设置cook
//        ncookie.setMaxAge(0); //立即删除型
//        //ncookie.setPath("/"); //项目所有目录均有效，这句很关键，否则不敢保证删除
//        response.addCookie(ncookie);
    }

    @Autowired
    private TransportClient client;

    @Test
    public void contextLoads() {
    }

    //    @Autowired
//    private TransportClient transportClient;
    @RequestMapping("/ccc")
    public ResponseEntity cc() {
        try {
            XContentBuilder content = XContentFactory.jsonBuilder()
                    .startObject()
                    .field("title", "cc")
                    .field("author", "ca")
                    .field("word_count", 1)
                    .field("publish_date", "2019")
                    .endObject();

            IndexResponse result = this.client.prepareIndex("book", "novel")
                    .setSource(content)
                    .get();
            return new ResponseEntity(result.getId(), HttpStatus.OK);//AWq0Q9K5xqLr6T6kND90
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        //GetResponse result = transportClient.prepareGet("td", "er", id).get();
        //transportClient.admin().indices().prepareCreate("www").execute().actionGet();
//        SearchResponse response = transportClient.prepareSearch("td").setTypes("er").get();
//        SearchHits searchHits = response.getHits();
//        for (SearchHit searchHit : searchHits) {
//            Map<String, Object> sourceAsMap = searchHit.getSourceAsMap();
//            System.out.println(sourceAsMap.size());
//        }
        //Optional<SysUser> user= sysUserRepository.findById(1);
        //System.out.println(user.get().getUsername()+"&&&&&&&&&&&&");
        //throw new Error(ErrorMessage.INCORRECT_PASSWORD, "acc");
    }

    //删除
    @DeleteMapping("delete/book/novel")
    @ResponseBody
    public ResponseEntity delete(@RequestParam(name = "id") String id) {
        DeleteResponse result = this.client.prepareDelete("book", "novel", id).get();
        return new ResponseEntity(result.getResult().toString(), HttpStatus.OK);
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping(value = "/caa", method = RequestMethod.GET)
    public void createIndex(@Validated @Null(message = "not null") String uu) {
        stringRedisTemplate.opsForValue().set("count", "1");
        String dd = "";
    }

    @Autowired
    private HelloSender helloSender;

    @RequestMapping(value = "/ca", method = RequestMethod.GET)
    public void aa() {

        //for (int i = 0; i <3 ; i++) {
        helloSender.send(3);
        //}
    }

    private static int[] account;

    @Test
    public void thr() throws InterruptedException {
        account = new int[]{100, 200};
        //MainWork mainWork = new MainWork();
        //需要注意的是子线程必须在主线程之前回调
        //原因在于，我们的主线程在回调transfer方法时由于
        //转钱者资金不足会导致主线程进入wait状态，需要等待
        //其他线程再次进入该对象拿到对象锁，并通过回调notify或者notifyAll
        //方法来唤醒主线程继续执行
        new Thread() {
            public void run() {
                try {
                    Thread.sleep(20000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                transfer(1, 0, 10);
            }
        }.start();
        //由于账户0资金不足120，本方法回调会导致主线程进入wait状态
        transfer(0, 1, 120);
        System.out.println(account[0]);
    }

    public synchronized void transfer(int from, int to, int count) {
        while (account[from] < count) {
            System.out.println("in");
            try {
                System.out.println("对不起，资金不足，进入等待状态" + Thread.currentThread().getName());
                //进入等待，会释放锁。需要外界再次回调本方法（拿到本对象锁），并
                //回调notify唤醒线程，以便查看是否资金是否充足
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("从" + from + "账户转钱到" + to + "账户" + count + "元钱" + Thread.currentThread().getName());
        account[from] -= count;
        account[to] += count;
        notifyAll();
    }

    Integer ca = 0;

    @Test
    public void pc() throws InterruptedException {
        new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        System. out .println("pro  i:" +i);
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    producer(i);
                }
            }
        }.start();
        //Thread.sleep(3000);
        new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        System. out .println("Con: i " +i);
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    cou(i);
                }
            }
        }.start();

    }

    public synchronized void producer(int i) {
        //System.out.println("adducc");
        while (ca == 5) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ca++;
        System.out.println("adducc" + i + "aa" + ca);
        notify();
    }

    public synchronized void cou(int i) {
        while (ca <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ca--;
        System.out.println("reduce" + i + "aa" + ca);
        notify();
    }
    @Test
    public  void recordCamera()
            throws Exception, InterruptedException, org.bytedeco.javacv.FrameRecorder.Exception {
        String outputFile="rtmp://172.16.100.80:1935/stream/example";
        double frameRate=25;
        Loader.load(opencv_objdetect.class);
        FrameGrabber grabber = FrameGrabber.createDefault(0);//本机摄像头默认0，这里使用javacv的抓取器，至于使用的是ffmpeg还是opencv，请自行查看源码
        grabber.start();//开启抓取器

        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();//转换器
        opencv_core.IplImage grabbedImage = converter.convert(grabber.grab());//抓取一帧视频并将其转换为图像，至于用这个图像用来做什么？加水印，人脸识别等等自行添加
        int width = grabbedImage.width();
        int height = grabbedImage.height();

        FrameRecorder recorder = FrameRecorder.createDefault(outputFile, width, height);
        recorder.setVideoCodec(avcodec.AV_CODEC_ID_H264); // avcodec.AV_CODEC_ID_H264，编码
        recorder.setFormat("flv");//封装格式，如果是推送到rtmp就必须是flv封装格式
        recorder.setFrameRate(frameRate);

        recorder.start();//开启录制器
        long startTime=0;
        long videoTS=0;
        CanvasFrame frame = new CanvasFrame("camera", CanvasFrame.getDefaultGamma() / grabber.getGamma());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(true);//
        Frame rotatedFrame=converter.convert(grabbedImage);//不知道为什么这里不做转换就不能推到rtmp
        while (frame.isVisible() && (grabbedImage = converter.convert(grabber.grab())) != null) {
            rotatedFrame = converter.convert(grabbedImage);
            frame.showImage(rotatedFrame);
            if (startTime == 0) {
                startTime = System.currentTimeMillis();
            }
            videoTS = 1000 * (System.currentTimeMillis() - startTime);
            recorder.setTimestamp(videoTS);
            recorder.record(rotatedFrame);
            Thread.sleep(40);
        }
        frame.dispose();
        recorder.stop();
        recorder.release();
        grabber.stop();

    }


}
