package com.esiea.twitterclone.model;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Getter
@Data
public class MessageDTO {
    private UserDTO user;
    private String body;
    private Date date;
}
