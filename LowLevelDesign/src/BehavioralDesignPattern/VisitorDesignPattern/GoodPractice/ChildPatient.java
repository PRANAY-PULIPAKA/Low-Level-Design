package BehavioralDesignPattern.VisitorDesignPattern.GoodPractice;

class ChildPatient implements Patient{

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class AdultPatient implements Patient{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
}
class SeniorPatient implements Patient{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}


