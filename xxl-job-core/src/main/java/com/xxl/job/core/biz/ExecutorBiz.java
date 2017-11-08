package com.xxl.job.core.biz;

import com.xxl.job.core.biz.model.LogResult;
import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.biz.model.TriggerParam;

/**
 * Created by xuxueli on 17/3/1.
 */
public interface ExecutorBiz {

  /**
   * beat
   */
  public ReturnT<String> beat();

  /**
   * idle beat
   */
  public ReturnT<String> idleBeat(int jobId);

  /**
   * kill
   */
  public ReturnT<String> kill(int jobId);

  /**
   * log
   */
  public ReturnT<LogResult> log(long logDateTim, int logId, int fromLineNum);

  /**
   * run
   */
  public ReturnT<String> run(TriggerParam triggerParam);

}
