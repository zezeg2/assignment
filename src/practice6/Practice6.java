package practice6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Practice6 {
    static class Post {

        private int id;
        private String title;
        private String content;

        public Post(int id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getContent() {
            return content;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Post> list = new ArrayList<>();
        String title;
        String content;
        int cnt = 0;
        boolean exit = false;

        while (!exit) {
            System.out.print("명령어 )");
            switch (reader.readLine()){
                case "등록":
                    cnt++;
                    System.out.print("제목 : ");
                    title = reader.readLine();
                    System.out.print("내용 : ");
                    content = reader.readLine();
                    Post post = new Post(cnt, title, content);
                    list.add(post);
                    System.out.printf("[알림] %d 번글이 등록되었습니다.\n", cnt);
                    break;
                case "목록":
                    System.out.println("  번호  /  제목  ");
                    System.out.println("---------------");
                    for (Post p : list){
                        System.out.printf("%4d /\t%s\n",p.getId(),p.getTitle());
                    }
                    break;
                case "조회":
                    System.out.println("조회하실 게시물의 번호를 입력하세요.");
                    int sel = Integer.parseInt(reader.readLine());
                    list.stream().filter(p -> p.getId() == sel).forEach(p-> {
                        System.out.println("제목 : " + p.getTitle());
                        System.out.println("내용 : " + p.getContent());
                    });
                    break;
                case "종료":
                    System.out.println("프로그램을 종료합니다.");
                    exit = true;
                    break;
            }
        }
    }
}
