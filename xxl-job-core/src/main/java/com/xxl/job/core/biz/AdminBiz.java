package com.xxl.job.core.biz;

import com.xxl.job.core.biz.model.HandleCallbackParam;
import com.xxl.job.core.biz.model.RegistryParam;
import com.xxl.job.core.biz.model.ReturnT;

import java.util.List;

/**
 * @author xuxueli 2017-07-27 21:52:49
 */
public interface AdminBiz {

  public static final String MAPPING = "/api";

  /**
   * callback
   */
  public ReturnT<String> callback(List<HandleCallbackParam> callbackParamList);

  /**
   * registry
   */
  public ReturnT<String> registry(RegistryParam registryParam);

  /**
   * registry remove
   */
  public ReturnT<String> registryRemove(RegistryParam registryParam);


  /**
   * trigger job for once
   */
  public ReturnT<String> triggerJob(int jobId);

}
