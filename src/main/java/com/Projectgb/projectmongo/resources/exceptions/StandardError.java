package com.Projectgb.projectmongo.resources.exceptions;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StandardError implements Serializable {
    
    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;



}
