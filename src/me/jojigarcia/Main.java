package me.jojigarcia;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> taskList = new ArrayList<String>();
        int option;

        while ((option = showMenu(taskList)) != 0){
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
                case 4:
                    if (taskList.size() > 0) {

                    }
                    // Editar tarea
                    break;
                case 5:
                    if (taskList.size() > 1) {
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
            task = input.nextLine().trim().replaceAll("\\s+", " ");
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
        ArrayList<Integer> options = new ArrayList<Integer>();
        int option;

        System.out.println("**********************");
        System.out.println("1 - Ver tarea         ");
        options.add(1);
        System.out.println("2 - Añadir tarea      ");
        options.add(2);

        if (myTasks.size() > 0) {
            System.out.println("3 - Eliminar tarea    ");
            options.add(3);
            System.out.println("4 - Editar tarea    ");
            options.add(4);
        }

        if (myTasks.size() > 1) {
            System.out.println("5 - Mover tarea    ");
            options.add(5);
        }

        System.out.println("0 - Salir             ");
        options.add(0);
        System.out.println("**********************");

        do {
            System.out.println("Opción: ");
            option = input.nextInt();
        }while(option < 0 || option > options.size());

        return option;
    }
}
