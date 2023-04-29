package crud.demo;

import java.util.Scanner;

public class Main {
    private static Person[] persons;
    public static int say = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Arrayin uzunluqunu teyin ele: ");
        int n = scan.nextInt();
        persons = new Person[n];
        createPerson(1, "Minaver", "Emiraslanova ", 26);
        createPerson(2, "Sakina ", "Hamidova", 28);
        readPersons();

        System.out.println("Find person by id: ");
        // id - ni scannerden oxu
        long id = scan.nextLong();
        // id-esasinda personu axtar
        Person person = getPersonById(id);
        // tapilmis personu cap ele


        if (person != null) {
            printPerson(person);
        } else {
            System.out.println("Tapilmadi");
        }
        System.out.println("----------------------");
        // id-ni scannerden oxu

        // yeni personun melumatlarini scannerden oxuyuruq

        Person newPerson = new Person(scan.nextLong(),// id
                scan.next(),//ad
                scan.next(),//soyad
                scan.nextInt());//yas
        //uptade metodunu cagiririq
        Person updatedPerson = updatePersonById(newPerson.getId(), newPerson);
        //eger person null ise
        if (updatedPerson != null) {
            // mesaj cap ele

            System.out.println("Dəyişdirilmiş person: " + updatedPerson);
        } else {
            // eks halda tapilmis personu cap ele
            System.out.println("Hec bir person deyisdirilmedi");
        }



        readPersons();
        System.out.println("Person was delete");
        deleteById(1);
        readPersons();
    }

    public static Person createPerson(long id, String name, String surname, int age) {

        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setSurname(surname);
        person.setAge(age);

        persons[say] = person;
        say++;

        return person;
    }

    public static void readPersons() {
        for (int i = 0; i < say; i++) {
            if (persons[i] != null) {
                System.out.println(persons[i]);
            }
        }
    }

    public static Person getPersonById(long id) {
        for (int i = 0; i < say; i++) {
            if (persons[i].getId() == id) { // person massivinin i ci elementinin (yeni Person obyektinin) idisini goturur ve parametire verilen id-i yoxlayir
                // eger massivin icinde hemen id vardirsa geriye hemin obyekti qaytarsin.
                return persons[i];
            }
        }
        return null;
    }

    public static void printPerson(Person person) {
        System.out.println(person);
    }

    public static Person updatePersonById(long id, Person newPerson) {
        // verilmis id esasinda personu axtar
        Person person = getPersonById(id);
        // eger person tapildisa
        if (person != null) {
            //tapilmis personun melumatlarini newPerson obyektinin melumatlari ile evez edin
            person.setName(newPerson.getName());
            person.setSurname(newPerson.getSurname());
            person.setAge(newPerson.getAge());
            return person;
            //deyisdirilmis personu qaytarin
        }
        return null;
    }

    public static boolean deleteById(long id) {
        for (int i = 0; i < say; i++) {
            if (persons[i].getId() == id) {
                persons[i] = null;
                break;
            }
        }

        for (int i = 0; i < say; i++) {
            if (i != say - 1 && persons[i] == null) {
                persons[i] = persons[i + 1];
            } else if (i == say - 1) {
                persons[i] = null;
            }
        }
            return true;
    }

}






