package model.qaguru;

public enum Courses {
    QA(1), QA2(3), WEB(5);

    private int value;

    Courses(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
