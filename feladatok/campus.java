import java.util.ArrayList;
import java.util.List;

class Person {
    public String name;
    public int age;
    public String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
        this("Jane Doe", 30, "female");
    }

    public void getGoal() {
        System.out.println("My goal is: Live for the moment.");
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + ".");
    }
}

class Student extends Person {
    private String previousOrganization;
    private int skippedDays;

    public Student(String name, int age, String gender, String previousOrganization) {
        super(name, age, gender);
        this.previousOrganization = previousOrganization;
        this.skippedDays = 0;
    }

    public Student() {
        this("Jane Doe", 30, "female", "The School of Life");
    }

    public void getGoal() {
        System.out.println("Be a junior software developer.");
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + " from " + previousOrganization + " who skipped " + skippedDays + " days from the course already.");
    }

    public void skipDays(int numberOfDays) {
        skippedDays += numberOfDays;
    }
}

class Mentor extends Person {
    private String level;

    public Mentor(String name, int age, String gender, String level) {
        super(name, age, gender);
        this.level = level;
    }

    public Mentor() {
        this("Jane Doe", 30, "female", "intermediate");
    }

    public void getGoal() {
        System.out.println("Educate brilliant junior software developers.");
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + " " + level + " mentor.");
    }
}

class Sponsor extends Person {
    private String company;
    private int hiredStudents;

    public Sponsor(String name, int age, String gender, String company) {
        super(name, age, gender);
        this.company = company;
        this.hiredStudents = 0;
    }

    public Sponsor() {
        this("Jane Doe", 30, "female", "Google");
    }

    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a " + age + " year old " + gender + " who represents " + company + " and hired " + hiredStudents + " students so far.");
    }

    public void hire() {
        hiredStudents++;
    }

    public void getGoal() {
        System.out.println("Hire brilliant junior software developers.");
    }
}

class Campus {
    public static void main(String[] args) {
        Cohort awesomeCohort = new Cohort("AWESOME");

        Student mark = new Student("Mark", 46, "male", "BME");
        mark.getGoal();
        mark.introduce();
        awesomeCohort.addStudent(mark);

        Student janeDoe = new Student();
        janeDoe.getGoal();
        janeDoe.introduce();
        awesomeCohort.addStudent(janeDoe);

        Student johnDoe = new Student("John Doe", 20, "male", "BME");
        johnDoe.skipDays(0);
        johnDoe.getGoal();
        johnDoe.introduce();
        awesomeCohort.addStudent(johnDoe);

        Student janeDoe2 = new Student("Jane Doe", 30, "female", "The School of Life");
        janeDoe2.skipDays(3);
        janeDoe2.getGoal();
        janeDoe2.introduce();
        awesomeCohort.addStudent(janeDoe2);

        Mentor gandhi = new Mentor("Gandhi", 148, "male", "senior");
        gandhi.getGoal();
        gandhi.introduce();
        awesomeCohort.addMentor(gandhi);

        Mentor janeDoeMentor = new Mentor();
        janeDoeMentor.getGoal();
        janeDoeMentor.introduce();
        awesomeCohort.addMentor(janeDoeMentor);

        Sponsor googleSponsor = new Sponsor("Jane Doe", 30, "female", "Google");
        googleSponsor.hire();
        googleSponsor.hire();
        googleSponsor.hire();
        googleSponsor.getGoal();
        googleSponsor.introduce();


        Sponsor spacexSponsor = new Sponsor("Elon Musk", 46, "male", "SpaceX");
        spacexSponsor.hire();
        spacexSponsor.hire();
        spacexSponsor.hire();
        spacexSponsor.hire();
        spacexSponsor.hire();
        spacexSponsor.getGoal();
        spacexSponsor.introduce();


        awesomeCohort.info();
    }
}

class Cohort {
    private String name;
    private List<Student> students;
    private List<Mentor> mentors;

    public Cohort(String name) {
        this.name = name;
        this.students = new ArrayList<>();
        this.mentors = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addMentor(Mentor mentor) {
        mentors.add(mentor);
    }

    public void info() {
        System.out.println("The " + name + " cohort has " + students.size() + " students and " + mentors.size() + " mentors.");
    }
}