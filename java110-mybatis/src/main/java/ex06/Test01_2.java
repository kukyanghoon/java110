// fk 컬럼으로 지정된 값 가져오기 - join을 실행하여 가져오기
package ex06;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Test01_2 { 

    public static void main(String[] args) throws Exception {
        
        String resource = "ex06/mybatis-config-01.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);
        
        BoardDao boardDao = new BoardDao();
        boardDao.setSqlSessionFactory(sqlSessionFactory);
        
        HashMap<String,Object> params = new HashMap<>();
        params.put("rowNo", 0);
        params.put("pageSize", 5);
        
        List<Board> boards = boardDao.findAll(params);
        for (Board b : boards) {
            // p1_board테이블과 p1_memb테이블을 조인했기 때문에
            // 작성자 정보를 가져오기 위해 추가적인 select가 필요없다.
            System.out.printf("%d, %s, %d, %s, %s\n", 
                    b.getNo(),
                    b.getTitle(),
                    b.getViewCount(),
                    b.getWriter(),
                    b.getCreatedDate());
        }
        // 그러나 게시물 목록조회에서 작성자의 이름을 출력하기 위해 
        // 각 게시물에 대해 매번 select를 실행한다면 
        // 그것은 DBMS에 오버헤드를 발생시켜 성능을 저하시키는 원인이 된다.
        // 해결책?
        // => 조인을 이용하라!
    }
}










