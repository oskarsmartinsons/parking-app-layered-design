package com.meawallet.parkingapp.ui.actions;

import com.meawallet.parkingapp.core.ParkingLotService;
import com.meawallet.parkingapp.ui.MenuActions;
import com.meawallet.parkingapp.ui.MenuName;
import com.meawallet.parkingapp.ui.UserInput;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DeleteParkingLotAction implements MenuActions {
    private final UserInput userInput;
    private final ParkingLotService parkingLotService;

    @Override
    public boolean hasSubMenu() {
        return false;
    }

    @Override
    public MenuName getSubMenuName() {
        return null;
    }

    @Override
    public MenuName getMenuAppearanceName() {
        return MenuName.MAIN;
    }

    @Override
    public String getActionName() {
        return "Delete Parking Lot";
    }

    @Override
    public void execute() {
        var id = userInput.requestIdNumber();
        var parkingLot = parkingLotService.findParkingLotById(id);
        parkingLotService.deleteParkingLot(parkingLot);
        System.out.println("DELETED Parking Lot with Id: " + id);
    }
}
