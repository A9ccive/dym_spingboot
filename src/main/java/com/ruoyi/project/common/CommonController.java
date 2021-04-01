package com.ruoyi.project.common;

import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.utils.AliyunOSSUtil;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.UploadPicUtil;
import com.ruoyi.common.utils.check.CheckFiledUtils;
import com.ruoyi.common.utils.file.FileUploadUtils;
import com.ruoyi.common.utils.file.FileUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.config.ServerConfig;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.project.awc.dto.aliyunoss.FileDTO;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;

/**
 * 通用请求处理
 *
 * @author ruoyi
 */
@RestController
public class CommonController {
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private AliyunOSSUtil aliyunOSSUtil;

    @Value("${picture.location}")
    private String picLocation;

    @Value("${picture.internet.address}")
    private String internetAddress;

    /**
     * 通用下载请求
     *
     * @param fileName 文件名称
     * @param delete   是否删除
     */
    @GetMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request) {
        try {
            if (!FileUtils.checkAllowDownload(fileName)) {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = RuoYiConfig.getDownloadPath() + fileName;

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete) {
                FileUtils.deleteFile(filePath);
            }
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 通用上传请求
     */
    @PostMapping("/common/upload")
    public AjaxResult uploadFile(MultipartFile file) throws Exception {
        try {
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            if (!FileUtils.checkAllowDownload(resource)) {
                throw new Exception(StringUtils.format("资源文件({})非法，不允许下载。 ", resource));
            }
            // 本地资源路径
            String localPath = RuoYiConfig.getProfile();
            // 数据库资源地址
            String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
            // 下载名称
            String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, downloadName);
            FileUtils.writeBytes(downloadPath, response.getOutputStream());
        } catch (Exception e) {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 图片上传-外网服务器
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/uploadPicture", method = RequestMethod.POST)
    @ApiOperation(value = "图片上传-外网服务器", notes = "图片上传-外网服务器", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "ERROR!!!"),
            @ApiResponse(code = 200, message = "OK")})
    public AjaxResult uploadPicture(HttpServletRequest request) {

        try {
            String picLocation = this.picLocation;
            String internetAddress = this.internetAddress;
            MultipartHttpServletRequest multipartRequest = null;
            try {
                //getFile
                multipartRequest = (MultipartHttpServletRequest) request;
            } catch (ClassCastException castException) {
                castException.printStackTrace();
                return AjaxResult.error("文件接收失败,请上传文件!");
            }
            MultipartFile file = multipartRequest.getFile("file");
            if (file == null) {
                return new AjaxResult(500, "请上传文件,注意文件的name属性为file");
            }
            String picName = UploadPicUtil.uploadFiles(file, picLocation);
            if (!StringUtils.isEmpty(picName)) {
                return AjaxResult.success(internetAddress + picName);
            } else {
                return new AjaxResult(500, "上传失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }


    /**
     * 文件上传
     * {
     * "fileSize": 190280,
     * "fileAPUrl": "test/2019-08-06/5ea96123bc3f4fa0a30560ae6aa2f285-WX20190806-151311@2x.png",
     * "webUrl": "https://tzqimg.oss-cn-hangzhou.aliyuncs.com/test/2019-08-06/5ea96123bc3f4fa0a30560ae6aa2f285-WX20190806-151311@2x.png",
     * "fileSuffix": "png",
     * "fileBucket": "",
     * "oldFileName": "tzqimg",
     * "folder": "test"
     * }
     */
    @RequestMapping(value = "/uploadFile")
    public FileDTO uploadBlog(@RequestParam("file") MultipartFile file) {
        log.info("文件上传");
        String filename = file.getOriginalFilename();
        System.out.println(filename);

        try {
            // 判断文件
            if (file != null) {
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream os = new FileOutputStream(newFile);
                    os.write(file.getBytes());
                    os.close();
                    file.transferTo(newFile);
                    // 上传到OSS
                    return aliyunOSSUtil.upLoad(newFile);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * 文件上传-选择上传途径 upType 1: OSS 2: web
     *
     * @param
     * @return
     */
    @ApiOperation("文件上传")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "upType", value = "1: OSS 2: web", dataType = "Integer"),
    })
    @RequestMapping(value = "/uploadFileByType", method = RequestMethod.GET)
    public AjaxResult uploadFileByType(@RequestBody Integer upType) {
        try {
            //参数校验
            CheckFiledUtils.isFieldNull(upType);
            if (upType == 1) {

            }


            return AjaxResult.success();

        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error(e.getMessage());
        }
    }


}
