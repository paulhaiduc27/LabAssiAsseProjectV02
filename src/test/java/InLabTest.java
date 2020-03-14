import domain.Nota;
import domain.Student;
import domain.Tema;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import repository.NotaXMLRepo;
import repository.StudentXMLRepo;
import repository.TemaXMLRepo;
import service.Service;
import validation.NotaValidator;
import validation.StudentValidator;
import validation.TemaValidator;
import validation.Validator;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        service.addStudent(new Student("11", "Alex11", 931, "email1@gmail.com"));
        assertEquals("Alex11", fileRepository1.findOne("11").getNume());
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
        service.addStudent(new Student("12", "Alex12", 931, "email1@gmail.com"));
        /*int counter2 = 0;
        for (Object j : fileRepository1.findAll()) {
            counter2++;
        }*/
        assertEquals("Alex12", fileRepository1.findOne("12").getNume());
    }
}
