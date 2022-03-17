package textbook.two.pojo;

public class Textbook {
    private int id;
    private int gradeID;
    private String textbookName;
    private String press;//出版社
    private String price;//价格

    public Textbook(int id, int gradeID, String textbookName, String press, String price) {
        this.id = id;
        this.gradeID = gradeID;
        this.textbookName = textbookName;
        this.press = press;
        this.price = price;
    }
    public Textbook(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGradeID() {
        return gradeID;
    }

    public void setGradeID(int gradeID) {
        this.gradeID = gradeID;
    }

    public String getTextbookName() {
        return textbookName;
    }

    public void setTextbookName(String textbookName) {
        this.textbookName = textbookName;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Textbook{" +
                "id=" + id +
                ", gradeID=" + gradeID +
                ", textbookName='" + textbookName + '\'' +
                ", press='" + press + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
