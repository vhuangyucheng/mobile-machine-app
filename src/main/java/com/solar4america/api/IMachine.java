package com.solar4america.api;

import com.solar4america.VO.MachineVO;
import com.solar4america.entity.MachineDO;
import com.solar4america.entity.TicketDO;

import java.util.List;

public interface IMachine {
    public List<MachineVO> listMachine(Integer status);
    public List<TicketDO> listTicket(Integer status, Integer machineId);
}
