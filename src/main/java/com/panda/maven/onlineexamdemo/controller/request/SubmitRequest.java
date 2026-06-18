package com.panda.maven.onlineexamdemo.controller.request;

import com.panda.maven.onlineexamdemo.entity.Exam;
import lombok.Data;

import java.util.Map;

@Data
public class SubmitRequest {
    private Map<Integer,String> answers;
    private Exam exam;
}
