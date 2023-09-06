package com.example.taleadventure.domain.word.controller;

import com.example.taleadventure.base.config.login.JwtHeaderUtil;
import com.example.taleadventure.base.dto.ApiSuccessResponse;
import com.example.taleadventure.base.success.SuccessResponseResult;
import com.example.taleadventure.domain.chapter.dto.ChapterInfoDto;
import com.example.taleadventure.domain.chapter.dto.ChapterRequest;
import com.example.taleadventure.domain.chapter.service.ChapterService;
import com.example.taleadventure.domain.word.dto.WordInfoDto;
import com.example.taleadventure.domain.word.dto.WordRequest;
import com.example.taleadventure.domain.word.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/word")
public class WordController {

    private final WordService wordService;

    @PostMapping("/save")
    public ApiSuccessResponse<WordInfoDto> saveTaleBook(HttpServletRequest request, WordRequest wordRequest, MultipartFile multipartFile){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_CREATED, wordService.saveWord(wordRequest, multipartFile));
    }

    @GetMapping("/retrieve")
    public ApiSuccessResponse<List<WordInfoDto>> retrieveChapter(HttpServletRequest request, @RequestParam String title){
        String token = JwtHeaderUtil.getAccessToken(request);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_SEARCH_WORD, wordService.retrieveWord(title, token));
    }

    @PatchMapping("/update/book-mark")
    public ApiSuccessResponse<String> updateBookMark(HttpServletRequest request, List<WordInfoDto> wordInfoDtos){
        String token = JwtHeaderUtil.getAccessToken(request);
        wordService.updateBookMark(wordInfoDtos, token);
        return ApiSuccessResponse.successResponse(SuccessResponseResult.SUCCESS_UPDATE_WORD_BOOKMARK);
    }
}
