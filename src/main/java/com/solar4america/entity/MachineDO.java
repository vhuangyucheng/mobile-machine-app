package com.solar4america.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("machine")
public class MachineDO {
    @TableId("machine_id")
    private Integer machineId;

    @TableField("machine_name")
    private String machineName;
}
