package com.example.onesignal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/pushnotification")
public class controller {

    @Autowired
    private OneSignalUserRepository OneSignalUserRepository;

    @PostMapping("/sendMessageToAllUsers/{message}")
    public void sendMessageToAllUsers(@PathVariable("message") String message) {
        OneSignalUserService.sendMessageToAllUsers(message);
    }

    @PostMapping("/sendMessageToUser/{userId}/{message}")
    public void sendMessageToUser(@PathVariable("userId") String userId, @PathVariable("message") String message) {
        OneSignalUserService.sendMessageToUser(message, userId);
    }

    @PostMapping("/saveUserId/{userId}")
    public void saveUserId(@PathVariable("userId") String userId) {
        OneSignalUserModel notification = new OneSignalUserModel();
        notification.setIdOneSignal(userId);
        notification.setUserName("User: " + userId);
        OneSignalUserRepository.save(notification);
    }

    @GetMapping("/getUsers")
    public List<Object> getUsers() {
        List<Object> listValues = new ArrayList<>();

        for (OneSignalUserModel notification : OneSignalUserRepository.findAll()){
            Map<String, Object> mapValues = new HashMap<>();
            mapValues.put("userName", notification.getUserName());
            mapValues.put("idOneSignal", notification.getIdOneSignal());
            listValues.add(mapValues);
        }

        return listValues;
    }
}
