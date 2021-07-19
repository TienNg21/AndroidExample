package vn.tien.androidexample.ui.data;

import java.util.ArrayList;
import java.util.List;

public class LanguageDataUtils {
    public static List<Language> getLanguages( ) {
        Language none  = new Language(0, "none", 0f);
        Language javascript = new Language(1,"Javascript", 67.7f);
        Language htmlCss = new Language(2,"HTML/CSS", 63.1f);
        Language sql = new Language(3,"SQL", 54.7f);
        Language python = new Language(4,"Python", 44.1f);
        Language java = new Language(5, "Java", 40.2f);

        List<Language> list = new ArrayList<Language>();
        list.add(none);
        list.add(javascript);
        list.add(htmlCss);
        list.add(sql);
        list.add(python);
        list.add(java);

        return list;
    }
}
