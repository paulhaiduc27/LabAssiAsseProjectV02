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
}
