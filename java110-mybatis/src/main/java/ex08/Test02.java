// fk 컬럼으로 지정된 값 가져오기 - 첨부파일 가져오기 I
package ex08;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test02 { 

    public static void main(String[] args) throws Exception {
        
        String resource = "ex08/mybatis-config-01.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(sqlSessionFactory);
        
        
        Board board = boardDao.findByNo(2);
        System.out.printf("번호:%d\n", board.getNo());
        System.out.printf("제목:%s\n", board.getTitle());
        System.out.printf("내용:%s\n", board.getContent());
        System.out.printf("조회수:%d\n", board.getViewCount());
        System.out.printf("등록일:%s\n", board.getCreatedDate());
        
        /* 게시물 상세조회할 때작성자의 정보 또한 자세히 출력하는 상황이라면
         * => ex05에서와 달리 작성자의 상세 정보를 가져오기 위해
         *    p1_memb테이블에 대해 따로 select를 하지 않는다.
         * => 게시물을 가져올 때 join해서 작성자 정보까지 가져온다.
         * => 단 게시물에 작성자 정보도 담아야 하기 때문에
         *    Board테이블에 email과 tel필드를 추가해야한다.
         * => 목록에서 간단히 name을 추가하는 겨웅와 달리
         *    Board 클래스에 작성자인 정보를 저장할 필드를 추가해야한다.
         * => 이것은 객체지향의 중요한 특징 중 하나인
         *    "High Cohesion(높은 응집력 ; 한 클래스 한 역할)"을 어기는 것이다.
         *    한 클래스가 여러 역할을 맡으면 유지보수가 어려워진다.
         * => 즉 p1_memb테이블에 변경이 발생하면
         *    Member 클래스 외에 Board클래스도 영향을 받는것이 문제이다.
         * => 해결책?
         *    ex07을 보라!
         */

        /* 게시물 상세조회의 작성자 정보처럼
         * 조인한 테이블에 다수 데이터를 가져와야 할 경우,
         * Board객체에 담지 말고 별도로 Member 객체를 만들 담는 것이
         * 유지보수에 좋다.
         * => 물론 개발자가 Member 객체를 만드는 것이 아니라,
         *    Mybatis가 Member 객체를 만들어 
         *    작성자 정보를 저장해 줄 것이다.
         * => 방법?
         *    BoardDao-01.xml파일을 보라
         */
        
        Member m = board.getMember();
        System.out.printf("작성자 이름 :%s\n", m.getName());
        System.out.printf("작성자 이메일 :%s\n", m.getEmail());
        System.out.printf("작성자 전화 :%s\n", m.getTel());
        
        
        /* 게시물을 가져올때 Mybatis는 첨부파일 목록까지 준비해준다.
         * 즉 게시물을 select할 때 첨부파일 데이터까지 묶어서 처리한다. 
         */
        List<AttachFile> files = board.getAttachFiles();
        System.out.println("첨부파일 : ");
        for(AttachFile f : files) {
            System.out.printf("- %s(%d)\n", f.getFilename(), f.getNo());
        }
    }

}










