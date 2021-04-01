package com.ruoyi.project.awc.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.project.awc.entity.AwcChit;

import java.util.List;

/**
 * <p>
 * 用户电子券金额 服务类
 * </p>
 *
 * @author
 * @since 2021-04-01
 */
public interface AwcChitService extends IService<AwcChit> {



    void add(AwcChit awcChit);

    void update(AwcChit awcChit);

    void delete(AwcChit awcChit);

    AwcChit findByUserId(Integer id);

}
