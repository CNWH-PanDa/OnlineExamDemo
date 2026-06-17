package com.panda.maven.onlineexamdemo.controller.request;


import lombok.Data;

@Data
public class ExaminationPageRequest extends BaseRequest{
    private String subject;
}
