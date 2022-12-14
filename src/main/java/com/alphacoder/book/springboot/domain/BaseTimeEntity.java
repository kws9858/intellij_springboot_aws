package com.alphacoder.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
/*
    MappedSuperclass :  JPA Entity 클래스들이 BaseTimeEntity을 상속할 경우
                        필드들(createdDate, modifiedDate)도 컬럼으로 인식하도록합니다.
    BaseTimeEntity :    모든 Entity의 상위 클래스가 되어 Entity들의
                        createdDate, modifiedDate을 자동으로 관리하는 역할을 합니다.
 */
@EntityListeners(AuditingEntityListener.class)
/*
    EntityListeners :   BaseTimeEntity 클래스에 Auditing 기능을 포함시키는 역하을 합니다.
 */
public abstract class BaseTimeEntity {

    @CreatedDate    // Entity가 생성되어 저장될 때 시간이 자동 저장됩니다.
    private LocalDateTime createdDate;

    @LastModifiedDate   // 조회한 Entity의 값이 변경될 때 시간이 자동 저장됩니다.
    private LocalDateTime modifiedDate;
}
