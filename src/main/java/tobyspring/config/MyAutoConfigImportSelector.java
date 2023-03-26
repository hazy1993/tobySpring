package tobyspring.config;

import org.springframework.boot.context.annotation.ImportCandidates;
import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;

public class MyAutoConfigImportSelector implements DeferredImportSelector {

    private final ClassLoader classLoader;

    public MyAutoConfigImportSelector(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        List<String> autoConfigs = new ArrayList<String>();
      /*코드 변환 1.
      for(String candidate: ImportCandidates.load(MyAutoConfigration.class, classLoader)){
            autoConfigs.add(candidate);
      }
      코드변환 2.
             ImportCandidates.load(MyAutoConfigration.class, classLoader).forEach(
               candidate ->  autoConfigs.add(candidate)
      );*/
        //코드변환 3
        ImportCandidates.load(MyAutoConfiguration.class, classLoader).forEach(autoConfigs::add);

//        return autoConfigs.stream().toArray(String[]::new); 스트림 이전
        return autoConfigs.toArray(new String[0]);


     /*간략하게
       Iterable<String> candidate = ImportCandidates.load(MyAutoConfigration.class, classLoader);
        return StreamSupport.stream(candidate.spliterator(),false).toArray(String[]::new);*/
    }
}
