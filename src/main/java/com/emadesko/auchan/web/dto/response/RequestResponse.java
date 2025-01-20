package com.emadesko.auchan.web.dto.response;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

public class RequestResponse {

    public static Map<String,Object> response(HttpStatus status,Object result, String type){
        Map<String,Object> map = new HashMap<>();
        map.put("status",status.value());
        map.put("results",result);
        map.put("type",type);
        return map;
    }

    public static <T> Map<String,Object> response(HttpStatus status, Page<T> result, String type){
        Map<String,Object> map = new HashMap<>();
        map.put("status",status.value());
        map.put("results",result.getContent());
        map.put("type",type);
        map.put("pages", new int[result.getTotalPages()]);
        map.put("totalElements", result.getTotalElements());
        map.put("totalPages", result.getTotalPages());
        map.put("size", result.getSize());
        map.put("currentPage", result.getNumber());
        map.put("hasNextPage", result.isFirst());
        map.put("hasPreviousPage", result.isLast());
        return map;
    }
}
