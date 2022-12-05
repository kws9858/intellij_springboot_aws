package com.alphacoder.book.springboot.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
// ※ 별다른 설정 없이 해당 어노테이션을 사용시 H2데이터베이스를 자동 실행해 줍니다.
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    /*
        Junit에서 단위테스트가 끝날 때마다 수행되는 메소드를 지정
        보통은 배포 전 전체테스트를 수행할 때 테스트간 데이터 침범을 막기 위해사용합니다.
        여러 테스트가 동시에 수행되면 테스트용 데이터베이스인 H2에 데이터가 그대로 남아 있어 다음 테스트 실행시 테스트가 실패할 수 있습니다.
     */
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void postSave_Loading(){
        // given
        String title = "테스트게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()
                // save() : 테이블에 insert/update 쿼리를 실행합니다. id값이 있다면 update가, 없으면 insert 쿼리가 실행됩니다.
                .title(title)
                .content(content)
                .author("fkdlfps0722@gmail.com")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();
        // findAll() : 테이블에 있는 모든 데이터를 조회해옵니다.

        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }

    @Test
    public void BaseTimeEntity_regist() {
        // given
        LocalDateTime now = LocalDateTime.of(2022,12,1,0,0,0);
        postsRepository.save(Posts.builder()
                .title("title")
                .content("content")
                .author("author")
                .build());

        // when
        List<Posts> postsList = postsRepository.findAll();

        // then
        Posts posts = postsList.get(0);

        System.out.println("createDate : "+ posts.getCreatedDate()+", modifiedDate : "+posts.getModifiedDate());
        assertThat(posts.getCreatedDate()).isAfter(now);
        assertThat(posts.getModifiedDate()).isAfter(now);
    }

}
