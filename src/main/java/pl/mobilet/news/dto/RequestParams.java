package pl.mobilet.news.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class RequestParams {

    private Integer limit;
    private Integer offset;
}
