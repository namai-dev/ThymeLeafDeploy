package com.amo.amo.file;

import lombok.*;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
@Setter
public class FileResponse {
    private String name;
    private String type;

    private int size;
}
