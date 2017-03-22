package me.jojigarcia;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> taskList = new ArrayList<String>();
        int option;

        while ((option = showMenu(taskList)) != 4){
            switch (option){
                case 1:
                    // Ver tarea
                    showTasks(taskList);
                    break;
                case 2:
                    addTask(taskList);
                    // Añadir tarea
                    break;
                case 3:
                    if (taskList.size() > 0) {
                        deleteTask(taskList);
                    }
                    // Eliminar tarea
                    break;
                default:
                    break;
            }
        }
    }

    public static void deleteTask(ArrayList<String> myTasks){
        Scanner input = new Scanner(System.in);
        int index;

        do{
            System.out.println("Introduzca el índice: ");
            index = input.nextInt();
        }while(!correctIndex(index,myTasks));

        myTasks.remove(index);
        showTasks(myTasks);
    }

    public static Boolean correctIndex(int index, ArrayList<String> myTasks){
        if (index >= 0 && index < myTasks.size()){
            return true;
        }else{
            return false;
        }
    }

    public static void addTask(ArrayList<String> myTasks){
        Scanner input = new Scanner(System.in);
        String task;

        do{
            System.out.println("Introducir nueva tarea: ");
            task = input.nextLine();
        }while(task.length()==0);

        myTasks.add(task);
    }

    public static void showTasks(ArrayList<String> myTasks){
        int index = 0;

        for (String tasks: myTasks ){
            System.out.println((index++) + " - " + tasks);
        }
    }
    public static int showMenu(ArrayList<String> myTasks){
        Scanner input = new Scanner(System.in);

        System.out.println("");
        System.out.println("**********************");
        System.out.println("1 - Ver tarea         ");
        System.out.println("2 - Añadir tarea      ");

        if (myTasks.size() > 0) {
            System.out.println("3 - Eliminar tarea    ");
        }

        System.out.println("4 - Salir             ");
        System.out.println("**********************");
        System.out.println("");
        System.out.println("Opción: ");

        return input.nextInt();
    }
}
