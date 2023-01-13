package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 1_000_000_000_000_0L;
    protected StringBuilder processorVersion;
    private Integer valueOfCheap;
    Scanner informationScanner;
    static List<String> stringArrayList = new LinkedList<>();

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringList.stream().filter(Objects::nonNull)
            .mapToInt(Objects::hashCode)
            .forEach(System.out::println);
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        return stringList.stream().filter(Objects::nonNull)
            .peek(s -> processorVersion.append(s))
            .collect(Collectors.joining());
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file)  {
        try {
            informationScanner = new Scanner(file);
            while (informationScanner.hasNext()) {
                processorVersion.append(informationScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            informationScanner.close();
        }


    }
}
