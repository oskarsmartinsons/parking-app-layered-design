package com.meawallet.parkingapp.ui;

import com.meawallet.parkingapp.domain.ParkingLot;
import com.meawallet.parkingapp.dto.CreateParkingLotRequest;
import com.meawallet.parkingapp.dto.UpdateParkingLotRequest;
import com.meawallet.parkingapp.ui.exceptions.ParkingLotRequestException;
import org.springframework.stereotype.Component;
import java.util.InputMismatchException;
import java.util.Scanner;

@Component
public class UserInput {
    public Integer requestMenuNumber() {
        System.out.println("Input menu number: ");
        try {
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Please enter correct menu number");
        }
    }

    public CreateParkingLotRequest getCreateParkingLotRequest() {
        try {
            System.out.println("Specify Lot Name: ");
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();
            System.out.println("Specify Slot Count in Lot: ");
            Integer count = Integer.valueOf(input.nextLine());

            var request = new CreateParkingLotRequest(name, count, count);
            validateCreateParkingLotRequest(request);

            return request;
        } catch (NumberFormatException e){
            throw new NumberFormatException("Please enter integer number for Slot Count");
        }
    }

    public UpdateParkingLotRequest getUpdateParkingLotRequest(ParkingLot parkingLot) {
            System.out.println("Updated Parking Lot name: ");
            Scanner input = new Scanner(System.in);
            String name = input.nextLine();

            var request = new UpdateParkingLotRequest(
                    parkingLot.getId(), name, parkingLot.getSlotCount(), parkingLot.getEmptySlots()
            );

            validateUpdateParkingLotRequest(request);
            return request;
    }

    public Integer requestIdNumber() {
        System.out.println("Enter Parking lot Id number: ");
        try {
            Scanner input = new Scanner(System.in);
            return input.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Incorrect id - it can contain only numbers");
        }
    }

    private void validateCreateParkingLotRequest(CreateParkingLotRequest request) {
        if (request.getName().length()==0) {
            throw new ParkingLotRequestException("Parking Lot name can't be empty");
        }
        if(request.getSlotCount() <=0 ) {
            throw new ParkingLotRequestException("Parking Lot must have at least 1 slot.");
        }
    }
    private void validateUpdateParkingLotRequest(UpdateParkingLotRequest request) {
        if (request.getName().length()==0) {
            throw new ParkingLotRequestException("Parking Lot name can't be empty");
        }
    }
}
