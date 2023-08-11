class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender){
        try{
            if(Character.toLowerCase(gender) != 'm' && Character.toLowerCase(gender) != 'f'){
                throw new Exception();
            }
            this.name = name;
            this.email = email;
            this.gender = gender;

        } catch(Exception e) {
            System.out.println("Erro ao criar Objeto, coloque o genero como m ou f!!");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getGender() {
        return gender;
    }

    public String ToString() {
        return "Author[name=" + this.name + 
               ",email=" + this.email +
               ",gender=" + this.gender + "]";
    }

}

class Book {
    private String name;
    private Author[] authors;
    private double price;
    private int qty;

    public Book(String name, Author[] authors, double price, int qty){
        this.name = name;
        this.authors = authors;
        this.price = price;
        this.qty = qty;
    }

    public Book(String name, Author[] authors, double price) {
        this(name, authors, price, 0);
    }

    public String getName() {
        return name;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String ToString(){
        String aut = "";
        for (Author author : this.authors) {
            aut += author.ToString() + ",";
        }
        return String.format("Book[name=%s,authors={%s},price=%.2f,qty=%d]", this.name, aut, this.price, this.qty);
    }

    public String getAuthorsNames(){
        String res = "";

        for (Author author : this.authors) {
            res += author.getName() + ",";
        }

        return res;
    }

}

public class Ex01e02{
    public static void main(String[] args) {
        Author aut1 = new Author("pedro", "pedro@gmail.com", 'm');
        Author aut2 = new Author("leo", "leo@gmail.com", 'm');
        Author[] auts = {aut1, aut2};
        Book bk1 = new Book("livro teste", auts, 52.90);

        System.out.println(aut1.ToString());
        System.out.println(aut1.getName()); 
        System.out.println(aut1.getEmail()); 
        System.out.println(aut1.getGender());
        aut1.setEmail("emailnovo@gmail.com");     
        System.out.println(aut1.getEmail()); 
        System.out.println(aut2.ToString());
        System.out.println(bk1.getName());
        System.out.println(bk1.getAuthors());
        System.out.println(bk1.getPrice());
        System.out.println(bk1.getQty());
        bk1.setPrice(60);
        bk1.setQty(20);
        System.out.println(bk1.ToString());
        System.out.println(bk1.getAuthorsNames());
    }
}