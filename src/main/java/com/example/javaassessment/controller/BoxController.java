package com.example.javaassessment.controller;

import com.example.javaassessment.dto.ItemRequest;
import com.example.javaassessment.model.Box;
import com.example.javaassessment.model.BoxItem;
import com.example.javaassessment.service.BoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boxes")
public class BoxController {
        @Autowired
        private BoxService boxService;

        @PostMapping("/create")
        public ResponseEntity<Box> createBox(@RequestBody Box box) {
            return ResponseEntity.ok(boxService.createBox(box));
        }

        @PostMapping("/{id}/items")
        public ResponseEntity<Box> loadItems(
                @PathVariable Long id,
                @RequestBody List<ItemRequest> items) {
            return ResponseEntity.ok(boxService.loadItems(id, items));
        }

        @GetMapping("/{id}/items")
        public ResponseEntity<List<BoxItem>> getLoadedItems(@PathVariable Long id) {
            return ResponseEntity.ok(boxService.getLoadedItems(id));
        }

        @GetMapping("/available")
        public ResponseEntity<List<Box>> getAvailableBoxes() {
            return ResponseEntity.ok(boxService.getAvailableBoxes());
        }

        @GetMapping("/{id}/battery")
        public ResponseEntity<Integer> getBatteryLevel(@PathVariable Long id) {
            return ResponseEntity.ok(boxService.getBatteryLevel(id));
        }
    }


