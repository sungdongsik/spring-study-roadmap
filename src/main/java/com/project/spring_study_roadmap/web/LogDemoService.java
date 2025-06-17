package com.project.spring_study_roadmap.web;

import com.project.spring_study_roadmap.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    //private final ObjectProvider<MyLogger> myLoggerObjectProvider;
    private final MyLogger myLogger;

    public void logic(String testId) {
        //MyLogger myLogger = myLoggerObjectProvider.getObject();
        myLogger.log("service id = " + testId);
    }
}
