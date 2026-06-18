package com.panda.maven.onlineexamdemo.controller.request;

import lombok.Data;

@Data
public class ConditionPageRequest extends BaseRequest{
    private String name;
    private String username;
}
