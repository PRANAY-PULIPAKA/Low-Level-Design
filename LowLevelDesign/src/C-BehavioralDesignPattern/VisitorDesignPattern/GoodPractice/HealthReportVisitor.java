package BehavioralDesignPattern.VisitorDesignPattern.GoodPractice;

//Adding new operation without a Hitch
public class HealthReportVisitor implements Visitor{
    @Override
    public void visit(ChildPatient childPatient) {
        System.out.println("Generating health report for a child patient.");
    }

    @Override
    public void visit(AdultPatient adultPatient) {
        System.out.println("Generating health report for an adult patient.");
    }

    @Override
    public void visit(SeniorPatient seniorPatient) {
        System.out.println("Generating health report for a senior patient.");
    }
}
