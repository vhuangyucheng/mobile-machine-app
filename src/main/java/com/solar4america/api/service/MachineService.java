package com.solar4america.api.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.google.common.collect.Lists;
import com.solar4america.VO.MachineVO;
import com.solar4america.api.IMachine;
import com.solar4america.entity.MachineDO;
import com.solar4america.entity.TicketDO;
import com.solar4america.mapper.MachineMapper;
import com.solar4america.mapper.TicketMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MachineService implements IMachine {
    @Autowired
    private MachineMapper machineMapper;
    @Autowired
    private TicketMapper ticketMapper;

//     0全部，1坏的
    @Override
    public List<MachineVO> listMachine(Integer status) {
        List<MachineDO> machineDOList = machineMapper.selectList(null);
        QueryWrapper<TicketDO> wrapper = new QueryWrapper<>();
        wrapper.groupBy("machine_id");
        List<TicketDO> ticketDOList = ticketMapper.selectList(wrapper);
        Map<Integer, TicketDO> ticketDOMap = ticketDOList.stream().collect(Collectors.toMap(TicketDO::getMachineId, TicketDO -> TicketDO));
        List<MachineVO> machineVOList = Lists.newArrayList();
        machineDOList.forEach(machineDO -> {
            MachineVO machineVO = new MachineVO();
            machineVO.setMachineId(machineDO.getMachineId());
            machineVO.setMachineName(machineDO.getMachineName());
            machineVO.setMachineStatus(ticketDOMap.get(machineDO.getMachineId())== null?0:1);
            machineVOList.add(machineVO);
        });
        return status == 0? machineVOList: machineVOList.stream().filter(machineVO -> machineVO.getMachineStatus()==1).collect(Collectors.toList());
    }

    @Override
    public List<TicketDO> listTicket(Integer status, Integer machineId) {
        QueryWrapper<TicketDO> wrapper = new QueryWrapper<>();
        wrapper.eq("machine_id", machineId);
        wrapper.orderByDesc("ticket_issue_time");
        List<TicketDO> ticketDOList = ticketMapper.selectList(wrapper);
        if(status == 1){
            return ticketDOList.stream().filter(ticketDO -> ticketDO.getTicketStatus()==0).collect(Collectors.toList());
        }
        if(status == 2){
            return ticketDOList.stream().filter(ticketDO -> ticketDO.getTicketStatus()==1).collect(Collectors.toList());
        }
        return ticketDOList;
    }

}
