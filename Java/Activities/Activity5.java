package Activities;

public class Activity5 {
    public static void main(String[] args) {
        String title = "Gone with the Wind";
        Book newNovel = new MyBook();
        newNovel.setTitle(title);
        System.out.println("Book Title is: " + newNovel.getTitle());
    }
}
