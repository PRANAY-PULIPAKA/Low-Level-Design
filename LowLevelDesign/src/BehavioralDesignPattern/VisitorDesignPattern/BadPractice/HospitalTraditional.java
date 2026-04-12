package BehavioralDesignPattern.VisitorDesignPattern.BadPractice;

public class HospitalTraditional {
    public static void main(String[] args) {

        Object patient = new AdultPatient();

        if(patient instanceof ChildPatient){
            ((ChildPatient) patient).diagnosis();
            ((ChildPatient) patient).billing();
        } else if(patient instanceof AdultPatient)  {
            ((AdultPatient) patient).diagnosis();
            ((AdultPatient) patient).billing();
        } else if (patient instanceof SeniorPatient) {
            ((SeniorPatient) patient).diagnosis();
            ((SeniorPatient) patient).billing();
        }
    }
}
