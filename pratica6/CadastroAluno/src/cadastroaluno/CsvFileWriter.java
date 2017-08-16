/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadastroaluno;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author thomazerlach
 */
public class CsvFileWriter {
    //Delimiter used in CSV file
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
     
    //CSV file header
    private static final String FILE_HEADER = "nome,idade,endereco,rg,cpf";
    
    private static final List alunos = new ArrayList();
    
    public static void addToList(Person aluno){
    
        alunos.add(aluno);
        
    }
    
    public static void writeCsvFile(String fileName) {
     
        FileWriter fileWriter = null;

       try {
            fileWriter = new FileWriter(fileName);
 
            //Write the CSV file header
            fileWriter.append(FILE_HEADER.toString());
             
            //Add a new line separator after the header
            fileWriter.append(NEW_LINE_SEPARATOR);
             
            //Write a new student object list to the CSV file
            for (Iterator it = alunos.iterator(); it.hasNext();) {
                Person aluno = (Person) it.next();
                fileWriter.append(String.valueOf(aluno.getNome()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(aluno.getIdade());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(aluno.getEndereco());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(aluno.getRg());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(aluno.getCpf());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
   
            System.out.println("CSV file was created successfully !!!");
            
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        } finally {
             
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }    
        }      
    }
}
