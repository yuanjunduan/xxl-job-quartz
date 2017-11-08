package com.xxl.job.executor.mvc.controller;

import static java.nio.charset.StandardCharsets.UTF_8;

import com.xxl.job.core.rpc.codec.RpcRequest;
import com.xxl.job.core.rpc.codec.RpcResponse;
import com.xxl.job.core.rpc.serialize.HessianSerializer;
import com.xxl.job.core.util.HttpClientUtil;
import com.xxl.job.executor.service.jobhandler.DemoJobHandler;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Enumeration;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

@Controller
@EnableAutoConfiguration
public class IndexController {

  @Autowired
  private DemoJobHandler demoJobHandler;

  @RequestMapping("/")
  @ResponseBody
  String index(HttpServletRequest request) throws Exception {

    //
    ServletInputStream servletInputStream = request.getInputStream();
    String requestStr = IOUtils.toString(request.getInputStream(), UTF_8);

    //
    Map<String, String[]> parameterMap = request.getParameterMap();
    Enumeration<String> parameterNames = request.getParameterNames();

    //
    byte[] requestBytes = HttpClientUtil.readBytes(request);
    RpcResponse rpcResponse = new RpcResponse();
    rpcResponse.setError("RpcRequest byte[] is null");
    //RpcRequest rpcRequest = (RpcRequest) HessianSerializer.deserialize(requestBytes, RpcRequest.class);


    demoJobHandler.execute("1");
    return "xxl job executor running.";
  }

}