package com.ruoyi.common.utils;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;

public class ApiUtil {

    public static void main(String[] args) {

        DocsConfig config = new DocsConfig();
        // 项目根目录
        config.setProjectPath("H:\\dm_code\\AWC\\awc_last_contro\\awc_server");
        // 项目名称
        config.setProjectName("awc_server");
        // 声明该API的版本
        config.setApiVersion("V1.0");
        // 生成API 文档所在目录
        config.setDocsPath("H:\\doc");
        // 配置自动生成
        config.setAutoGenerate(Boolean.FALSE);
        // 执行生成文档
        Docs.buildHtmlDocs(config);


    }
}
