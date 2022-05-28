package com.example.onesignal;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OneSignalUserRepository extends JpaRepository<OneSignalUserModel, Long> {
}
