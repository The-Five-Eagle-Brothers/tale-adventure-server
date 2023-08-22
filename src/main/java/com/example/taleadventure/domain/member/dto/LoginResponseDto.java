package com.example.taleadventure.domain.member.dto;

import com.example.taleadventure.domain.member.entity.Member;
import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {

    private Long userId;
    private String name;
    private String nickName;
    private String phoneNumber;
    private String email;
    private String gender;
    private Integer age;
    private String status;
    private Long wordBookId;
    private String accessToken;

    public static LoginResponseDto of(Member member, String token){
        return LoginResponseDto.builder()
                .userId(member.getId())
                .name(member.getName())
                .nickName(member.getNickName())
                .phoneNumber(member.getPhoneNumber())
                .email(member.getEmail())
                .gender(Member.genderEnumToString(member.getGender()))
                .age(member.getAge())
                .status(Member.statusEnumToString(member.getStatus()))
                .wordBookId(member.getWordBook().getId())
                .accessToken(token)
                .build();
    }
}