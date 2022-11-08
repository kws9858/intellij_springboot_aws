package com.alphacoder.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_function_test(){
        // given
        String name = "test";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        // then
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        /*
            assertThat  : assertj라는 테스트 검증 라이브러리의 검증 메소드입니다.
                          검증하고 싶은 대상을 메소드 인자로 받고 메소드 체이닝이 지원됩니다.
            isEqualTo   : assertj의 동등비교 메소드입니다.
                          assertThat에 있는 값과 isEqualsTo의 값을 비교하여 같을 떄만 성공입니다.

            Junit의 기본 assertThat에 비해 assertj의 assertThat을 사용시 얻는 장점
                Junit의 assertThat은 is()와 같은 CoreMatchers 라이브러리가 필요하지만 assertj는 필요하지 않습니다.
                자동완성이 좀 더 확실하게 지원됩니다. IDE에서는 CoreMatchers와 같은 Matcher 라이브러리의 자동완성 지원이 약합니다.

            ※ Matcher 라이브러리 : 필터나 검색등을 위해 값을 비교할때 좀 더 편리하게 사용하도록 도와주는 라이브러리
         */
    }
}
