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

public class IncrementalIntegration {
    @Test
    public void AddStudentTest(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        service.addStudent(new Student("1", "Student1", 933, "email1@gmail.com"));
        assertEquals("Student1", fileRepository1.findOne("1").getNume());
    }
    @Test
    public void AddStudentAddAssignmentIntegration(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        service.addStudent(new Student("2", "Student2", 933, "email2@gmail.com"));
        assertEquals("Student2", fileRepository1.findOne("2").getNume());
        service.addTema(new Tema("1","descrieretema1",10,4));
        int count=0;
        for (Tema t:fileRepository2.findAll())
            count++;
        if (count==1){
            assertEquals("descrieretema1", fileRepository2.findOne("1").getDescriere());
        }
    }
    @Test
    public void AddStudentAddAssignmentAddGradeIntegration(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepo fileRepository1 = new StudentXMLRepo("studenti.xml");
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepo fileRepository2 = new TemaXMLRepo("teme.xml");
        NotaValidator notaValidator = new NotaValidator(fileRepository1,fileRepository2);
        NotaXMLRepo fileRepository3 = new NotaXMLRepo("note.xml");
        Service service = new Service(fileRepository1,studentValidator,fileRepository2,temaValidator,fileRepository3,notaValidator);
        service.addStudent(new Student("3", "Student3", 933, "email3@gmail.com"));
        assertEquals("Student3", fileRepository1.findOne("3").getNume());
        int countInitial=0;
        for (Tema t:fileRepository2.findAll())
            countInitial++;
        service.addTema(new Tema("2","descrieretema2",10,5));
        int count=0;
        for (Tema t:fileRepository2.findAll())
            count++;
        assertEquals(count,countInitial+1);
        service.addNota(new Nota("1","3","2",10, LocalDate.now()),"very good");
        assertEquals("1", fileRepository3.findOne("1").getID());
    }
}
