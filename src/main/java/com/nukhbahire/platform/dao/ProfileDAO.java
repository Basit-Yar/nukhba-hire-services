package com.nukhbahire.platform.dao;

import com.nukhbahire.platform.model.Profile;
import com.nukhbahire.platform.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    public Optional<Profile> getProfileById(String profileId) {
        return profileRepository.findById(profileId);
    }

    public Profile saveProfile(Profile existingProfile) {
        return profileRepository.save(existingProfile);
    }
}
