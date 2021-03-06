import java.util.*;
import java.util.stream.Collectors;
import java.util.Comparator;

class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );


        }
        long count = persons.stream()
                .filter(value -> value.getAge() < 18)
                .count();
        System.out.println(count);

        List<String> die = persons.stream()
                .filter(value -> value.getAge() > 18)
                .filter(value -> value.getAge() < 27)
                .filter(value -> value.getSex() == Sex.MAN)
                .map(p -> p.getFamily())
                .collect(Collectors.toList());
        System.out.println(die);

        List<Person> sandwich = persons.stream()
                .filter(value -> value.getAge() > 18  && value.getAge() < 60 && value.getSex() == Sex.WOMEN  ||  value.getAge() < 65 && value .getSex() == Sex.MAN  )
                .filter(v -> v.getEducation() == Education.HIGHER)
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(sandwich);


    }


}