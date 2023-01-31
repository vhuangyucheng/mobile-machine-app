package com.solar4america.VO;

import lombok.Data;

import java.util.List;

/**
 * @author : kooing
 * @Data :  1/30/2023
 * @description:
 **/
@Data
public class TicketListWrapper<T> {
    private String pageName;
    private List<T> list;
}
