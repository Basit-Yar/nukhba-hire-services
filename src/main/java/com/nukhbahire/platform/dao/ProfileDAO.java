package com.nukhbahire.platform.dao;

import com.nukhbahire.platform.model.Profile;
import com.nukhbahire.platform.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfileDAO {

    private final ProfileRepository profileRepository;

    public Profile createProfile(Profile profile) {
        return profileRepository.save(profile);
    }

    public boolean existsBySlug(String slug) {
        return profileRepository.existsBySlug(slug);
    }
}
