package com.nukhbahire.platform.service;

import com.nukhbahire.platform.dao.ProfileDAO;
import com.nukhbahire.platform.dto.ProfileCreateRequestVO;
import com.nukhbahire.platform.exception.BusinessException;
import com.nukhbahire.platform.model.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileDAO profileDAO;

    public Profile createNewProfile(ProfileCreateRequestVO requestVO, String loggedInUserId) {
        String name = Objects.requireNonNull(requestVO.getName(), "Name is required.");
        String title = Objects.requireNonNull(requestVO.getTitle(), "Profile title is required.");
        String slug = Objects.requireNonNull(requestVO.getSlug(), "Profile slug is required.");

        boolean slugAlreadyExists = profileDAO.existsBySlug(slug);

        if (slugAlreadyExists) {
            throw new BusinessException("A profile with the slug '" + slug + "' already exists. Please choose a different slug.");
        }

        Profile profile = new Profile();
        profile.setUserId(loggedInUserId);
        profile.setName(name);
        profile.setTitle(title);
        profile.setSlug(slug);
        profile.setCreatedOn(LocalDate.now());
        return profileDAO.createProfile(profile);
    }

    public Profile updateProfile(String profileId, Profile profile) {
        Profile existingProfile = profileDAO.getProfileById(profileId)
                .orElseThrow(() -> new BusinessException("Profile not found with ID: " + profileId + "."));

        if (profile.getSlug() != null && !profile.getSlug().equals(existingProfile.getSlug())) {
            boolean slugAlreadyExists = profileDAO.existsBySlug(profile.getSlug());

            if (slugAlreadyExists) {
                throw new BusinessException("A profile with the slug '" + profile.getSlug() + "' already exists. Please choose a different slug.");
            }
            existingProfile.setSlug(profile.getSlug());
        }

        if (profile.getName() != null)
            existingProfile.setName(profile.getName());
        if (profile.getTitle() != null)
            existingProfile.setTitle(profile.getTitle());
        if (profile.getAbout() != null)
            existingProfile.setAbout(profile.getAbout());
        if (profile.getLocation() != null)
            existingProfile.setLocation(profile.getLocation());
        if (profile.getSkills() != null)
            existingProfile.setSkills(profile.getSkills());

        existingProfile.setUpdatedOn(LocalDate.now());

        return profileDAO.saveProfile(existingProfile);
    }
}
