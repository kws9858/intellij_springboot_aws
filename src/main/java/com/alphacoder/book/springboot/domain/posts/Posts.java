package com.alphacoder.book.springboot.domain.posts;

import com.alphacoder.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
/*
    @NoArgsConstructor :    기본생성자 자동 추가
 */
@Entity
/*
    @Entity :   테이블과 링크될 클래스임을 나타냅니다.
                기본 값으로 클래스의 카멜케이스 이름을 언더 스코어 네이밍(_)으로 테이블 이름을 매핑합니다.
                ex) abcDef.java -> abc_def table
 */
public class Posts extends BaseTimeEntity {

    @Id // 해당 테이블의 PK 필드를 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /*
        PK의 생성 규칙을 나타냅니다.
        스프링부트 2.0에서는 GenerationType.IDENTITY를 옵션을 추가해야지만 auto increment가 됩니다.
     */
    private Long id;

    @Column(length = 500, nullable = false)
    /*
        테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 됩니다.
        사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용합니다.
        즉, 옵션값의 변경을 위해 사용됩니다. 컬럼의 길이 혹은 nullable 여부 등등의 조건을 설정할 수 있습니다.
     */
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    /*
        해당 클래스의 빌더 패턴 클래스를 생성
        생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
     */
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
