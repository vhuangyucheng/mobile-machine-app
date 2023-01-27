package com.solar4america.mobilemachineapp;

import com.solar4america.entity.MachineDO;
import com.solar4america.mapper.MachineMapper;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SimpleTest {

    @Autowired
    private MachineMapper machineMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<MachineDO> userList = machineMapper.selectList(null);
        userList.forEach(System.out::println);
    }

}