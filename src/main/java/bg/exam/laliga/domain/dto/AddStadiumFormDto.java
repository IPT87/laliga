package bg.exam.laliga.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddStadiumFormDto {

    @NotNull
    @Size(min = 2, max = 40)
    private String name;
    @NotNull
    @Size(min = 2, max = 40)
    private String city;
    @NotNull
    private String yearOfConstruction;
    @NotNull
    @Min(value = 8000)
    @Max(value = 120000)
    private int capacity;
    @NotNull
    @Size(min = 20, max = 500)
    private String info;
    @NotNull
    @Size(min = 5, max = 30)
    private String photoUrl;

}
