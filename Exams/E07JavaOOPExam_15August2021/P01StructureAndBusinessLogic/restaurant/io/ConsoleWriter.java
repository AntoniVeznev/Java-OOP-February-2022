package Exams.E07JavaOOPExam_15August2021.P01StructureAndBusinessLogic.restaurant.io;

import restaurant.io.interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    public void writeLine(String text) {
        System.out.println(text);
    }
}
