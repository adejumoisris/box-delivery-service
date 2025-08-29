package com.example.javaassessment.service;

import com.example.javaassessment.dto.ItemRequest;
import com.example.javaassessment.model.Box;
import com.example.javaassessment.model.BoxItem;
import com.example.javaassessment.repository.BoxRepository;
import com.example.javaassessment.enums.BoxState;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BoxService {
        private  final BoxRepository boxRepo;
//         private  final ItemRepository itemRepo;

    public BoxService(BoxRepository boxRepo) {
        this.boxRepo = boxRepo;
//        this.itemRepo = itemRepo;
    }


    public Box createBox(Box box) {
        for (BoxItem item : box.getItems()) {
            item.setBox(box);
        }
        return boxRepo.save(box);
    }


    public Box loadItems(Long boxId, List<ItemRequest> items) {
            Box box = boxRepo.findById(boxId)
                    .orElseThrow(() -> new RuntimeException("Box not found"));

            if (box.getBatteryCapacity() < 25)
                throw new RuntimeException("Battery too low to load items");

            double totalWeight = box.getCurrentWeight() +
                    items.stream().mapToDouble(ItemRequest::getWeight).sum();

            if (totalWeight > box.getWeightLimit())
                throw new RuntimeException("Weight limit exceeded");

            box.setState(BoxState.LOADING);
            for (ItemRequest req : items) {
                BoxItem boxItem = new BoxItem();
                boxItem.setName(req.getName());
                boxItem.setWeight(req.getWeight());
                boxItem.setCode(req.getCode());
                boxItem.setBox(box);
                box.getItems().add(boxItem);
            }
            box.setCurrentWeight(totalWeight);
            box.setState(BoxState.LOADED);

            return boxRepo.save(box);
        }

        public List<BoxItem>getLoadedItems(Long boxId) {
            return boxRepo.findById(boxId)
                    .map(Box::getItems)
                    .orElseThrow(() -> new RuntimeException("Box not found"));
        }

        public List<Box> getAvailableBoxes() {
            return boxRepo.findByState(BoxState.IDLE);
        }

        public int getBatteryLevel(Long boxId) {
            return boxRepo.findById(boxId)
                    .map(Box::getBatteryCapacity)
                    .orElseThrow(() -> new RuntimeException("Box not found"));
        }
    }


