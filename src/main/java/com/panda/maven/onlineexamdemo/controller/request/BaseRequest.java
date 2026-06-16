package com.panda.maven.onlineexamdemo.controller.request;

import lombok.Data;

@Data
public class BaseRequest {
    private Integer pageNum;
    private Integer pageSize;
}
