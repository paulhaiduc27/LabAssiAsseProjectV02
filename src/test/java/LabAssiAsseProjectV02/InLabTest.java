package LabAssiAsseProjectV02;

import LabAssiAsseProjectV02.domain.Nota;
import LabAssiAsseProjectV02.domain.Student;
import LabAssiAsseProjectV02.domain.Tema;
import LabAssiAsseProjectV02.repository.NotaXMLRepo;
import LabAssiAsseProjectV02.repository.StudentXMLRepo;
import LabAssiAsseProjectV02.repository.TemaXMLRepo;
import LabAssiAsseProjectV02.service.Service;
import LabAssiAsseProjectV02.validation.*;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.LocalDate;

public class InLabTest {

    @Test
    public void FirstTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        service.addStudent(new Student("11", "Student11", 933, "email1@gmail.com"));
        assertEquals("Student11", fileRepository1.findOne("11").getNume());
    }

    @Test
    public void SecondTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        /*int counter1 = 0;
        for (Object i : fileRepository1.findAll()) {
            counter1++;
        }*/
        service.addStudent(new Student("12", "Student12", 933, "email1@gmail.com"));
        /*int counter2 = 0;
        for (Object j : fileRepository1.findAll()) {
            counter2++;*/

        assertEquals("Student12", fileRepository1.findOne("12").getNume());
    }

    @Test
    public void IdTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        int count1=0;
        for (Student s:fileRepository1.findAll())
            count1++;
        try {
            service.addStudent(new Student("", "StudentX", 933, "email1@gmail.com"));
        }catch (ValidationException msg){
            System.out.println("Id incorect...");
        }
        int count2=0;
        for (Student s:fileRepository1.findAll())
            count2++;
        assertEquals(count1, count2);
    }

    @Test
    public void IdNullTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        int count1=0;
        for (Student s:fileRepository1.findAll())
            count1++;
        try {
            service.addStudent(new Student(null, "StudentX", 933, "email1@gmail.com"));
        }catch (ValidationException msg){
            System.out.println("Id incorect...");
        }
        int count2=0;
        for (Student s:fileRepository1.findAll())
            count2++;
        assertEquals(count1, count2);
    }

    @Test
    public void NameTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        try {
            service.addStudent(new Student("13", "", 933, "email1@gmail.com"));
        }catch (ValidationException msg){
            System.out.println("Nume incorect...");
        }
        assertNull(fileRepository1.findOne("13"));
    }

    @Test
    public void NameNullTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        try {
            service.addStudent(new Student("14", null, 933, "email1@gmail.com"));
        }catch (ValidationException msg){
            System.out.println("Nume incorect...");
        }
        assertNull(fileRepository1.findOne("14"));
    }

    @Test
    public void GroupTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        try {
            service.addStudent(new Student("15", "student14", -1, "email1@gmail.com"));
        }catch (ValidationException msg){
            System.out.println("Grupa incorect...");
        }
        assertNull(fileRepository1.findOne("15"));
    }

    @Test
    public void EmailTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        try {
            service.addStudent(new Student("16", "student15", 933, ""));
        }catch (ValidationException msg){
            System.out.println("Email incorect...");
        }
        assertNull(fileRepository1.findOne("16"));
    }

    @Test
    public void EmailNullTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        try {
            service.addStudent(new Student("17", "student15", 933, null));
        }catch (ValidationException msg){
            System.out.println("Email incorect...");
        }
        assertNull(fileRepository1.findOne("17"));
    }


    @Test(expected = ValidationException.class)
    public void ThirdTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        try {
            service.addTema(new Tema("","descriere",1,7));
        }catch (ValidationException msg){
            if (msg.getMessage().equals("Numar tema invalid!"))
                throw new ValidationException("Id must not be null");
        }
    }

    @Test(expected = ValidationException.class)
    public void FourthTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        try {
            service.addTema(new Tema("1","descriere",15,7));
        }catch (ValidationException msg){
            if(msg.getMessage().equals("Deadlineul trebuie sa fie intre 1-14."))
                throw new ValidationException("Deadlineul trebuie sa fie intre 1-14.");
        }
    }

    @Test(expected = ValidationException.class)
    public void DescriptionTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        try {
            service.addTema(new Tema("1","",1,7));
        }catch (ValidationException msg){
            if (msg.getMessage().equals("Descriere invalida!"))
                throw new ValidationException("Invalid description!");
        }
    }

    @Test(expected = ValidationException.class)
    public void AssignedWeekTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        try {
            service.addTema(new Tema("1","descriere",10,15));
        }catch (ValidationException msg){
            if(msg.getMessage().equals("Saptamana primirii trebuie sa fie intre 1-14."))
                throw new ValidationException("Assigned week must be between 1-14");
        }
    }

    @Test
    public void ValidAssignmentTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        try {
            service.addTema(new Tema("1","descriere1",7,1));
        }catch (ValidationException msg){
            throw new ValidationException(msg.getMessage());
        }
        int count=0;
        for (Tema t:fileRepository2.findAll())
            count++;
        if (count==1){
            assertEquals("descriere1", fileRepository2.findOne("1").getDescriere());
        }
    }

    @Test
    public void ValidGradeTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        service.addStudent(new Student("11", "Student11", 933, "email1@gmail.com"));
        service.addTema(new Tema("1","descriere1",7,1));
        service.addNota(new Nota("1","11","1",10, LocalDate.now()),"very good");
        assertEquals("1", fileRepository3.findOne("1").getID());
    }

    @Test
    public void ValidIntegratedTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        service.addStudent(new Student("1", "Student1", 933, "email1@gmail.com"));
        assertEquals("Student1", fileRepository1.findOne("1").getNume());
        service.addTema(new Tema("1","descriere1",7,1));
        int count=0;
        for (Tema t:fileRepository2.findAll())
            count++;
        assertEquals(count,1);
        service.addNota(new Nota("1","1","1",10, LocalDate.now()),"very good");
        assertEquals("1", fileRepository3.findOne("1").getID());
    }
}
