package com.nukhbahire.platform.dao;

import com.nukhbahire.platform.controller.ProfileRestController;
import com.nukhbahire.platform.repository.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProfileDAO {

    private final ProfileRepository profileRepository;

}
