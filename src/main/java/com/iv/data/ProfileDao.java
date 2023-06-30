package com.iv.data;

import com.iv.models.Profile;

public interface ProfileDao {
    Profile create(Profile profile);
    Profile getByUserId(int userId);
    Profile update(Profile profile);
}