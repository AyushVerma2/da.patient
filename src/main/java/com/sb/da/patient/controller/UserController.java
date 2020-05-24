//package com.sb.da.patient.controller;
//
//import com.sb.da.patient.entity.User;
//import com.sb.da.patient.service.FirebaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.concurrent.ExecutionException;
//
//@Controller
//public class UserController {
//
//    @Autowired
//    FirebaseService firebaseService;
//
//    @GetMapping("/getUserDetail")
//    public ResponseEntity<User> getUserDetails(@RequestHeader String name) throws ExecutionException, InterruptedException {
//        return ResponseEntity.ok(firebaseService.getUserDetails(name));
//    }
//
//    @PostMapping("/createUser")
//    public ResponseEntity<String> createUser(@RequestBody User user) throws ExecutionException, InterruptedException {
//        return ResponseEntity.ok(
//                firebaseService.saveuserDetail(user));
//    }
//
//    @PutMapping("/updateUser")
//    public ResponseEntity<String> updateUser(@RequestBody User user) throws ExecutionException, InterruptedException {
//        return ResponseEntity.ok(
//                firebaseService.saveuserDetail(user));
//    }
//
//    @DeleteMapping("/deleteUser")
//    public ResponseEntity<String> deleteUser(@RequestHeader String name) {
//        return ResponseEntity.ok(firebaseService.deleteUser(name));
//    }
//}
