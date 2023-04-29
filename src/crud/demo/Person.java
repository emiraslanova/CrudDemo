
package crud.demo;



public class Person {

    private long id;
    private String name;
    private String surname;
    private int age;
    private static int volume = 15;

    public Person(){}

    public Person(long id, String name, String surname, int age) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }




    public void setAge(int age) {
        this.age = age;
    }

    public static int getVolume() {
        return volume;
    }

    public static void setVolume(int volume) {

        Person.volume = volume;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}






