package com.solar4america.VO;

import lombok.Data;

import java.util.List;

@Data
public class ListWrapper<T> {
    private String pageName;
    private List<T> list;
}
