package Week2.StudentInformationSystem;

public class Main {
    public static void main(String[] args) {
        Teacher teacher1 = new Teacher("Hamdi Hoca" , "MAT" , "444");
        Teacher teacher2 = new Teacher("Güliz Hoca" , "ENG" , "333");
        Teacher teacher3 = new Teacher("Adil Hoca" ,"TRK" , "555");

        Course mat = new Course("Matematik" , "101" ,"MAT");
        mat.addTeacher(teacher1);

        Course eng = new Course("İngilizce" , "101" , "ENG");
        eng.addTeacher(teacher2);

        Course trk = new Course("Türkçe" , "102" , "TRK");
        trk.addTeacher(teacher3);

        Student student1 = new Student("Abdullah Aslan", "671", "8",mat,eng,trk);
        student1.addBulkExamNote(100,80,85);
        student1.isPass();

        Student student2 = new Student("Ali Aslan" , "497" ,"7" ,mat,eng,trk);
        student2.addBulkExamNote(42,55,63);
        student2.isPass();

    }
}
