package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Students;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface StudentsDao extends BaseMapper<Students> {

    List<Students> studentsList();
}
