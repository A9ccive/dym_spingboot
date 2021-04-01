package com.ruoyi.project.awc.bo.photobo;

/**
 * <p>
 *   参赛作品状态
 * </p>
 *
 * @author sunhongwei
 * @since 2021-03-30
 */
public final class PhotoStatus {

  /**
   * 完成部分参赛任务
   */
  public static final int STATUS_PART_ENTRYS = 1;

  /**
   * 完成参赛任务-参赛成功
   */
  public static final int STATUS_ENTRYS = 2;

  /**
   * 赛事报名状态详情
   * DETAIL_FININSHTASK:完成赛事任务,DETAIL_PERFORM:完善个人信息,
   * DETAIL_UPLOADED:完成上传操作,DETAIL_ENTRYS:参赛成功
   */
  public  enum StatusDetail{
    DETAIL_FININSHTASK(0xb100),DETAIL_PERFORM(0xb001),
    DETAIL_UPLOADED(0xb010),DETAIL_ENTRYS(0Xb111);

    private int statuDetailVal;

    private StatusDetail(int statuDetailVal) {
      this.statuDetailVal = statuDetailVal;
    }

    public int getStatuDetailVal(){
      return  this.statuDetailVal;
    }
  };

  /**
   * 完成赛事任务
   * @param statusDetail 当前参赛状态详情
   * @return 完成赛事后任务状态详情
   */
  public static int finishedTaks(int statusDetail) {
    return  noReplyAddStatus(statusDetail, StatusDetail.DETAIL_FININSHTASK);
  }

  /**
   * 完成上传参赛作品
   * @param statusDetail 当前参赛状态详情
   * @return 完成上传后赛事任务状态详情
   */
  public static int uploaded(int statusDetail) {
    return  noReplyAddStatus(statusDetail, StatusDetail.DETAIL_UPLOADED);
  }

  /**
   * 不重复添加详情状态值
   *
   * @param statusDetail 状态原值
   * @param StatusDetail 需要添加的枚举值
   * @return 状态新值
   */
  public static int noReplyAddStatus(int statusDetail, StatusDetail StatusDetail) {
    if ((statusDetail & StatusDetail.statuDetailVal) == StatusDetail.statuDetailVal){
      return statusDetail;
    }
    return statusDetail + StatusDetail.statuDetailVal;
  }

  /**
   * 是否可以完成参赛报名
   *
   * @param statusDetail
   * @return true可以，false不可以
   */
  public static boolean isCanEntryEnd(int statusDetail) {
    if (statusDetail == StatusDetail.DETAIL_ENTRYS.statuDetailVal){
      return true;
    }
    return false;
  }
}
