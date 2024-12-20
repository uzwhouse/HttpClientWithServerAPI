package uz.pdp.models;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class Post {
    UUID id;
    String title;
    String body;
    Date createdAt;
}
