package com.panda.maven.onlineexamdemo.mapper;


import com.panda.maven.onlineexamdemo.dto.CourseDto;
import com.panda.maven.onlineexamdemo.entity.Course;
import com.panda.maven.onlineexamdemo.entity.Exam;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
import java.util.Map;

@Mapper
public interface ExaminationMapper {

    List<CourseDto> getCourseDetailsWithStatusAndScore(String username);

    List<Course> listByCondition(String subject, String username);

    List<Exam> getBySub(String username, String subject);

    void submitAnswer(String username, Map<Integer,String> answer);

    Integer totalScore(String username,String subject);

    void insert(String username, String subject,Integer score);

    Integer getByUN(String username);

    Integer getBySJ(String subject);

    void setStatus(Integer uid, Integer cid);

    Integer getByUsernameAndSubject(String username, String courseName);

}
