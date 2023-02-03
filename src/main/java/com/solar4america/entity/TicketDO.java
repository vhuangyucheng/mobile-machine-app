package com.solar4america.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("ticket")
public class TicketDO {
    @TableId("ticket_id")
    private Integer ticketId;
    @TableField("machine_id")
    private Integer machineId;
    private String ticketType;
    private String ticketDescription;
    private Date ticketIssueTime;
    @TableField("ticket_img")
    private String ticketImg;
    @TableField("ticket_img2")
    private String ticketImg2;
    private String ticketSolution;
    private Date ticketCloseTime;
//0未关闭，1关闭
    private Integer ticketStatus;
}
