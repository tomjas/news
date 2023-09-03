package pl.mobilet.news.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto {

    private String status;
    private String code;
    private String message;
    private long totalResults;

}
