package com.meawallet.parkingapp.database.converter;

import com.meawallet.parkingapp.database.ParkingLotEntity;
import com.meawallet.parkingapp.domain.ParkingLot;
import lombok.Value;
import org.springframework.stereotype.Component;

@Component
public class ParkingLotDomainToParkingLotEntity {
    public ParkingLotEntity convert(ParkingLot parkingLot, Integer id) {
        return ParkingLotEntity.builder()
                .id(id)
                .name(parkingLot.getName())
                .slotCount(parkingLot.getSlotCount())
                .emptySlots(parkingLot.getEmptySlots())
                .build();
    }
}