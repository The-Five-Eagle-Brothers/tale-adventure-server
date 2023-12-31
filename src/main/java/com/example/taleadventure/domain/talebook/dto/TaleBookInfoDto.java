package com.example.taleadventure.domain.talebook.dto;

import com.example.taleadventure.domain.member.dto.MemberInfoDto;
import com.example.taleadventure.domain.member.entity.Member;
import com.example.taleadventure.domain.talebook.entity.TaleBook;
import com.example.taleadventure.domain.talebook.enummerate.Category;
import lombok.*;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TaleBookInfoDto {
    private Long id;
    private String name;
    private Category category;
    private String libraryImageUrl;
    private String chapterImageUrl;
    private String wordBookImageUrl;

    public static TaleBookInfoDto of(TaleBook taleBook){
        return TaleBookInfoDto.builder()
                .id(taleBook.getId())
                .name(taleBook.getName())
                .category(taleBook.getCategory())
                .libraryImageUrl(taleBook.getLibraryImageUrl())
                .chapterImageUrl(taleBook.getChapterImageUrl())
                .wordBookImageUrl(taleBook.getWordBookImageUrl())
                .build();
    }
}
