package com.nukhbahire.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileCreateRequestVO {
    private String name;
    private String title;
    private String slug;
}
