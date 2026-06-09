package BehavioralDesignPattern.VisitorDesignPattern.BadPractice;

class ChildPatient {

    public void diagnosis(){
        System.out.println("Diagnosing a child patient");
    }
    public void billing(){
        System.out.println("Calculating billing for child Patient");
    }
}

class AdultPatient{
    public void diagnosis(){
        System.out.println("Diagnosing an adult patient");
    }

    public void billing(){
        System.out.println("Calculating billing for adult patient");
    }
}

class SeniorPatient{
    public void diagnosis(){
        System.out.println("Diagnosing a senior patient");
    }

    public void billing(){
        System.out.println("Calculating billing for a senior patient");
    }
}



