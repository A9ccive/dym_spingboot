package com.ruoyi.common.utils;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.CreateBucketRequest;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.ruoyi.framework.config.AliyunOssConfig;
import com.ruoyi.project.awc.dto.aliyunoss.FileDTO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Component
public class AliyunOSSUtil {

    @Autowired
    private AliyunOssConfig constantConfig;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(AliyunOSSUtil.class);

    /**
     * 上传文件
     */
    public FileDTO upLoad(File file) {
        logger.info("------OSS文件上传开始--------" + file.getName());
        String endpoint = constantConfig.getEndpoint();
        System.out.println("获取到的Point为:" + endpoint);
        String accessKeyId = constantConfig.getAccessKeyId();
        String accessKeySecret = constantConfig.getAccessKeySecret();
        String bucketName = constantConfig.getBucketName();
        String fileHost = constantConfig.getFolder();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = format.format(new Date());
        String uuid = UUID.randomUUID().toString().replace("-", "");
        String suffix = file.getName().substring(file.getName().lastIndexOf(".") + 1);
        // 判断文件
        if (file == null) {
            return null;
        }
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            // 判断容器是否存在,不存在就创建
            if (!client.doesBucketExist(bucketName)) {
                client.createBucket(bucketName);
                CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);
                createBucketRequest.setCannedACL(CannedAccessControlList.PublicRead);
                client.createBucket(createBucketRequest);
            }
            // 设置文件路径和名称
            String fileUrl = fileHost + "/" + (dateStr + "/" + uuid) + "-" + file.getName();
            // 设置权限(公开读)
            client.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            // 上传文件
            PutObjectResult result = client.putObject(new PutObjectRequest(bucketName, fileUrl, file));

            if (result != null) {
                System.out.println(result);
                logger.info("------OSS文件上传成功------" + fileUrl);
                return new FileDTO(
                        //文件大小
                        file.length(),
                        //文件的绝对路径
                        fileUrl,
                        //文件的web访问地址
                        constantConfig.getWebUrl() + "/" + fileUrl,
                        //文件后缀
                        suffix,
                        //存储的bucket
                        "",
                        //原文件名
                        bucketName,
                        //存储的文件夹
                        fileHost
                );

            }
        } catch (OSSException oe) {
            logger.error(oe.getMessage());
        } catch (ClientException ce) {
            logger.error(ce.getErrorMessage());
        } finally {
            if (client != null) {
                client.shutdown();
            }
        }
        return null;
    }
}