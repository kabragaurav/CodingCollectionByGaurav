/*
    Vague Question:
    Design a "Puppy Hotel".
    The hotel has a clearly defined amount of hotel rooms for small dogs,
    rooms for medium-sized dogs, and the same for large dogs.
 */
package LowLevelSystemDesign.ObjectOrientedDesign;

import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author gaurav kabra
 * @since 10/Jun/2022
 **/

public class PuppyHotel {
    private String hotelId;
    private Floor[] floors;
    HashMap<RoomType, Double> roomTypeToFeeMap;
    HashMap<RoomSize, Double> roomSizeToFeeMap;
    // other details : Name, location (lat and long of long types), cityId/code

    public boolean checkAvailability(Dog dog) {
        DogSize dogSize = dog.getDogSize();
        // logic for check any room fits this dog
        // if not, try suggesting bigger rooms

        return false;
    }

    public void checkIn() {
        // generate booking, pay and print receipt
    }

    public void checkOut() {

    }

    public double calculateFee(Booking booking) {
        return booking.calculateFee(roomTypeToFeeMap, roomSizeToFeeMap);
    }
}

class Booking {
    private RoomSize roomSize;
    private RoomType roomType;
    private double fee;
    private String hotelId;
    private String floorId;
    private String roomId;
    private Date checkInDate;       // should be auto populated by hotel's location time using internet (not system's time)
    private Date checkOutDate;      // Same as above

    // Not providing extendCheckOutDate method
    // since we can immediately create new booking once current booking expires

    public double calculateFee(HashMap<RoomType, Double> roomTypeToFeeMap, HashMap<RoomSize, Double> roomSizeToFeeMap) {
        return roomSizeToFeeMap.get(roomSize)
                + roomTypeToFeeMap.get(roomType);
    }
}

class Floor {
    private String hotelId;
    private String floorNumber;
    private Room[] rooms;
}

class Room {
    private String floorId;
    private RoomType roomType;
    private RoomSize roomSize;
}


class Dog {
    private String dogId;
    private String ownerId;
    private DogSize dogSize;

    public Dog(String ownerId, DogSize dogSize) {
        this.ownerId = ownerId;
        this.dogSize = dogSize;
        this.dogId = UUID.randomUUID().toString();
    }

    public DogSize getDogSize() {
        return dogSize;
    }
}

enum DogSize {
    SMALL,
    MEDIUM,
    LARGE
    ;
}

enum RoomSize {
    SMALL,
    MEDIUM,
    LARGE
    ;
}

enum RoomType {
    ECONOMY,
    PREMIUM
    ;
}

class Owner {
    private String ownerId;
    // some other details like Address (another class), name (String), memberSince (Date), lastLogin (Date) etc

    public void makePayment(RoomType roomType, RoomSize roomSize, PuppyHotel hotel) {

    }

}