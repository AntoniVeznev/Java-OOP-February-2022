package Exams.E03JavaOOPExam_09April2022.P01StructureAndBusinessLogic.fairyShop.models;

public class ShopImpl implements Shop {

    @Override
    public void craft(Present present, Helper helper) {

        for (Instrument instrument : helper.getInstruments()) {

            while (!present.isDone() && helper.canWork() && !instrument.isBroken()) {
                if (instrument.isBroken()) {
                    helper.getInstruments().remove(instrument);
                }
                instrument.use();
                helper.work();
                if (instrument.isBroken()) {
                    helper.getInstruments().remove(instrument);
                }


            }
        }
    }
}

