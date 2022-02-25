package com.company;

import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Users users = new Users();
        list list = new list();
        int user_input=1;

        do{
            SingletonDB.getConnection();
            System.out.println("------------------------------");
            System.out.println("   Welcome to To-do_list   ");
            System.out.println("------------------------------");
            System.out.print("  1. Add list\n  2. Update list \n  3. View List \n  4. Email List\n  5. Delete list \n  0. Exit");
            user_input=scanner.nextInt();
            //one

            if(user_input==1){
                System.out.println("  1. Add User\n  2. Already a user");
                user_input=scanner.nextInt();
                if(user_input==1){
                    System.out.println("Press 0 to Exit");
                    System.out.println("Enter username: ");
                    String user_name= scanner.next();
                    System.out.println("Enter secretKey: ");
                    String secretKey= scanner.next();
                    users.addNewUser(user_name,secretKey);
                    int user_id=scanner.nextInt();
                    if(user_id==0){
                        break;
                    }
                }else if (user_input==2){
                    System.out.println("  1.Get user info\n  2.Add list\n  0.Exit\n");
                    System.out.println();
//                    show all the users
                    int input=scanner.nextInt();
                    if(input==0){
                        break;
                    }else if(input==1){
                        System.out.println("Press 0 to Exit");
                        System.out.println("Enter your userId: ");
                        int user_id=scanner.nextInt();
                        if(user_id==0){
                            break;
                        }else if(user_id==0){
                            break;
                        }else{
                            users.getUserInfo(user_id);
                            break;
                        }
                    }else if(input==2) {
                        System.out.println("Press 0 to Exit");
                        System.out.println("Enter your userId: ");
                        int id = scanner.nextInt();
                        System.out.println("No of items to add");
                        int no_of_items = scanner.nextInt();
                        for (int i = 0; i < no_of_items; i++) {
                            System.out.println("Enter Item " + (i + 1) + " : ");
                            String items = scanner.next();
                            list.addItem(id, items);
                        }
                    }

                }

            }else if(user_input==3){
//                view list
                System.out.println("Enter user id: ");
                int user_id= scanner.nextInt();
                System.out.println("Enter secretKey: ");
                String key = scanner.next();
                list.viewlist(user_id,key);
            }else if(user_input==5){
                System.out.println("Enter user id: ");
                int u_id=scanner.nextInt();
                list.deleteList(u_id);
            }
        }
        while(user_input!=0);
    }
}