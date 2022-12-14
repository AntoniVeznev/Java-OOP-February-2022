package Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.core;

import Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.common.ConstantMessages;
import Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.repositories.HelperRepository;
import Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.repositories.PresentRepository;

import java.util.*;

public class ControllerImpl implements Controller {
    private HelperRepository helperRepository;
    private PresentRepository presentRepository;


    public ControllerImpl() {
        this.helperRepository = new HelperRepository();
        this.presentRepository = new PresentRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        Helper helper;
        if (type.equals("Happy")) {
            helper = new Happy(helperName);
        } else if (type.equals("Sleepy")) {
            helper = new Sleepy(helperName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);
        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {
        Instrument instrument = new InstrumentImpl(power);
        Helper byName = helperRepository.findByName(helperName);
        if (byName != null) {
            byName.getInstruments().add(instrument);
            return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }
    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        int presantCompleateCounter = 0;
        Present present = presentRepository.findByName(presentName);
        List<Helper> suitablePPl = new ArrayList<>();
        for (Helper helper : helperRepository.getModels()) {
            if (helper.getEnergy() > 50) {
                suitablePPl.add(helper);
            }
        }
        if (suitablePPl.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        } else {
            for (Helper helper : suitablePPl) {
                if (helper.canWork()) {
                    helper.work();


                    if (presentRepository.findByName(presentName).isDone()) {
                        presantCompleateCounter++;
                    }
                }
            }
            StringBuilder builder = new StringBuilder();

            if (present.isDone()) {
                builder.append(String.format(ConstantMessages.PRESENT_DONE, presentName, "done"));
                builder.append(String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, 5));
            } else {
                builder.append(String.format(ConstantMessages.PRESENT_DONE, presentName, "not done"));
                builder.append(String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, 5));
            }
            return builder.toString().trim();
        }
    }

    @Override
    public String report() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%s presents are done!", presentRepository.getModels())).append(System.lineSeparator());
        builder.append("Helpers info:").append(System.lineSeparator());
        for (Helper helper : helperRepository.getModels()) {
            builder.append(String.format("Name: %s", helper.getName())).append(System.lineSeparator());
            builder.append(String.format("Energy: %d", helper.getEnergy())).append(System.lineSeparator());
            builder.append(String.format("Instruments: %d not broken left", helper.getInstruments().size())).append(System.lineSeparator());

        }
        return builder.toString().trim();
    }
}
