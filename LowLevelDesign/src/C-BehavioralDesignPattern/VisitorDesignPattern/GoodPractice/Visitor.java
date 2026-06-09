package BehavioralDesignPattern.VisitorDesignPattern.GoodPractice;

public interface Visitor {
    void visit(ChildPatient childPatient);
    void visit(AdultPatient adultPatient);
    void visit (SeniorPatient seniorPatient);

}
