package com.example.demo.service.impl;

import com.example.demo.dao.StudentsDao;
import com.example.demo.entity.Students;
import com.example.demo.service.StudentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentsServiceImpl implements StudentsService {

    @Resource
    private StudentsDao studentsDao;

    @Override
    public List<Students> studentList() {
        return studentsDao.studentsList();
    }
}
