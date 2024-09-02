package org.example;

import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TruckService truckService = new TruckService();
        int res;
        while(true) {
            System.out.println("Truck Management System");
            System.out.println("1. Add new truck");
            System.out.println("2. Update a truck");
            System.out.println("3. Delete a truck");
            System.out.println("4. Get all trucks");
            System.out.println("5. Get a truck by Id");
            System.out.println("0. Exit");
            System.out.println("Enter you choice :: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {
                    sc.nextLine();
                    System.out.println("Enter truck name :: ");
                    String name = sc.nextLine();
                    System.out.println("Enter truck model :: ");
                    String model = sc.nextLine();
                    System.out.println("Enter truck capacity :: ");
                    int capacity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter truck driver name :: ");
                    String driverName = sc.nextLine();
                    Truck t = new Truck(name, model, capacity, driverName);
                    res = truckService.addTruck(t);
                    if (res == 1) {
                        System.out.println("Truck details added successfully....");
                    } else {
                        System.out.println("Unable to add new truck details...");
                    }
                    break;
                }
                case 2: {
                    System.out.println("Enter truck id :: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter truck name :: ");
                    String name = sc.nextLine();
                    System.out.println("Enter truck model :: ");
                    String model = sc.nextLine();
                    System.out.println("Enter truck capacity :: ");
                    int capacity = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter truck driver name :: ");
                    String driverName = sc.nextLine();
                    Truck t = new Truck(name, model, capacity, driverName);
                    res = truckService.updateTruck(t, id);
                    if (res == 1) {
                        System.out.println("Truck details added successfully....");
                    } else {
                        System.out.println("There is no truck record with id :: " + id + " to update..");
                    }
                    break;
                }
                case 3: {
                    System.out.println("Enter truck id to delete :: ");
                    int id = sc.nextInt();
                    res = truckService.deleteTruck(id);
                    if(res != 0){
                        System.out.println("Truck deleted successfully....");
                    } else {
                        System.out.println("No truck found with given id to delete...");
                    }
                    break;
                }
                case 4: {
                    List<Truck> list = truckService.getAllTrucks();
                    if(list.isEmpty()){
                        System.out.println("Truck table is empty...");
                    } else {
                        for (Truck t : list) {
                            System.out.println(t.toString());
                        }
                    }
                    break;
                }
                case 5: {
                    System.out.println("Enter truck id to fetch :: ");
                    int id = sc.nextInt();
                    Truck t = truckService.getTruckById(id);
                    System.out.println(t.toString());
                    break;
                }
                case 0:
                    System.out.println("Exiting program...");
                    sc.close();
                    exit(0);
                    break;
                default:
                    System.out.println("Invalid option...\nPlease enter a valid choice from menu...");
                    break;
            }
        }
    }
}