package com.nukhbahire.platform.dao;

import com.nukhbahire.platform.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfileDAO {

    private final ProfileRepository profileRepository;

}
