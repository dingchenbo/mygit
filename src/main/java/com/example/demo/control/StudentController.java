package com.example.demo.control;

import com.example.demo.common.util.BaseController;
import com.example.demo.common.webres.WebResCallback;
import com.example.demo.common.webres.common.WebResCriteria;
import com.example.demo.common.webres.common.WebResInfo;
import com.example.demo.entity.Students;
import com.example.demo.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/")
public class StudentController extends BaseController {

    @Autowired
    private StudentsService studentsService;


    @RequestMapping("goPage")
    private String goPage(){
        return "test/test1/banner_list";
    }

    @RequestMapping("getList")
    @ResponseBody
    private WebResInfo getList(final String name,final HttpServletRequest request){
        return new WebResCallback(){
            @Override
            public void execute(WebResCriteria criteria, Object... params) {
                String name1 = name;
                criteria.addSingleResult(studentsService.studentList());
            }
        }.sendRequest();
    }
}
