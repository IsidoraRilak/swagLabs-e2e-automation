package dto;

import lombok.Data;

import java.util.List;

@Data
public class PetDTO {

    private Long id;
    private String name;
    private String status;
    private List<String> photoUrls;

    @Data
    public static class Category {
        private int id;
        private String name;
    }
    private Category category;

    @Data
    public static class Tag {
        private int id;
        private String name;
    }
    private List<Tag> tags;
}
