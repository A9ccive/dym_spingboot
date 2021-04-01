package com.ruoyi.common.utils;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Component
public class UploadPicUtil {

    private final static Logger logger = LoggerFactory.getLogger(UploadPicUtil.class);

    /**
     * 文件上传
     *
     * @param file
     * @param picLocation
     * @return
     */
    public static String uploadFiles(MultipartFile file, String picLocation) {
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        String req = file.getOriginalFilename();

        File tempFile = new File(picLocation, idWorker.nextId() + req.substring(req.indexOf(".")));
        if (!tempFile.exists()) {
            tempFile.getParentFile().mkdirs();
            try {
                tempFile.createNewFile();
                file.transferTo(tempFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String picName = tempFile.getName();
        if (StringUtils.isNotBlank(picName)) {
            logger.info("文件上传成功 :{}", picName);
            return picName;
        } else {
            logger.info("文件上传失败!");
            return "";
        }

    }
}