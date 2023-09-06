package com.example.taleadventure.domain.chapter.controller;

import com.example.taleadventure.base.config.login.JwtHeaderUtil;
import com.example.taleadventure.base.dto.ApiSuccessResponse;
import com.example.taleadventure.base.success.SuccessResponseResult;
import com.example.taleadventure.domain.chapter.dto.ChapterInfoDto;
import com.example.taleadventure.domain.chapter.dto.ChapterRequest;
import com.example.taleadventure.domain.chapter.service.ChapterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chapter")
public class ChapterController {

    private final ChapterService chapterService;

    @PostMapping("/save")
    public ApiSuccessResponse<ChapterInfoDto> saveTaleBook(HttpServletRequest request, ChapterRequest chapterRequest, MultipartFile multipartFile){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_CREATED, chapterService.saveChapter(chapterRequest, multipartFile));
    }

    @GetMapping("/retrieve")
    public ApiSuccessResponse<List<ChapterInfoDto>> retrieveChapter(HttpServletRequest request, @RequestParam String name){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_SEARCH_Chapter, chapterService.retrieveChapter(name, token));
    }
}
